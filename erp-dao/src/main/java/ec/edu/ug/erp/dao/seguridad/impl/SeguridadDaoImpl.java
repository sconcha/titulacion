package ec.edu.ug.erp.dao.seguridad.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.dto.seguridad.GenericSeguridadDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.dto.seguridad.RolDTO;
import ec.edu.ug.erp.dto.seguridad.TareaDTO;
import ec.edu.ug.erp.dto.seguridad.TareaRolDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioRolDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;
import ec.edu.ug.erp.util.crypto.CryptoUtils;
import ec.edu.ug.erp.util.dao.DAOUtils;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.DTOUtils;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;

/**
 * Implementacion de Capa de acceso a datos de para modulo de seguridad
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado Torres</a>
 * @since 2015-08-30
 * @version 1.0
 *
 */
@Repository("seguridadDao")
public class SeguridadDaoImpl extends GenericDAOImpl<GenericSeguridadDTO<?>> implements SeguridadDao {


	@Transactional(readOnly=true)
	public List<ModuloDTO> loadMenu(Tipo tipo, Object... filters)
			throws Exception {
		List<ModuloDTO> modulos;
		
		DetachedCriteria criteria= DetachedCriteria.forClass(ModuloDTO.class,ALIAS_MODULO);
		DAOUtils.addLeftJoins(criteria, FIELD_PADRE);
		criteria.add(Restrictions.eq(FIELD_TIPO, tipo));
		criteria.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));		
		criteria.addOrder(Order.asc(FIELD_ORDEN));
		
		modulos=findByCriteria(criteria);
		List<ModuloDTO> modulosPermitidos=new ArrayList<ModuloDTO>();
		for (Object filter : filters) {
			if(filter instanceof UsuarioSucursalDTO){
				modulosPermitidos=obtenerModulosPermitidos(modulos, (UsuarioSucursalDTO)filter);
			}
			
		}
		return modulosPermitidos.isEmpty()?modulos:modulosPermitidos;
	}
	
	private List<ModuloDTO> obtenerModulosPermitidos(List<ModuloDTO> modulos,UsuarioSucursalDTO usuarioAutenticado)throws Exception {
		List<ModuloDTO> result=new ArrayList<ModuloDTO>();
		List<ModuloDTO> modulosPermitidos=obtenerOpcionesPermitidas(usuarioAutenticado);		
		for (ModuloDTO modulo : modulos) {
			if(!modulo.getTipo().isOpcion()){
				List<ModuloDTO> modulosHijos=obtenerSubmodulos(modulo);
				if(!modulosHijos.isEmpty()){
					modulosHijos=obtenerModulosPermitidos(modulosHijos, usuarioAutenticado);
					if(!modulosHijos.isEmpty()){
						modulo.setModuloDTOs(modulosHijos);
						result.add(modulo);						
					}else if(modulosPermitidos.contains(modulo)){
						modulo.setModuloDTOs(new ArrayList<ModuloDTO>());
						result.add(modulo);
					}
				}else if(modulosPermitidos.contains(modulo)){
					modulo.setModuloDTOs(new ArrayList<ModuloDTO>());
					result.add(modulo);
				}
			}else{
				if(modulosPermitidos.contains(modulo)){
					modulo.setModuloDTOs(new ArrayList<ModuloDTO>());
					result.add(modulo);
				}
			}
		}		
		return result;
	}
	
	private List<ModuloDTO> obtenerSubmodulos(ModuloDTO moduloPadre)throws Exception {
		DetachedCriteria criteria= DetachedCriteria.forClass(ModuloDTO.class,ALIAS_MODULO);
		DAOUtils.addLeftJoins(criteria, FIELD_PADRE);
		criteria.add(Restrictions.eq(FIELD_PADRE, moduloPadre));
		criteria.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));
		criteria.addOrder(Order.asc(FIELD_ORDEN));
		return findByCriteria(criteria);
	}

	@Transactional(readOnly=true)
	public UsuarioDTO obtenerUsuarioSesion(UsuarioDTO usuario,EmpresaDTO empresa)
			throws Exception {		
		DetachedCriteria criteria=DetachedCriteria.forClass(UsuarioDTO.class, ALIAS_USUARIO);
		DAOUtils.addInnerJoins(criteria, FIELD_EMPRESA_PERSONA,ALIAS_EMPRESAPERSONA_TO_PERSONA,ALIAS_EMPRESAPERSONA_TO_EMPRESA);
		if(empresa!=null)
			criteria.add(Restrictions.eq(ALIAS_EMPRESAPERSONA_TO_EMPRESA, empresa));
		criteria.add(Restrictions.eq(FIELD_CODIGO, usuario.getCodigo()));

		List<UsuarioDTO> coincidencias=findByCriteria(criteria);
		
		UsuarioDTO usuarioResult=null;		
		for (UsuarioDTO user : coincidencias) {
			if(CryptoUtils.matches(usuario.getClave(), user.getClave()))
				usuarioResult=user;
		}		
		return usuarioResult;
	}


	@Transactional(readOnly=true)
	public List<ModuloDTO> obtenerOpcionesPermitidas(UsuarioSucursalDTO usuarioAutenticado) throws Exception {
		DetachedCriteria criteria;
		
		if(!DTOUtils.isPersistent(usuarioAutenticado))
			return new ArrayList<ModuloDTO>();
		
		//ROLES POR USUARIO
		List<UsuarioRolDTO> usuariosRol=new ArrayList<UsuarioRolDTO>();
		
		criteria=DetachedCriteria.forClass(UsuarioRolDTO.class, ALIAS_USUARIOROL);
		DAOUtils.addInnerJoins(criteria, FIELD_ROL,FIELD_USUARIO);
		criteria.add(Restrictions.eq(FIELD_USUARIO, usuarioAutenticado.getUsuario()));
		criteria.add(Restrictions.eq(FIELD_ESTADO, GenericDTO.Estado.ACTIVO));
		usuariosRol=findByCriteria(criteria);
		
		//TAREAS POR ROL
		List<TareaRolDTO> tareasRol=new ArrayList<TareaRolDTO>();
		
		for (UsuarioRolDTO usuarioRol : usuariosRol) {
			criteria=DetachedCriteria.forClass(TareaRolDTO.class, ALIAS_TAREAROL);
			DAOUtils.addInnerJoins(criteria, FIELD_TAREA,FIELD_ROL,ALIAS_TAREA_TO_MODULO);
			DAOUtils.addLeftJoins(criteria, FIELD_TAREAMODULO_PADRE);
			criteria.add(Restrictions.eq(FIELD_ROL,usuarioRol.getRol()));
			criteria.add(Restrictions.eq(FIELD_ESTADO, GenericDTO.Estado.ACTIVO));
			tareasRol.addAll(findByCriteria(criteria));			
		}
		
		//OPCIONES
		List<ModuloDTO> opcionesPermitidas=new ArrayList<ModuloDTO>();
		for (TareaRolDTO tareaRol : tareasRol) {
			opcionesPermitidas.add(tareaRol.getTarea().getModulo());
		}
		
		return opcionesPermitidas;
	}

	@Transactional(readOnly=true)
	public List<UsuarioSucursalDTO> obtenerUsuariosSucursal(UsuarioDTO usuario)
			throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(UsuarioSucursalDTO.class, ALIAS_USUARIOSUCURSAL);
		DAOUtils.addInnerJoins(criteria, FIELD_USUARIO,FIELD_SUCURSAL);
		criteria.add(Restrictions.eq(FIELD_USUARIO, usuario));
		criteria.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));		
		return findByCriteria(criteria);
	}

	@Transactional(readOnly=true)
	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario)
			throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(UsuarioSucursalDTO.class, ALIAS_USUARIOSUCURSAL);
		DAOUtils.addInnerJoins(criteria, FIELD_USUARIO,FIELD_SUCURSAL);
		criteria.add(Restrictions.eq(FIELD_USUARIO, usuario));
		criteria.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));
		criteria.add(Restrictions.eq(FIELD_PREDETERMINADO, true));
		return findFirstByCriteria(criteria);
	}
	
	@Transactional(readOnly=true)
	public UsuarioDTO findByUserName(String username) throws Exception{
		
		System.out.println("USER NAME FINDING... "+username);
		
		DetachedCriteria criteria=DetachedCriteria.forClass(UsuarioDTO.class,ALIAS_USUARIO);
		criteria.add(Restrictions.eq(FIELD_CODIGO, username));
		UsuarioDTO  usuario=findFirstByCriteria(criteria);
		List<UsuarioRolDTO> usuariosRol=new ArrayList<UsuarioRolDTO>();		
		criteria=DetachedCriteria.forClass(UsuarioRolDTO.class, ALIAS_USUARIOROL);
		DAOUtils.addInnerJoins(criteria, FIELD_ROL,FIELD_USUARIO);
		criteria.add(Restrictions.eq(FIELD_USUARIO, usuario));
		usuariosRol=findByCriteria(criteria);		
		usuario.setUsuarioRolDTOs(usuariosRol);		
		return usuario;
	}
	
	public Collection<RolDTO> findRolesByUrl(String url) throws Exception{
		
		System.out.println("URL: "+url);
		
		
		DetachedCriteria criteriaRol=DetachedCriteria.forClass(RolDTO.class, ALIAS_ROL);
		criteriaRol.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));
		
		DetachedCriteria criteriaTareaRol=DetachedCriteria.forClass(TareaRolDTO.class, ALIAS_TAREAROL);
		DAOUtils.addInnerJoins(criteriaTareaRol, FIELD_ROL,FIELD_TAREA);		
		criteriaTareaRol.add(Restrictions.eqProperty(ALIAS_TAREAROL+POINT+FIELD_ROL+POINT+FIELD_ID  , ALIAS_ROL+POINT+FIELD_ID));
		criteriaTareaRol.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));
		
		DetachedCriteria criteriaTarea=DetachedCriteria.forClass(TareaDTO.class, ALIAS_TAREA);
		DAOUtils.addInnerJoins(criteriaTarea, FIELD_MODULO);
		criteriaTarea.add(Restrictions.like(FIELD_MODULO+POINT+FIELD_ACIONLISTAR, url,MatchMode.END));
		criteriaTareaRol.add(Restrictions.eqProperty(FIELD_TAREA, ALIAS_TAREAROL+POINT+FIELD_TAREA ));
		criteriaTarea.add(Restrictions.eq(FIELD_ESTADO, Estado.ACTIVO));
		
		criteriaTareaRol.add(Subqueries.exists(criteriaTarea));
		criteriaRol.add(Subqueries.exists(criteriaTareaRol));
		
		List<RolDTO> roles=findByCriteria(criteriaRol);
		System.out.println("******************INI ROLES**********************");
		roles.forEach((r)->System.out.println(r));
		System.out.println("******************FIN ROLES**********************");
		
		return roles;
	}
	
	
	

	
	
	
}

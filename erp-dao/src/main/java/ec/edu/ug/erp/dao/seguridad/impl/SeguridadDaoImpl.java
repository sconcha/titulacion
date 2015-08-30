package ec.edu.ug.erp.dao.seguridad.impl;

import java.util.List;
import java.util.Objects;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.seguridad.GenericSeguridadDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

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
	public List<ModuloDTO> cargarModulosPorTipo(Tipo tipo, Objects... filters)
			throws Exception {
		DetachedCriteria criteria= DetachedCriteria.forClass(ModuloDTO.class,ALIAS_MODULO);
		criteria.add(Restrictions.eq(FIELD_TIPO, tipo));
		criteria.addOrder(Order.asc(FIELD_ORDEN));

		return findByCriteria(criteria);
	}

	
	@Transactional(readOnly=true)
	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario)
			throws Exception {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(UsuarioSucursalDTO.class, ALIAS_USUARIOSUCURSAL);
		criteria.createAlias(FIELD_USUARIO, FIELD_USUARIO, JoinType.INNER_JOIN);


		
		
		return null;
	}
	
	

	
	
	
}

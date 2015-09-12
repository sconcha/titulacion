package ec.edu.ug.erp.dao.administracion.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ug.erp.dao.administracion.AdministracionDao;
import ec.edu.ug.erp.dto.administracion.GenericAdministracionDTO;
import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.DTOUtils;

/**
 * Implementacion de Capa de acceso a datos de para modulo de admiinistracion
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado Torres</a>
 * @since 2015-08-30
 * @version 1.0
 *
 */
@Repository("adminDAO")
public class AdministracionDaoImpl extends GenericDAOImpl <GenericAdministracionDTO<?>>implements AdministracionDao{

	@Transactional(readOnly=true)
	public List<SucursalDTO> obtenerSucursalesUsuario(UsuarioDTO usuario)
			throws Exception {	
		if(DTOUtils.isNull(usuario)){
			return new ArrayList<SucursalDTO>();
		}		
		DetachedCriteria criteria=DetachedCriteria.forClass(SucursalDTO.class, ALIAS_SUCURSAL);
		
		
		
		return findByCriteria(criteria);
	}
	
}

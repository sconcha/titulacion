package ec.edu.ug.erp.dao.administracion;

import java.util.List;

import ec.edu.ug.erp.dto.administracion.GenericAdministracionDTO;
import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.util.dao.GenericDAO;


/**
 * Capa de acceso a datos de para modulo de admiinistracion
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado Torres</a>
 * @since 2015-08-30
 * @version 1.0
 *
 */
public interface AdministracionDao extends GenericDAO<GenericAdministracionDTO<?>>{

	public List<SucursalDTO>  obtenerSucursalesUsuario(UsuarioDTO usuario) throws Exception;
	
}

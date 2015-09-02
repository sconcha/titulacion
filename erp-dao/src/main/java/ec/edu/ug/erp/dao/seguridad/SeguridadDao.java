package ec.edu.ug.erp.dao.seguridad;

import java.util.List;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.dto.seguridad.GenericSeguridadDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;
import ec.edu.ug.erp.util.dao.GenericDAO;


/**
 * Capa de acceso a datos de para modulo de seguridad
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado Torres</a>
 * @since 2015-08-30
 * @version 1.0
 *
 */
public interface SeguridadDao extends GenericDAO<GenericSeguridadDTO<?>>{

	
	public List<ModuloDTO> loadMenu(Tipo tipo,Object...filters) throws Exception;	
	public UsuarioDTO obtenerUsuarioSesion(UsuarioDTO usuario,EmpresaDTO empresa) throws Exception;
	public List<ModuloDTO> obtenerOpcionesPermitidas(UsuarioSucursalDTO usuarioAutenticado) throws Exception;
	public List<UsuarioSucursalDTO> obtenerUsuariosSucursal(UsuarioDTO usuario) throws Exception;
	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario) throws Exception;
	public UsuarioDTO findByUserName(String username) throws Exception;
	
}

package ec.edu.ug.erp.servicio.seguridad;

import java.util.List;

import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;

/**
 * Capa de servicio para modulo de seguridad
 * 
 * @author Joel Alvarado
 * @since 2015-08-30
 * @version 1.o
 *
 */

public interface SeguridadService {
	
	public UsuarioDTO buscarUsuario(UsuarioDTO usuario) throws Exception;
	public List<SucursalDTO> obtenerSucursalesUsuario(UsuarioDTO usuario) throws Exception;
	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario) throws Exception;
	public ModuloDTO saveModulo(ModuloDTO modulo) throws Exception;
	public List<ModuloDTO> loadModuleList() throws Exception;
	public List<ModuloDTO> findMenuByModule(ModuloDTO modulo) throws Exception;

}

package ec.edu.ug.erp.servicio.seguridad;

import java.util.Collection;
import java.util.List;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.RolDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;

/**
 * Capa de servicio para modulo de seguridad
 * 
 * @author Joel Alvarado
 * @since 2015-08-30
 * @version 1.0
 *
 */

public interface SeguridadService {
	
	public UsuarioDTO obtenerUsuarioSesion(UsuarioDTO usuario,EmpresaDTO empresa)throws Exception ;
	public List<UsuarioSucursalDTO> obtenerUsuariosSucursal(UsuarioDTO usuario) throws Exception;
	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario) throws Exception;
	public ModuloDTO saveModulo(ModuloDTO modulo) throws Exception;
	public List<ModuloDTO> loadMenu(Object... filters) throws Exception;
	public List<ModuloDTO> obtenerOpcionesPermitidas(UsuarioSucursalDTO usuarioAutenticado) throws Exception;
	public Collection<RolDTO> findRolesByUrl(String url) throws Exception;

}

package ec.edu.ug.erp.servicio.seguridad.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;
/**
 * Implementacion de Capa de servicio para modulo de seguridad
 * 
 * @author Joel Alvarado
 * @since 2015-08-30
 * @version 1.o
 *
 */
@Service("seguridadService")
public class SeguridadServiceImpl implements SeguridadService {

	@Autowired
	private SeguridadDao seguridadDao;

	
	public UsuarioDTO buscarUsuario(UsuarioDTO usuario) throws Exception {
		return seguridadDao.findFirstByExample(usuario);
	}

	public List<SucursalDTO> obtenerSucursalesUsuario(UsuarioDTO usuario)
			throws Exception {
		
		
		return null;
	}

	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario)
			throws Exception {
		return null;
	}
	
	public ModuloDTO saveModulo(ModuloDTO modulo) throws Exception {
		seguridadDao.saveOrUpdate(modulo);
		return modulo;
	}

	public List<ModuloDTO> loadModuleList() throws Exception {		
		List<ModuloDTO> modulos=seguridadDao.cargarModulosPorTipo(Tipo.MODULO);		
		return modulos;
	}

	public List<ModuloDTO> findMenuByModule(ModuloDTO modulo) throws Exception {
		ModuloDTO filter=new ModuloDTO();
		filter.setPadre(modulo);
		List<ModuloDTO> modulos=seguridadDao.findByExample(filter);		
		return modulos;
	}

}

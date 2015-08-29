package ec.edu.ug.erp.servicio.seguridad.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;

@Service("seguridadService")
public class SeguridadServiceImpl implements SeguridadService {

	@Autowired
	private SeguridadDao seguridadDao;

	public ModuloDTO saveModulo(ModuloDTO modulo) throws Exception {
		seguridadDao.saveOrUpdate(modulo);
		return modulo;
	}

	public List<ModuloDTO> loadModuleList() throws Exception {		
		List<ModuloDTO> modulos=seguridadDao.obtenerModulosPadre(Tipo.MODULO);		
		return modulos;
	}

	public List<ModuloDTO> findMenuByModule(ModuloDTO modulo) throws Exception {
		ModuloDTO filter=new ModuloDTO();
		filter.setPadre(modulo);
		List<ModuloDTO> modulos=seguridadDao.findByExample(filter);		
		return modulos;
	}

}

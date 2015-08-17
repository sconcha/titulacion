package ec.edu.ug.erp.servicio.seguridad;

import java.util.List;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;


public interface SeguridadService {
	
	public ModuloDTO 	   saveModulo	    (ModuloDTO modulo) 	throws Exception;	
	public List<ModuloDTO> loadModuleList   () 					throws Exception;
	public List<ModuloDTO> findMenuByModule (ModuloDTO modulo)  throws Exception;

}

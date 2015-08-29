package ec.edu.ug.erp.dao.seguridad;

import java.util.List;
import java.util.Objects;

import ec.edu.ug.erp.dto.seguridad.GenericSeguridadDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.util.dao.GenericDAO;



public interface SeguridadDao extends GenericDAO<GenericSeguridadDTO<?>>{

	
	public List<ModuloDTO> obtenerModulosPadre(Tipo tipo,Objects...filters) throws Exception;
	
}

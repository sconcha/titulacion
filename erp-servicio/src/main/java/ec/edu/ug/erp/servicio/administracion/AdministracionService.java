package ec.edu.ug.erp.servicio.administracion;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;

public interface AdministracionService {
	
	public EmpresaDTO saveEmpresa(EmpresaDTO empresa) throws Exception;

}

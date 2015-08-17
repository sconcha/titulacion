package ec.edu.ug.erp.dao.administracion;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;

public interface AdministracionService {
	
	public EmpresaDTO saveEmpresa(EmpresaDTO empresa) throws Exception;

}

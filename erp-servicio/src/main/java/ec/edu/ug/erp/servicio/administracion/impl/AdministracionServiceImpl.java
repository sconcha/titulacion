package ec.edu.ug.erp.servicio.administracion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ug.erp.dao.administracion.AdministracionDao;
import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.servicio.administracion.AdministracionService;

@Service("administracionService")
public class AdministracionServiceImpl implements AdministracionService{
	
	@Autowired
	private AdministracionDao adminDao;
	
	@Transactional
	public EmpresaDTO saveEmpresa(EmpresaDTO empresa) throws Exception{
		return adminDao.findById(adminDao.save(empresa),EmpresaDTO.class);
	}

}

package ec.edu.ug.erp.servicio.contabilidad.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.contabilidad.ContabilidadDao;
import ec.edu.ug.erp.servicio.contabilidad.ContabilidadService;

@Service("contabilidadService")
public class ContabilidadServiceImpl implements ContabilidadService{
	
	@Autowired
	private ContabilidadDao contabilidadDao;
	

}

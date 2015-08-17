package ec.edu.ug.erp.servicio.facturacion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.facturacion.FacturacionDao;
import ec.edu.ug.erp.servicio.facturacion.FacturacionService;

@Service("facturacionService")
public class FacturacionServiceImpl implements FacturacionService{
	
	@Autowired
	private FacturacionDao facturacionDao;
	

}

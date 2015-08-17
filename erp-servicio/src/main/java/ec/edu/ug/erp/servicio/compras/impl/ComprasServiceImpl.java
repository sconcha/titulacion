package ec.edu.ug.erp.servicio.compras.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.compras.ComprasDao;
import ec.edu.ug.erp.servicio.compras.ComprasService;

@Service("comprasService")
public class ComprasServiceImpl implements ComprasService{
	
	@Autowired
	private ComprasDao comprasDao;
	

}

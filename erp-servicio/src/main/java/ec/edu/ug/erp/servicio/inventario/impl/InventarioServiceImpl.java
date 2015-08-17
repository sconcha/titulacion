package ec.edu.ug.erp.servicio.inventario.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.inventario.InventarioDao;
import ec.edu.ug.erp.servicio.inventario.InventarioService;

@Service("inventarioService")
public class InventarioServiceImpl implements InventarioService {

	@Autowired
	private InventarioDao inventarioDao;

}

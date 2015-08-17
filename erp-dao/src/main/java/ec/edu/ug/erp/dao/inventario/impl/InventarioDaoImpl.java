package ec.edu.ug.erp.dao.inventario.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.inventario.InventarioDao;
import ec.edu.ug.erp.dto.inventario.GenericInventarioDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("inventarioDAO")
public class InventarioDaoImpl extends GenericDAOImpl <GenericInventarioDTO<?>>implements InventarioDao{

}

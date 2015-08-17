package ec.edu.ug.erp.dao.inventario.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.inventario.InventarioDao;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Repository("inventarioDAO")
public class InventarioDaoImpl extends GenericDAOImpl <GenericDTO<?>>implements InventarioDao{

}

package ec.edu.ug.erp.dao.compras.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.compras.ComprasDao;
import ec.edu.ug.erp.dto.compras.GenericComprasDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("comprasDAO")
public class ComprasDaoImpl extends GenericDAOImpl <GenericComprasDTO<?>>implements ComprasDao{

}

package ec.edu.ug.erp.dao.compras.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.compras.ComprasDao;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Repository("comprasDAO")
public class ComprasDaoImpl extends GenericDAOImpl <GenericDTO<?>>implements ComprasDao{

}

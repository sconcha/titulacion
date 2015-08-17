package ec.edu.ug.erp.dao.facturacion.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.facturacion.FacturacionDao;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Repository("facturacionDAO")
public class FacturacionDaoImpl extends GenericDAOImpl <GenericDTO<?>>implements FacturacionDao{

}

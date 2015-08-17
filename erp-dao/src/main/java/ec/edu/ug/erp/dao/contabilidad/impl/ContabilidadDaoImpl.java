package ec.edu.ug.erp.dao.contabilidad.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.compras.ComprasDao;
import ec.edu.ug.erp.dao.contabilidad.ContabilidadDao;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Repository("contabilidadDAO")
public class ContabilidadDaoImpl extends GenericDAOImpl <GenericDTO<?>>implements ContabilidadDao{

}

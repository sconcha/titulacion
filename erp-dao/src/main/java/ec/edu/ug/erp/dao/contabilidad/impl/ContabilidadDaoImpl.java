package ec.edu.ug.erp.dao.contabilidad.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.contabilidad.ContabilidadDao;
import ec.edu.ug.erp.dto.contabilidad.GenericContabilidadDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("contabilidadDAO")
public class ContabilidadDaoImpl extends GenericDAOImpl <GenericContabilidadDTO<?>>implements ContabilidadDao{

}

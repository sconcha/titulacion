package ec.edu.ug.erp.dao.rrhh.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.rrhh.RrhhDao;
import ec.edu.ug.erp.dto.rrhh.GenericRrhhDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("rrhhDAO")
public class RrhhDaoImpl extends GenericDAOImpl <GenericRrhhDTO<?>>implements RrhhDao{

}

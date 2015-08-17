package ec.edu.ug.erp.dao.gerencial.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.gerencial.GerencialDao;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Repository("gerencialDAO")
public class GerencialDaoImpl extends GenericDAOImpl <GenericDTO<?>>implements GerencialDao{

}

package ec.edu.ug.erp.dao.gerencial.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.gerencial.GerencialDao;
import ec.edu.ug.erp.dto.gerencial.GenericGerencialDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("gerencialDAO")
public class GerencialDaoImpl extends GenericDAOImpl <GenericGerencialDTO<?>>implements GerencialDao{

}

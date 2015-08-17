package ec.edu.ug.erp.dao.general.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.general.GeneralDao;
import ec.edu.ug.erp.dto.general.GenericGeneralDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("generalDAO")
public class GeneralDaoImpl extends GenericDAOImpl <GenericGeneralDTO<?>>implements GeneralDao{

}

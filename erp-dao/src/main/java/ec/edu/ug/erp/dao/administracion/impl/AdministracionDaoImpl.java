package ec.edu.ug.erp.dao.administracion.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.administracion.AdministracionDao;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Repository("adminDAO")
public class AdministracionDaoImpl extends GenericDAOImpl <GenericDTO<?>>implements AdministracionDao{

}

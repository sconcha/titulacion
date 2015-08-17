package ec.edu.ug.erp.dao.administracion.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.administracion.AdministracionDao;
import ec.edu.ug.erp.dto.administracion.GenericAdministracionDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("adminDAO")
public class AdministracionDaoImpl extends GenericDAOImpl <GenericAdministracionDTO<?>>implements AdministracionDao{

}

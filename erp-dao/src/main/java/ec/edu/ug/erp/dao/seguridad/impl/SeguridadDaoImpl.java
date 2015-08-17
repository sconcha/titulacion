package ec.edu.ug.erp.dao.seguridad.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.seguridad.GenericSeguridadDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("seguridadDao")
public class SeguridadDaoImpl extends GenericDAOImpl<GenericSeguridadDTO<?>> implements SeguridadDao {

}

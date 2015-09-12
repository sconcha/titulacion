package ec.edu.ug.erp.dao.general.impl;

import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.general.GeneralDao;
import ec.edu.ug.erp.dto.general.GenericGeneralDTO;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

/**
 * Implementacion Capa de acceso a datos de para modulo de configuraciones generales
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado Torres</a>
 * @since 2015-08-30
 * @version 1.0
 *
 */
@Repository("generalDAO")
public class GeneralDaoImpl extends GenericDAOImpl <GenericGeneralDTO<?>>implements GeneralDao{

	
}

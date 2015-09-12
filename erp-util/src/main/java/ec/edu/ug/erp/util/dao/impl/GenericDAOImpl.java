package ec.edu.ug.erp.util.dao.impl;

import ec.edu.ug.erp.util.constantes.IConstantes;
import ec.edu.ug.erp.util.dao.GenericDAO;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

public class GenericDAOImpl<T extends GenericDTO<?>> extends BaseDaoHibernate<T, Long> implements GenericDAO<T> ,IConstantes{



}

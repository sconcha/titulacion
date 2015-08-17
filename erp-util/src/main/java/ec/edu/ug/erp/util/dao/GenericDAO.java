package ec.edu.ug.erp.util.dao;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

public interface GenericDAO<T extends GenericDTO<?>> extends BaseDao<T, Long> {

}

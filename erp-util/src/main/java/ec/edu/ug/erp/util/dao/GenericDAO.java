package ec.edu.ug.erp.util.dao;

import org.springframework.data.repository.NoRepositoryBean;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@NoRepositoryBean
public interface GenericDAO<T extends GenericDTO<?>> extends BaseDao<T, Long> {

}

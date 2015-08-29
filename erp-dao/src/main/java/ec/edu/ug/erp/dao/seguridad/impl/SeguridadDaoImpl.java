package ec.edu.ug.erp.dao.seguridad.impl;

import java.util.List;
import java.util.Objects;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.seguridad.GenericSeguridadDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("seguridadDao")
public class SeguridadDaoImpl extends GenericDAOImpl<GenericSeguridadDTO<?>> implements SeguridadDao {

	@Transactional(readOnly=true)
	public List<ModuloDTO> obtenerModulosPadre(Tipo tipo, Objects... filters)
			throws Exception {
		DetachedCriteria criteria= DetachedCriteria.forClass(ModuloDTO.class,ALIAS_MODULO);
		criteria.add(Restrictions.eq(FIELD_TIPO, tipo));
		criteria.addOrder(Order.asc(FIELD_ORDEN));

		return findByCriteria(criteria);
	}

	
	
	
}

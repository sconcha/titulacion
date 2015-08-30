package ec.edu.ug.erp.util.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.ug.erp.util.dao.BaseDao;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

/**
 * @author Joel Alvarado
 * @since 2015-08-11
 * @see <a
 *      href="http://www.genbetadev.com/java-j2ee/spring-framework-el-patrn-dao">http://www.genbetadev.com/java-j2ee/spring-framework-el-patrn-dao</a>
 * @see <a
 *      href="http://www.genbetadev.com/java-j2ee/spring-framework-el-patron-dao-ii">http://www.genbetadev.com/java-j2ee/spring-framework-el-patron-dao-ii</a>
 *
 */
@Component
@NoRepositoryBean
@Transactional(readOnly=false)
public abstract class BaseDaoHibernate<X extends GenericDTO<?>, E extends Serializable>
		extends HibernateDaoSupport implements BaseDao<X, E> {

	@Autowired
	public void initDao(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public <T extends X> void deleteAll(final Collection<T> instances)
			throws Exception {
		try {
			getHibernateTemplate().deleteAll(instances);
		} catch (final Exception e) {
			throw e;
		}
	}

	public int bulkUpdate(final String query) throws Exception {
		try {
			return getHibernateTemplate().bulkUpdate(query);
		} catch (final Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends X> E save(final T instance) throws Exception {
		try {
			return (E)getHibernateTemplate().save(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> void saveOrUpdateAll(final Collection<T> instances)
			throws Exception {
		try {
			for (T t : instances) {
				getHibernateTemplate().saveOrUpdate(t);
			}

		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> void saveOrUpdate(final T instance) throws Exception {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> void persist(final T transientInstance)
			throws Exception {
		try {
			getHibernateTemplate().persist(transientInstance);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> void attachDirty(final T instance) throws Exception {
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> void attachClean(final T instance) throws Exception {
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> void delete(final T persistentInstance)
			throws Exception {
		try {
			getHibernateTemplate().delete(persistentInstance);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> T merge(final T detachedInstance) throws Exception {
		try {
			final T result = getHibernateTemplate().merge(detachedInstance);
			return result;
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> List<T> findByExample(final T instance)
			throws Exception {
		try {
			final List<T> results = getHibernateTemplate().findByExample(
					instance);
			return results;
		} catch (final Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends X> List<T> findByQuery(final String queryString)
			throws Exception {
		try {
			final List<T> results = (List<T>) getHibernateTemplate().find(
					queryString);
			return results;
		} catch (final Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> findMapByQuery(final String queryString)
			throws Exception {
		try {
			final List<Map<String, Object>> results = (List<Map<String, Object>>) getHibernateTemplate()
					.find(queryString);
			return results;
		} catch (final Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends X> List<T> findByCriteria(final DetachedCriteria criteria)
			throws Exception {
		try {
			return (List<T>) getHibernateTemplate().findByCriteria(criteria);
		} catch (final Exception e) {
			throw e;
		}
	}

	public <T extends X> List<T> findAll(Class<T> clazz) throws Exception {
		return getHibernateTemplate().loadAll(clazz);
	}

	public <T extends X> T findById(E id, Class<T> clazz) throws Exception {
		return getHibernateTemplate().get(clazz, id);

	}
	
	public <T extends X> T findFirstByExample(final T instance) throws Exception {
		List<T> results=findByExample(instance);
		return (results!=null&&results.size()>0)?results.iterator().next():null;
	}
	
	
	
    public Session getActiveSession() {
        return currentSession();
    }

    public Object merge(Object entity) throws Exception {
            return this.getHibernateTemplate().merge(entity);
    }
    
	public void evict(Object pEntity){
		currentSession().evict(pEntity);
	}

	public void flush() {
		currentSession().flush();
	}

	public void refresh(Object pEntity)  {
		currentSession().refresh(pEntity);
	}

}

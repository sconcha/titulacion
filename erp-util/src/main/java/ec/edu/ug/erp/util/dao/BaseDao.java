package ec.edu.ug.erp.util.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Joel Alvarado
 * @since 2015-08-11
 * @see <a href="http://www.genbetadev.com/java-j2ee/spring-framework-el-patrn-dao">http://www.genbetadev.com/java-j2ee/spring-framework-el-patrn-dao</a>
 * @see <a href="http://www.genbetadev.com/java-j2ee/spring-framework-el-patron-dao-ii">http://www.genbetadev.com/java-j2ee/spring-framework-el-patron-dao-ii</a>
 *
 */
@NoRepositoryBean
public interface BaseDao<X extends Serializable, E> {

    public <T extends X> void deleteAll(Collection<T> instances) throws Exception;

    public <T extends X> int bulkUpdate(String query) throws Exception;

    public <T extends X> T save(T instance) throws Exception;

    public <T extends X> void saveOrUpdateAll(Collection<T> instances) throws Exception;

    public <T extends X> void saveOrUpdate(T instance) throws Exception;

    public <T extends X> void persist(T transientInstance) throws Exception;

    public <T extends X> void attachDirty(T instance) throws Exception;

    public <T extends X> void attachClean(T instance) throws Exception;

    public <T extends X> void delete(T persistentInstance) throws Exception;

    public <T extends X> List<T> findByExample(T instance) throws Exception;

    public <T extends X> List<T> findByQuery(String query) throws Exception;

    public <T extends X> List<Map<String, Object>> findMapByQuery(String queryString) throws Exception;

    public <T extends X> List<T> findByCriteria(DetachedCriteria criteria) throws Exception;

    public <T extends X> T merge(T detachedInstance) throws Exception;

    public <T extends X> List<T> findAll(Class<T> clazz) throws Exception;

    public <T extends X> T findById(E id,Class<T> clazz) throws Exception;
}

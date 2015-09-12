package ec.edu.ug.erp.util.dao;


import java.lang.reflect.Field;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.sql.JoinType;


/**
* Clase de utilidades para la capa de acceso a datos
* 
* @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado Torres</a>
* @since 2015-08-30
* @version 1.0
*
*/
public class DAOUtils {

	
	public static DetachedCriteria addInnerJoins(DetachedCriteria criteria,String... associationPaths ){
		return addJoins(criteria, JoinType.INNER_JOIN, associationPaths);
	}
	
	
	public static DetachedCriteria addLeftJoins(DetachedCriteria criteria,String... associationPaths ){
		return addJoins(criteria, JoinType.LEFT_OUTER_JOIN, associationPaths);
	}
	
	private static DetachedCriteria addJoins(DetachedCriteria criteria,JoinType joinType,String... associationPaths ){
		if(associationPaths!=null){
			for (String associationPath : associationPaths) {
				String[] tokens = associationPath.split("@");
				if (associationPath.length() == 0 || tokens.length > 2) {
					throw new IllegalArgumentException();
				}
				String path = tokens[0];
				String alias = tokens[tokens.length - 1];
				if (tokens.length == 1) {
					tokens = alias.split("\\.");
					alias = tokens[tokens.length - 1];
				}
				criteria.createAlias(path, alias, joinType).setFetchMode(path, FetchMode.JOIN);
			}
		}
		return criteria;
	}
	
	
	/**
	 * @author Joel Alvarado
	 * @param clazz
	 * @param instance
	 * @see http://stackoverflow.com/questions/24327353/initialize-all-lazy-loaded-collections-in-hibernate
	 */
	public static <T> void forceLoadLazyCollections(Class<T> clazz, T instance) {
        if (instance == null) {
            return;
        }
        for (Field field : clazz.getDeclaredFields()) {
            LazyCollection annotation = field.getAnnotation(LazyCollection.class);
            if (annotation != null) {
                try {
                    field.setAccessible(true);
                    Hibernate.initialize(field.get(instance));
                } catch (IllegalAccessException e) {
                    System.err.println("No se puede forzar la carga del la colleccion: " + field.getName());
                }
            }
        }
    }
	
}

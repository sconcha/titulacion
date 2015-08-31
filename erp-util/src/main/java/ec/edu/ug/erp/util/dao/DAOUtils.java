package ec.edu.ug.erp.util.dao;


import org.hibernate.FetchMode;
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
	
}

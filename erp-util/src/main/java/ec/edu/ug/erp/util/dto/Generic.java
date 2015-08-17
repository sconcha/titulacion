package ec.edu.ug.erp.util.dto;


/**
 * 
 * @author Joel ALvarado
 *
 * Clase generica para base de los DTO's
 *
 * @param <K>
 * @param <V>
 */
public interface Generic<K,V> {
	
	public K getKey();
	public V getValue();

	

}

package edu.ug.util.dto;

import java.io.Serializable;

/**
 * 
 * @author Joel ALvarado
 *
 * Clase generica para base de los DTO's
 *
 * @param <K>
 * @param <V>
 */
public abstract class Generic<K,V> implements Serializable {
	
	private static final long serialVersionUID = -6522384675531138186L;
	private K key;
	private V value;

	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}

	

}

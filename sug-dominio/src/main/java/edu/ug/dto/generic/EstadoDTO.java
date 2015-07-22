package edu.ug.dto.generic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.IGenericDTO;
import edu.ug.util.dto.Generic;

@Entity
@Table(name = "UGENTESTADO")
public class EstadoDTO extends Generic<String, String> implements
		IGenericDTO<String> {

	private static final long serialVersionUID = -1187274462856774150L;

	@Id
	@Column(name = "ID")
	private String id;	
	@Column(name = "DESCRIPCION")
	private String descripcion;	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	@Override
	public String getKey() {
		return getId();
	}
	
	@Override
	public String getValue() {
		return getDescripcion();
	}

}

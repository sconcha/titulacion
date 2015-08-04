package edu.ug.dto.generic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.IGenericDTO;
import edu.ug.util.dto.Generic;

@Entity
@Table(name = "UGENTESTADO")
public class EstadoDTO extends Generic<String, String> implements
		IGenericDTO<Long> {

	private static final long serialVersionUID = -1187274462856774150L;

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name="IDGENESTADO",sequenceName="UGENSESTADO",schema="SUGGEN",initialValue=1)
	@GeneratedValue(generator="IDGENESTADO",strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "ID",unique=true)	
	private String codigo;
	@Column(name = "DESCRIPCION")
	private String descripcion;	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
		return getCodigo();
	}
	
	@Override
	public String getValue() {
		return getDescripcion();
	}

}

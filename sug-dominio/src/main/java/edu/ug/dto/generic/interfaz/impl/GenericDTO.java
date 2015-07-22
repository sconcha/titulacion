package edu.ug.dto.generic.interfaz.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import edu.ug.dto.generic.EstadoDTO;
import edu.ug.dto.generic.interfaz.IGenericDTO;
import edu.ug.util.dto.Generic;

@MappedSuperclass
public class GenericDTO<ID> extends Generic<String, String> implements
		IGenericDTO<ID> {
	private static final long serialVersionUID = -374580369079967296L;

	@Id
	protected ID id;
	@Column(name = "CODIGO")
	protected String codigo;
	@Column(name = "DESCRIPCION")
	protected String descripcion;
	@Column(name = "FECHACREACION")
	protected Date fechaCreacion;
	@Column(name = "FECHAACTUALIZACION")
	protected Date fechaActualizacion;
	@JoinColumn(name = "ESTADO")
	@ManyToOne(fetch=FetchType.EAGER)
	protected EstadoDTO estado;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
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

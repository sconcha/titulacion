package edu.ug.dto.generic.interfaz.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import edu.ug.dto.generic.EstadoDTO;
import edu.ug.dto.generic.interfaz.IGenericDTO;
import edu.ug.util.dto.Generic;

@MappedSuperclass
public class GenericDTO<ID> extends Generic<String, String> implements
		IGenericDTO<ID> {
	private static final long serialVersionUID = -374580369079967296L;

	@Id
	@GenericGenerator(name = "IDGENSEQTABLE", strategy = "enhanced-table", parameters = {
            @org.hibernate.annotations.Parameter(name = "TABLA", value = "SEQUENCIA")
    })
    @GeneratedValue(generator = "IDGENSEQTABLE", strategy=GenerationType.TABLE)
	protected ID id;
	
	@Column(name = "CODIGO")
	protected String codigo;
	
	@Column(name = "DESCRIPCION")
	protected String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHACREACION")
	protected Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
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

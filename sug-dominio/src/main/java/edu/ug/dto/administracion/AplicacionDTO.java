package edu.ug.dto.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;

@Entity
@Table(name="UADMTAPLICACION")
public class AplicacionDTO  extends GenericDTO<Long>  {

	private static final long serialVersionUID = -5420849907557833766L;

	@Column(name="NOMBRE")
	private String nombre;
	
	@JoinColumn(name="SISTEMA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private SistemaDTO sistema;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public SistemaDTO getSistema() {
		return sistema;
	}
	public void setSistema(SistemaDTO sistema) {
		this.sistema = sistema;
	}
	
}

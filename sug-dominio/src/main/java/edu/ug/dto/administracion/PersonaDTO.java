package edu.ug.dto.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;

@Entity
@Table(name="UADMTPERSONA")
public class PersonaDTO extends GenericDTO<Long> {

	private static final long serialVersionUID = -5170427302770951584L;
	
	@Column(name="IDENTIFICACION")	
	private String identificacion;
	
	@Column(name="APELLIDOPATERNO")
	private String apellidopaterno;
	
	@Column(name="APELLIDOMATERNO")
	private String apellidomaterno;
	
	@Column(name="NOMBRES")
	private String nombres;
	
	@Column(name="RAZONSOCIAL")
	private String razonSocial;

	
	
	
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
		
}

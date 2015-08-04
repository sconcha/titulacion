package edu.ug.dto.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;


@Entity
@Table(name="UADMTEMPRESA")
public class EmpresaDTO extends GenericDTO<Long> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Column(name="NOMBRE")
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

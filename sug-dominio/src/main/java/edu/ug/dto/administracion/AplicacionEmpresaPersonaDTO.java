package edu.ug.dto.administracion;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;


@Entity
@Table(name="UADMTAPLICACIONEMPRESAPERSONA")
public class AplicacionEmpresaPersonaDTO extends GenericDTO<Long> {

	private static final long serialVersionUID = -1889501347202606778L;
	
	@JoinColumn(name="APLICACIONEMPRESA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private AplicacionEmpresaDTO aplicacionEmpresa;
	
	@JoinColumn(name="PERSONA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private PersonaDTO persona;

}

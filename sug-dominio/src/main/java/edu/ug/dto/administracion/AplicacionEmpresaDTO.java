package edu.ug.dto.administracion;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;

@Entity
@Table(name="UADMTAPLICACION_EMPRESA")
public class AplicacionEmpresaDTO extends GenericDTO<Long>  {

	private static final long serialVersionUID = 8904809113546275416L;
	
	@JoinColumn(name="APLICACION_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private AplicacionDTO aplicacion;
	
	@JoinColumn(name="EMPRESA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaDTO empresa;
	
	public AplicacionDTO getAplicacion() {
		return aplicacion;
	}
	public void setAplicacion(AplicacionDTO aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	public EmpresaDTO getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}
	

}

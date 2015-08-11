package ec.edu.ug.chamaleon.dto.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import ec.edu.ug.chamaleon.util.dto.generic.interfaz.impl.GenericDTO;
import ec.edu.ug.chamaleon.util.type.BooleanToCharType;


@Entity
@Table(name="UADMTEMPRESA_PERSONA")
public class EmpresaPersonaDTO extends GenericDTO<EmpresaPersonaDTO> {

	private static final long serialVersionUID = -1889501347202606778L;
	
	
	@Id
	@SequenceGenerator(name = "SG_EMPRESAPERSONA", sequenceName = "UADMSEMPRESA_PERSONA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_EMPRESAPERSONA")
	private Long id;

	@Column(name="CODIGO")
	private String codigo;
	
	@JoinColumn(name="EMPRESA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaDTO empresa;
	
	@JoinColumn(name="PERSONA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private PersonaDTO persona;
	
	@Column(name="ESCLIENTE")
	@Type(type=BooleanToCharType.TYPE)
	private boolean cliente;
	
	@Column(name="ESPROVEEDOR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean proveedor;
	
	@Column(name="ESEMPLEADO")
	@Type(type=BooleanToCharType.TYPE)
	private boolean empleado;

	public Long getId() {		
		return id;
	}

	public void setId(Long id) {
		this.id=id;		
	}

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public void setCodigo(String codigo) {
		this.codigo=codigo;		
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	

}
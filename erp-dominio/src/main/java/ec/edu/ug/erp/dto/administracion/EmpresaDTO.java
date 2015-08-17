package ec.edu.ug.erp.dto.administracion;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;


@Entity
@Table(name="UADMTEMPRESA")
public class EmpresaDTO extends GenericDTO<EmpresaDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_EMPRESA", sequenceName = "UADMSEMPRESA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_EMPRESA")
	private Long id;

	@Column(name="CODIGO",length=10)
	private String codigo;
	
	@JoinColumn(name="PERSONA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private PersonaDTO persona;
	
	@Column(name="RUTALOGO",length=300)
	private String rutaLogo;
	
	@Column(name="URL",length=300)
	private String url;
	
	@OneToMany(mappedBy="empresa",fetch=FetchType.LAZY)
	private List<AlmacenDTO> almacenesEmpresa;

	@OneToMany(mappedBy="empresa",fetch=FetchType.LAZY)
	private List<EmpresaPersonaDTO> empresaPersonaDTOs;

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

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	public String getRutaLogo() {
		return rutaLogo;
	}

	public void setRutaLogo(String rutaLogo) {
		this.rutaLogo = rutaLogo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<AlmacenDTO> getAlmacenesEmpresa() {
		return almacenesEmpresa;
	}

	public void setAlmacenesEmpresa(List<AlmacenDTO> almacenesEmpresa) {
		this.almacenesEmpresa = almacenesEmpresa;
	}
	
	public List<EmpresaPersonaDTO> getEmpresaPersonaDTOs() {
		return empresaPersonaDTOs;
	}
	
	public void setEmpresaPersonaDTOs(List<EmpresaPersonaDTO> empresaPersonaDTOs) {
		this.empresaPersonaDTOs = empresaPersonaDTOs;
	}

}

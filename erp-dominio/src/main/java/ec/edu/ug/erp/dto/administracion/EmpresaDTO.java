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

import ec.edu.ug.erp.dto.rrhh.EmpresaPersonaDTO;
import ec.edu.ug.erp.dto.rrhh.PersonaDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;


@Entity
@Table(name=ITableNames.EMPRESA,schema=ISchemaNames.ADMINISTRACION)
public class EmpresaDTO extends GenericAdministracionDTO<EmpresaDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.EMPRESA, sequenceName = ISequenceTables.EMPRESA, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.EMPRESA)
	private Long id;

	@Column(name=CODIGO,length=10)
	private String codigo;
	
	@JoinColumn(name=PERSONA_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private PersonaDTO persona;
	
	@Column(name=RUTALOGO,length=300)
	private String rutaLogo;
	
	@Column(name=URL,length=300)
	private String url;
	
	@OneToMany(mappedBy=FIELD_EMPRESA,fetch=FetchType.LAZY)
	private List<SucursalDTO> almacenesEmpresa;

	@OneToMany(mappedBy=FIELD_EMPRESA,fetch=FetchType.LAZY)
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

	public List<SucursalDTO> getAlmacenesEmpresa() {
		return almacenesEmpresa;
	}

	public void setAlmacenesEmpresa(List<SucursalDTO> almacenesEmpresa) {
		this.almacenesEmpresa = almacenesEmpresa;
	}
	
	public List<EmpresaPersonaDTO> getEmpresaPersonaDTOs() {
		return empresaPersonaDTOs;
	}
	
	public void setEmpresaPersonaDTOs(List<EmpresaPersonaDTO> empresaPersonaDTOs) {
		this.empresaPersonaDTOs = empresaPersonaDTOs;
	}

}

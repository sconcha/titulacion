package ec.edu.ug.erp.dto.seguridad;

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
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;

@Entity
@Table(name=ITableNames.USUARIO,schema=ISchemaNames.SEGURIDAD)
public class UsuarioDTO extends GenericSeguridadDTO<UsuarioDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.USUARIO, sequenceName = ISequenceTables.USUARIO, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.USUARIO)
	private Long id;
	
	@JoinColumn(name=EMPRESAPERSONA_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaPersonaDTO empresaPersona;

	@Column(name=CODIGO,length=50)
	private String codigo;
	
	@Column(name=CLAVE,length=100)
	private String clave;
	
	@OneToMany(mappedBy=FIELD_USUARIO,fetch=FetchType.LAZY)
	private List<UsuarioSucursalDTO> usuarioAlmacenDTOs;
	
	@OneToMany(mappedBy=FIELD_USUARIO,fetch=FetchType.LAZY)
	private List<UsuarioRolDTO> usuarioRolDTOs;
	
	
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

	public EmpresaPersonaDTO getEmpresaPersona() {
		return empresaPersona;
	}

	public void setEmpresaPersona(EmpresaPersonaDTO empresaPersona) {
		this.empresaPersona = empresaPersona;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public List<UsuarioSucursalDTO> getUsuarioAlmacenDTOs() {
		return usuarioAlmacenDTOs;
	}

	public void setUsuarioAlmacenDTOs(List<UsuarioSucursalDTO> usuarioAlmacenDTOs) {
		this.usuarioAlmacenDTOs = usuarioAlmacenDTOs;
	}

	public List<UsuarioRolDTO> getUsuarioRolDTOs() {
		return usuarioRolDTOs;
	}

	public void setUsuarioRolDTOs(List<UsuarioRolDTO> usuarioRolDTOs) {
		this.usuarioRolDTOs = usuarioRolDTOs;
	}

}

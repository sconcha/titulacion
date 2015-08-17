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

import ec.edu.ug.erp.dto.administracion.EmpresaPersonaDTO;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

@Entity
@Table(name="USEGTUSUARIO")
public class UsuarioDTO extends GenericDTO<UsuarioDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_USUARIO", sequenceName = "USEGSUSUARIO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_USUARIO")
	private Long id;
	
	@JoinColumn(name="EMPRESAPERSONA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaPersonaDTO empresaPersona;

	@Column(name="CODIGO",length=50)
	private String codigo;
	
	@Column(name="CLAVE",length=100)
	private String clave;
	
	@OneToMany(mappedBy="usuario",fetch=FetchType.LAZY)
	private List<UsuarioAlmacenDTO> usuarioAlmacenDTOs;
	
	@OneToMany(mappedBy="usuario",fetch=FetchType.LAZY)
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

	public List<UsuarioAlmacenDTO> getUsuarioAlmacenDTOs() {
		return usuarioAlmacenDTOs;
	}

	public void setUsuarioAlmacenDTOs(List<UsuarioAlmacenDTO> usuarioAlmacenDTOs) {
		this.usuarioAlmacenDTOs = usuarioAlmacenDTOs;
	}

	public List<UsuarioRolDTO> getUsuarioRolDTOs() {
		return usuarioRolDTOs;
	}

	public void setUsuarioRolDTOs(List<UsuarioRolDTO> usuarioRolDTOs) {
		this.usuarioRolDTOs = usuarioRolDTOs;
	}
	
	
	


}

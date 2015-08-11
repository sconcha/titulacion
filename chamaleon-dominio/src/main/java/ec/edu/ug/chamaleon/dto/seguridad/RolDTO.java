package ec.edu.ug.chamaleon.dto.seguridad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.ug.chamaleon.util.dto.generic.interfaz.impl.GenericDTO;

@Entity
@Table(name="USEGTROL")
public class RolDTO extends GenericDTO<RolDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_ROL", sequenceName = "USEGSROL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_ROL")
	private Long id;
	
	@Column(name="CODIGO",length=50)
	private String codigo;
	
	@OneToMany(mappedBy="rol",fetch=FetchType.LAZY)
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

	public List<UsuarioRolDTO> getUsuarioRolDTOs() {
		return usuarioRolDTOs;
	}

	public void setUsuarioRolDTOs(List<UsuarioRolDTO> usuarioRolDTOs) {
		this.usuarioRolDTOs = usuarioRolDTOs;
	}

	

}

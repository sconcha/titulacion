package ec.edu.ug.erp.dto.seguridad;

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

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.GrantedAuthority;

import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;

@Entity
@Table(name=ITableNames.ROL,schema=ISchemaNames.SEGURIDAD)
public class RolDTO extends GenericSeguridadDTO<RolDTO> implements GrantedAuthority,ConfigAttribute {
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.ROL, sequenceName = ISequenceTables.ROL, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.ROL)
	private Long id;
	
	@Column(name=CODIGO,length=50)
	private String codigo;
	
	@OneToMany(mappedBy=FIELD_ROL,fetch=FetchType.LAZY)
	private List<UsuarioRolDTO> usuarioRolDTOs;
	
	@OneToMany(mappedBy=FIELD_ROL,fetch=FetchType.LAZY)
	private List<TareaRolDTO> tareaRolDTOs;
	
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

	public List<TareaRolDTO> getTareaRolDTOs() {
		return tareaRolDTOs;
	}

	public void setTareaRolDTOs(List<TareaRolDTO> tareaRolDTOs) {
		this.tareaRolDTOs = tareaRolDTOs;
	}

	@Override
	public String getAuthority() {
		return getCodigo();
	}

	@Override
	public String getAttribute() {
		return getCodigo();
	}

	

}

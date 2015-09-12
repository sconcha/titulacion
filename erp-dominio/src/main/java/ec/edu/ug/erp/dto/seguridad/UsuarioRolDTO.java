package ec.edu.ug.erp.dto.seguridad;

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

import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;

@Entity
@Table(name=ITableNames.USUARIO_ROL,schema=ISchemaNames.SEGURIDAD)
public class UsuarioRolDTO extends GenericSeguridadDTO<UsuarioRolDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.USUARIO_ROL, sequenceName = ISequenceTables.USUARIO_ROL, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.USUARIO_ROL)
	private Long id;
	
	@JoinColumn(name=USUARIO_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private UsuarioDTO usuario;
	
	@JoinColumn(name=ROL_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private RolDTO rol;
	
	@JoinColumn(name=SUCURSAL_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private SucursalDTO sucursal;
	
	@Column(name=CODIGO,length=50)
	private String codigo;
	
	
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

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	public SucursalDTO getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	

}

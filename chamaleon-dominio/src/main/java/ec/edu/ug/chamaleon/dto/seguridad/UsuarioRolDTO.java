package ec.edu.ug.chamaleon.dto.seguridad;

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

import ec.edu.ug.chamaleon.dto.administracion.AlmacenDTO;
import ec.edu.ug.chamaleon.util.dto.generic.interfaz.impl.GenericDTO;

@Entity
@Table(name="USEGTUSUARIO_ROL")
public class UsuarioRolDTO extends GenericDTO<UsuarioRolDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_ROL", sequenceName = "USEGSROL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_ROL")
	private Long id;
	
	@JoinColumn(name="USUARIO_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private UsuarioDTO usuario;
	
	@JoinColumn(name="ROL")
	@ManyToOne(fetch=FetchType.LAZY)
	private RolDTO rol;
	
	@JoinColumn(name="ALMACEN")
	@ManyToOne(fetch=FetchType.LAZY)
	private AlmacenDTO almacen;
	
	@Column(name="CODIGO",length=50)
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

	public AlmacenDTO getAlmacen() {
		return almacen;
	}

	public void setAlmacen(AlmacenDTO almacen) {
		this.almacen = almacen;
	}

	

}

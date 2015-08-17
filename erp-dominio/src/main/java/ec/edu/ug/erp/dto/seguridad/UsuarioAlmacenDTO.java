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

import org.hibernate.annotations.Type;

import ec.edu.ug.erp.dto.administracion.AlmacenDTO;
import ec.edu.ug.erp.util.type.BooleanToCharType;

@Entity
@Table(name="USEGTUSUARIO_ALMACEN")
public class UsuarioAlmacenDTO extends GenericSeguridadDTO<UsuarioAlmacenDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_USUARIO_ALMACEN", sequenceName = "USEGSUSUARIO_ALMACEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_USUARIO_ALMACEN")
	private Long id;
	
	@JoinColumn(name="USUARIO_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private UsuarioDTO usuario;

	@JoinColumn(name="ALMACEN_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private AlmacenDTO almacen;
	
	@Column(name="PREDETERMINADO",length=1)
	@Type(type=BooleanToCharType.TYPE)
	private boolean predeterminado;

	
	public Long getId() {		
		return id;
	}

	public void setId(Long id) {
		this.id=id;		
	}

	@Override
	public String getCodigo() {
		return id.toString();
	}

	@Override
	public void setCodigo(String codigo) {
				
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public AlmacenDTO getAlmacen() {
		return almacen;
	}

	public void setAlmacen(AlmacenDTO almacen) {
		this.almacen = almacen;
	}

	public boolean isPredeterminado() {
		return predeterminado;
	}

	public void setPredeterminado(boolean predeterminado) {
		this.predeterminado = predeterminado;
	}


	


}

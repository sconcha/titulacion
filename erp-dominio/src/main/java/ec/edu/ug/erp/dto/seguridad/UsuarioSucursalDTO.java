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

import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;
import ec.edu.ug.erp.util.type.BooleanToCharType;

@Entity
@Table(name=ITableNames.USUARIO_SUCURSAL,schema=ISchemaNames.SEGURIDAD)
public class UsuarioSucursalDTO extends GenericSeguridadDTO<UsuarioSucursalDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.USUARIO_SUCURSAL, sequenceName = ISequenceTables.USUARIO_SUCURSAL, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.USUARIO_SUCURSAL)
	private Long id;
	
	@JoinColumn(name=USUARIO_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private UsuarioDTO usuario;

	@JoinColumn(name=SUCURSAL_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private SucursalDTO sucursal;
	
	@Column(name=PREDETERMINADO,length=1)
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

	public SucursalDTO getSucursal() {
		return sucursal;
	}
	
	public void setSucursal(SucursalDTO sucursal) {
		this.sucursal = sucursal;
	}

	public boolean isPredeterminado() {
		return predeterminado;
	}

	public void setPredeterminado(boolean predeterminado) {
		this.predeterminado = predeterminado;
	}


	


}

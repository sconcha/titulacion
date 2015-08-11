package ec.edu.ug.chamaleon.dto.seguridad;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.ug.chamaleon.util.dto.generic.impl.GenericDTO;

@Entity
@Table(name="USEGTTAREA_ROL")
public class TareaRolDTO extends GenericDTO<TareaRolDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_ROL", sequenceName = "USEGSROL", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_ROL")
	private Long id;
	
	@JoinColumn(name="TAREA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private TareaDTO tarea;
	
	@JoinColumn(name="ROL")
	@ManyToOne(fetch=FetchType.LAZY)
	private RolDTO rol;
	
	
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

	public TareaDTO getTarea() {
		return tarea;
	}

	public void setTarea(TareaDTO tarea) {
		this.tarea = tarea;
	}

	public RolDTO getRol() {
		return rol;
	}

	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	

}

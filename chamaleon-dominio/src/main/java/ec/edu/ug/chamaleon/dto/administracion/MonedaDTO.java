package ec.edu.ug.chamaleon.dto.administracion;

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

import org.hibernate.annotations.Type;

import ec.edu.ug.chamaleon.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.chamaleon.util.type.BooleanToCharType;


@Entity
@Table(name="UADMTMONEDA")
public class MonedaDTO extends GenericDTO<MonedaDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_MONEDA", sequenceName = "UADMSMONEDA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_MONEDA")
	private Long id;

	@Column(name="CODIGO")
	private String codigo;
	
	@Column(name="SIMBOLO")
	private String simbolo;
	
	@Column(name="LOCAL")
	@Type(type=BooleanToCharType.TYPE)
	private boolean local;

	@OneToMany(mappedBy="moneda",fetch=FetchType.LAZY)
	private List<DivisionGeograficaDTO> divisionGeograficaDTOs;
	
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

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
	}
		
	public List<DivisionGeograficaDTO> getDivisionGeograficaDTOs() {
		return divisionGeograficaDTOs;
	}
	
	public void setDivisionGeograficaDTOs(
			List<DivisionGeograficaDTO> divisionGeograficaDTOs) {
		this.divisionGeograficaDTOs = divisionGeograficaDTOs;
	}


	

}

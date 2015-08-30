package ec.edu.ug.erp.dto.general;

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

import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;
import ec.edu.ug.erp.util.type.BooleanToCharType;


@Entity
@Table(name=ITableNames.MONEDA,schema=ISchemaNames.GENERAL)
public class MonedaDTO extends GenericGeneralDTO<MonedaDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.MONEDA, sequenceName = ISequenceTables.MONEDA, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.MONEDA)
	private Long id;

	@Column(name=CODIGO)
	private String codigo;
	
	@Column(name=SIMBOLO)
	private String simbolo;
	
	@Column(name=LOCAL)
	@Type(type=BooleanToCharType.TYPE)
	private boolean local;

	@OneToMany(mappedBy=FIELD_MONEDA,fetch=FetchType.LAZY)
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

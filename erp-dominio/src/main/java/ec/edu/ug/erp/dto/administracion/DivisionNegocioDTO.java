package ec.edu.ug.erp.dto.administracion;

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

import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;


@Entity
@Table(name=ITableNames.DIVISION_NEGOCIO,schema=ISchemaNames.ADMINISTRACION)
public class DivisionNegocioDTO extends GenericAdministracionDTO<DivisionNegocioDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.DIVISION_NEGOCIO, sequenceName = ISequenceTables.DIVISION_NEGOCIO, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.DIVISION_NEGOCIO)
	private Long id;

	@Column(name=CODIGO,length=10)
	private String codigo;
	
	@JoinColumn(name=PADRE_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private DivisionNegocioDTO padre;
	
	@Column(name=NIVEL)
	private Integer nivel;
	
	@OneToMany(mappedBy=FIELD_PADRE,fetch=FetchType.LAZY)
	private List<DivisionNegocioDTO> divisionNegocioDTOs;

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

	public DivisionNegocioDTO getPadre() {
		return padre;
	}

	public void setPadre(DivisionNegocioDTO padre) {
		this.padre = padre;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public List<DivisionNegocioDTO> getDivisionNegocioDTOs() {
		return divisionNegocioDTOs;
	}

	public void setDivisionNegocioDTOs(List<DivisionNegocioDTO> divisionNegocioDTOs) {
		this.divisionNegocioDTOs = divisionNegocioDTOs;
	}
	
	


}

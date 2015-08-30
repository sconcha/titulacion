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

import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;


@Entity
@Table(name=ITableNames.REGION,schema=ISchemaNames.GENERAL)
public class RegionDTO extends GenericGeneralDTO<RegionDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.REGION, sequenceName = ISequenceTables.REGION, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.REGION)
	private Long id;

	@Column(name=CODIGO)
	private String codigo;
	
	@OneToMany(mappedBy=FIELD_REGION,fetch=FetchType.LAZY)
	private List<SucursalDTO> almacenesRegion;

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
	

}

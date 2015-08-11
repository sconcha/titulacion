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

import ec.edu.ug.chamaleon.util.dto.generic.interfaz.impl.GenericDTO;


@Entity
@Table(name="UADMTREGION")
public class RegionDTO extends GenericDTO<RegionDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_REGION", sequenceName = "UADMSREGION", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_REGION")
	private Long id;

	@Column(name="CODIGO")
	private String codigo;
	
	@OneToMany(mappedBy="region",fetch=FetchType.LAZY)
	private List<AlmacenDTO> almacenesRegion;

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

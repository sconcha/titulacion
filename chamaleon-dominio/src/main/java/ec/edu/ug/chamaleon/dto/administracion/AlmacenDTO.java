package ec.edu.ug.chamaleon.dto.administracion;

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

import ec.edu.ug.chamaleon.util.dto.generic.interfaz.impl.GenericDTO;


@Entity
@Table(name="UADMTALMACEN")
public class AlmacenDTO extends GenericDTO<AlmacenDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_ALMACEN", sequenceName = "UADMSALMACEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_ALMACEN")
	private Long id;

	@JoinColumn(name="EMPRESA_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaDTO empresa;
	
	@JoinColumn(name="REGION_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private RegionDTO region;
	
	@JoinColumn(name="CIUDAD_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private DivisionGeograficaDTO ciudad;
	
	@Column(name="CODIGO",length=10)
	private String codigo;
	
	@Column(name="DIRECCION",length=200)
	private String direccion;
	
	@Column(name="TELEFONO",length=200)
	private String telefono;
	
	@Column(name="FAX",length=200)
	private String fax;
	
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

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public RegionDTO getRegion() {
		return region;
	}

	public void setRegion(RegionDTO region) {
		this.region = region;
	}

	public DivisionGeograficaDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(DivisionGeograficaDTO ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	

}

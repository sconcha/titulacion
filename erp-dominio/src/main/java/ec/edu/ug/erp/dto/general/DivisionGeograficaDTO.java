package ec.edu.ug.erp.dto.general;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

import org.hibernate.annotations.Type;

import ec.edu.ug.erp.dto.administracion.SucursalDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;
import ec.edu.ug.erp.util.type.StringValuedEnum;
import ec.edu.ug.erp.util.type.StringValuedEnumReflect;
import ec.edu.ug.erp.util.type.StringValuedEnumType;


/**
 * 
 * @author Joel Alvarado
 * @since 2015-08-10
 *
 */

@Entity
@Table(name=ITableNames.DIVISION_GEOGRAFICA,schema=ISchemaNames.GENERAL)
public class DivisionGeograficaDTO extends GenericGeneralDTO<DivisionGeograficaDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.DIVISION_GEOGRAFICA, sequenceName = ISequenceTables.DIVISION_GEOGRAFICA, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.DIVISION_GEOGRAFICA)
	private Long id;

	@JoinColumn(name=PADRE_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private DivisionGeograficaDTO padre;
	
	@JoinColumn(name=MONEDA_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private MonedaDTO moneda;

	@Column(name=CODIGO,length=10)
	private String codigo;
	
	@Column(name=TIPO,length=1)
	@Type(type=Tipo.TYPE)
	private Tipo tipo;
	
	@Column(name=NIVEL)
	private Integer nivel;
	
	@OneToMany(mappedBy=FIELD_PAIS,fetch=FetchType.LAZY)
	private List<ImpuestoDTO> impuestoDTOs;
	
	@OneToMany(mappedBy=FIELD_PADRE,fetch=FetchType.LAZY)
	private List<DivisionGeograficaDTO> divisionGeograficaDTOs;
	
	@OneToMany(mappedBy=FIELD_CIUDAD,fetch=FetchType.LAZY)
	private List<SucursalDTO> sucursalDTOs;
	
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
	
	public DivisionGeograficaDTO getPadre() {
		return padre;
	}

	public void setPadre(DivisionGeograficaDTO padre) {
		this.padre = padre;
	}

	public MonedaDTO getMoneda() {
		return moneda;
	}

	public void setMoneda(MonedaDTO moneda) {
		this.moneda = moneda;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}


	public List<ImpuestoDTO> getImpuestoDTOs() {
		return impuestoDTOs;
	}
	
	public void setImpuestoDTOs(List<ImpuestoDTO> impuestoDTOs) {
		this.impuestoDTOs = impuestoDTOs;
	}
	

	public List<DivisionGeograficaDTO> getDivisionGeograficaDTOs() {
		return divisionGeograficaDTOs;
	}
	
	public void setDivisionGeograficaDTOs(
			List<DivisionGeograficaDTO> divisionGeograficaDTOs) {
		this.divisionGeograficaDTOs = divisionGeograficaDTOs;
	}

	public List<SucursalDTO> getSucursalDTOs() {
		return sucursalDTOs;
	}
	
	public void setSucursalDTOs(List<SucursalDTO> sucursalDTOs) {
		this.sucursalDTOs = sucursalDTOs;
	}
	
	/**
	 * 
	 * @author Joel Alvarado
	 *
	 */
	public enum Tipo implements StringValuedEnum<Tipo> {
		 PAIS("P")
		,PROVINCIA("R")
		,CIUDAD("C")
		,PARROQUIA("Q")
		;

		public static class Type extends StringValuedEnumType<Tipo> {}
		public static final String TYPE = "ec.edu.ug.erp.dto.general.DivisionGeograficaDTO$Tipo$Type";

		public boolean isPais() 	 { return this.equals(PAIS); 		}
		public boolean isProvincia() { return this.equals(PROVINCIA); 	}
		public boolean isCiudad()    { return this.equals(CIUDAD); 		}
		public boolean isParroquia() { return this.equals(PARROQUIA); 	}

		private String val;
		private String labelKey;
		
		public static Map<String, Tipo> LABELED_MAP;
		
		public static final List<Tipo> LIST =
			Arrays.asList(Tipo.values());

		private Tipo(String value) {
			this.val = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}
		

		public String getVal() {
			return val;
		}		
		
		public String getKey() {
			return labelKey;
		}
		public String getValue() {
			return val;
		}
		
		public String getDescription() {
			return getValue();
		}
		

	}


	
	
}

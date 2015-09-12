package ec.edu.ug.erp.dto.seguridad;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;
import ec.edu.ug.erp.util.type.StringValuedEnum;
import ec.edu.ug.erp.util.type.StringValuedEnumReflect;
import ec.edu.ug.erp.util.type.StringValuedEnumType;

@Entity
@Table(name=ITableNames.MODULO,schema=ISchemaNames.SEGURIDAD)
public class ModuloDTO extends GenericSeguridadDTO<ModuloDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.MODULO, sequenceName = ISequenceTables.MODULO, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.MODULO)
	private Long id;
	
	@JoinColumn(name=PADRE_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private ModuloDTO padre;
	
	@Column(name=CODIGO,length=50)
	private String codigo;
	
	@Column(name=ACCIONLISTAR,length=300)
	private String accionListar;
	
	@Column(name=ACCIONCREAR,length=300)
	private String accionCrear;
	
	@Column(name=ACCIONEDITAR,length=300)
	private String accionEditar;
	
	@Column(name=ICONO,length=50)
	private String icono;
	
	@Column(name=ORDEN)
	private Integer orden;
	
	@Column(name=NIVEL)
	private Integer nivel;
	
	@Column(name=MANAGEDBEAN)
	private String managedBean;
	
	@Column(name=TIPO,length=1)
	@Type(type=Tipo.TYPE)
	private Tipo tipo;
	
	@Column(name=PARAMETROS)
	@Lob
	private String parametros;
	
	@OneToMany(mappedBy=FIELD_PADRE,fetch=FetchType.LAZY)
	private List<ModuloDTO> moduloDTOs;
	
	@OneToMany(mappedBy=FIELD_MODULO,fetch=FetchType.LAZY)
	private List<TareaDTO> tareaDTOs;
	
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

	
	public ModuloDTO getPadre() {
		return padre;
	}

	public void setPadre(ModuloDTO padre) {
		this.padre = padre;
	}

	public String getAccionListar() {
		return accionListar;
	}

	public void setAccionListar(String accionListar) {
		this.accionListar = accionListar;
	}

	public String getAccionCrear() {
		return accionCrear;
	}

	public void setAccionCrear(String accionCrear) {
		this.accionCrear = accionCrear;
	}

	public String getAccionEditar() {
		return accionEditar;
	}

	public void setAccionEditar(String accionEditar) {
		this.accionEditar = accionEditar;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getParametros() {
		return parametros;
	}

	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	public List<ModuloDTO> getModuloDTOs() {
		return moduloDTOs;
	}

	public void setModuloDTOs(List<ModuloDTO> moduloDTOs) {
		this.moduloDTOs = moduloDTOs;
	}

	public List<TareaDTO> getTareaDTOs() {
		return tareaDTOs;
	}

	public void setTareaDTOs(List<TareaDTO> tareaDTOs) {
		this.tareaDTOs = tareaDTOs;
	}



	/**
	 * 
	 * @author Joel Alvarado
	 *
	 */
	public enum Tipo implements StringValuedEnum<Tipo> {
		 MODULO	 		("M")
		,MENU	 		("U")
		,OPCION	 		("O")
		,POPUP	 		("P")
		,DIALOG	 		("D")
		,REPORTE 		("R")
		,ARCHIVO 		("A")
		,WELCOMEPAGE 	("W")
		
		;

		public static class Type extends StringValuedEnumType<Tipo> {}
		public static final String TYPE = "ec.edu.ug.erp.dto.seguridad.ModuloDTO$Tipo$Type";

		public boolean isModulo() 	 	{ return this.equals(MODULO); 		}
		public boolean isMenu() 	 	{ return this.equals(MENU); 		}
		public boolean isOpcion()  	 	{ return this.equals(OPCION); 		}
		public boolean isPopup()  	 	{ return this.equals(POPUP); 		}
		public boolean isDialog()    	{ return this.equals(DIALOG); 		}
		public boolean isReporte()   	{ return this.equals(REPORTE);		}
		public boolean isArchivo()   	{ return this.equals(ARCHIVO);		}
		public boolean isWelcomePage()  { return this.equals(WELCOMEPAGE);	}

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

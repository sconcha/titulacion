package ec.edu.ug.erp.dto.administracion;

import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.erp.util.type.StringValuedEnum;
import ec.edu.ug.erp.util.type.StringValuedEnumReflect;
import ec.edu.ug.erp.util.type.StringValuedEnumType;


@Entity
@Table(name="UADMTIMPUESTO")
public class ImpuestoDTO extends GenericDTO<ImpuestoDTO> {

	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_IMPUESTO", sequenceName = "UADMSIMPUESTO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_IMPUESTO")
	private Long id;

	@JoinColumn(name="PAIS_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private DivisionGeograficaDTO pais;

	@Column(name="CODIGO",length=10)
	private String codigo;
	
	@Column(name="PORCENTAJE")
	private BigDecimal porcentaje;
	
	@Column(name="TIPO",length=1)
	@Type(type=Tipo.TYPE)
	private Tipo tipo;
	

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
	

	public DivisionGeograficaDTO getPais() {
		return pais;
	}

	public void setPais(DivisionGeograficaDTO pais) {
		this.pais = pais;
	}

	public BigDecimal getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}




	/**
	 * 
	 * @author Joel Alvarado
	 *
	 */
	public enum Tipo implements StringValuedEnum<Tipo> {
		 IVA("I")
		,ICE("C")
		,OTRO("O")
		;

		public static class Type extends StringValuedEnumType<Tipo> {}
		public static final String TYPE = "ec.edu.ug.erp.dto.administracion.ImpuestoDTO$Tipo$Type";

		public boolean isIva() 	 { return this.equals(IVA); 		}
		public boolean isIce() 	 { return this.equals(ICE); 	}
		public boolean isOtro()  { return this.equals(OTRO); 		}

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
			return val;
		}
		public String getValue() {
			return labelKey;
		}
		
		public String getDescription() {
			return getValue();
		}
		

	}
	

}

package ec.edu.ug.chamaleon.dto.administracion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import ec.edu.ug.chamaleon.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.chamaleon.util.type.StringValuedEnum;
import ec.edu.ug.chamaleon.util.type.StringValuedEnumReflect;
import ec.edu.ug.chamaleon.util.type.StringValuedEnumType;

@Entity
@Table(name="UADMTPERSONA")
public class PersonaDTO extends GenericDTO<PersonaDTO> {

	private static final long serialVersionUID = -5170427302770951584L;
	
	@Id
	@SequenceGenerator(name = "SG_PERSONA", sequenceName = "UADMSPERSONA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_PERSONA")
	private Long id;

	@Column(name="NATURALEZA",length=1)
	@Type(type=Naturaleza.TYPE)
	private Naturaleza naturaleza;
	
	@Column(name="TIPOIDENTIFICACION",length=1)
	@Type(type=TipoIdentificacion.TYPE)
	private TipoIdentificacion tipoIdentificacion;

	@Column(name="IDENTIFICACION",length=20)	
	private String identificacion;
	
	@Column(name="APELLIDOPATERNO",length=200)
	private String apellidopaterno;
	
	@Column(name="APELLIDOMATERNO",length=100)
	private String apellidomaterno;
	
	@Column(name="NOMBRES",length=200)
	private String nombres;
	
	@Column(name="RAZONSOCIAL",length=300)
	private String razonSocial;

	@Column(name="NOMBRECOMERCIAL",length=300)
	private String nombreComercial;

	@Column(name="GENERO",length=1)
	@Type(type=Genero.TYPE)
	private Genero genero;
	
	@Column(name="FECHANACIMIENTO")
	@Temporal(TemporalType.DATE)
	Date fechaNacimiento;
	
	@Column(name="ESTAOCIVIL",length=1)
	@Type(type=EstadoCivil.TYPE)
	private EstadoCivil estadoCivil;
	
	@Column(name="TIPOSANGRE",length=10)
	private String tipoSangre;
	
	@Column(name="TELEFONO",length=200)
	private String telefono;
	
	@Column(name="FAX",length=20)
	private String fax;
	
	@Column(name="EMAIL",length=200)
	private String email;
	
	
	@OneToMany(mappedBy="persona",fetch=FetchType.LAZY)
	private List<EmpresaDTO> empresaDTOs=new ArrayList<EmpresaDTO>();
	
	@OneToMany(mappedBy="persona",fetch=FetchType.LAZY)
	private List<EmpresaPersonaDTO> empresaPersonaDTOs=new ArrayList<EmpresaPersonaDTO>();
	
	public Long getId() {		
		return id;
	}

	public void setId(Long id) {
		this.id=id;		
	}

	@Override
	public String getCodigo() {
		return identificacion;
	}

	@Override
	public void setCodigo(String codigo) {
		this.identificacion=codigo;		
	}

	
	public Naturaleza getNaturaleza() {
		return naturaleza;
	}

	public void setNaturaleza(Naturaleza naturaleza) {
		this.naturaleza = naturaleza;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getApellidopaterno() {
		return apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	public String getApellidomaterno() {
		return apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<EmpresaDTO> getEmpresaDTOs() {
		return empresaDTOs;
	}
	
	public void setEmpresaDTOs(List<EmpresaDTO> empresaDTOs) {
		this.empresaDTOs = empresaDTOs;
	}
	
	public List<EmpresaPersonaDTO> getEmpresaPersonaDTOs() {
		return empresaPersonaDTOs;
	}
	
	public void setEmpresaPersonaDTOs(List<EmpresaPersonaDTO> empresaPersonaDTOs) {
		this.empresaPersonaDTOs = empresaPersonaDTOs;
	}


	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-08-10
	 *
	 */
	public enum Naturaleza implements StringValuedEnum<Naturaleza> {
		NATURAL("N"),
		JURIDICA("J"),
		;

		public static class Type extends StringValuedEnumType<Naturaleza> {}
		public static final String TYPE = "ec.edu.ug.chamaleon.dto.administracion.PersonaDTO$Naturaleza$Type";

		public boolean isNatural() { return this.equals(NATURAL); }
		public boolean isJuridica() { return this.equals(JURIDICA); }

		private String val;
		private String labelKey;
		
		public static Map<String, Naturaleza> LABELED_MAP;
		
		public static final List<Naturaleza> LIST =
			Arrays.asList(Naturaleza.values());

		private Naturaleza(String value) {
			this.val 	  = value;
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
	
	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-08-10
	 *
	 */
	public enum TipoIdentificacion implements StringValuedEnum<TipoIdentificacion> {
		RUC("R"),
		CEDULA("C"),
		PASAPORTE("P")
		;

		public static class Type extends StringValuedEnumType<TipoIdentificacion> {}
		public static final String TYPE = "ec.edu.ug.chamaleon.dto.administracion.PersonaDTO$TipoIdentificacion$Type";

		public boolean isRuc()       { return this.equals(RUC); }
		public boolean isCedula()    { return this.equals(CEDULA); }
		public boolean isPasaporte() { return this.equals(PASAPORTE); }

		private String val;
		private String labelKey;
		
		public static Map<String, TipoIdentificacion> LABELED_MAP;
		
		public static final List<TipoIdentificacion> LIST =
			Arrays.asList(TipoIdentificacion.values());

		private TipoIdentificacion(String value) {
			this.val 	  = value;
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
	

	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-08-10
	 *
	 */
	public enum Genero implements StringValuedEnum<Genero> {
		MASCULINO("M"),
		FEMENINO ("F"),
		;

		public static class Type extends StringValuedEnumType<Genero> {}
		public static final String TYPE = "ec.edu.ug.chamaleon.dto.administracion.PersonaDTO$Genero$Type";

		public boolean isMasculino()   { return this.equals(MASCULINO); }
		public boolean isFemenino()    { return this.equals(FEMENINO); }

		private String val;
		private String labelKey;
		
		public static Map<String, Genero> LABELED_MAP;
		
		public static final List<Genero> LIST =
			Arrays.asList(Genero.values());

		private Genero(String value) {
			this.val 	  = value;
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
	
	
	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-08-10
	 *
	 */
	public enum EstadoCivil implements StringValuedEnum<EstadoCivil> {
		SOLTERO		("S"),
		CASADO 		("C"),
		DIVORCIADO 	("D"),
		UNIONLIBRE 	("U"),
		VIUDO 		("V"),
		;

		public static class Type extends StringValuedEnumType<EstadoCivil> {}
		public static final String TYPE = "ec.edu.ug.chamaleon.dto.administracion.PersonaDTO$EstadoCivil$Type";

		public boolean isSoltero()   	{ return this.equals(SOLTERO); }
		public boolean isCasado()    	{ return this.equals(CASADO); }
		public boolean isDivorciado()   { return this.equals(DIVORCIADO); }
		public boolean isUnionLibre()   { return this.equals(UNIONLIBRE); }
		public boolean isViudo()   		{ return this.equals(VIUDO); }

		private String val;
		private String labelKey;
		
		public static Map<String, EstadoCivil> LABELED_MAP;
		
		public static final List<EstadoCivil> LIST =
			Arrays.asList(EstadoCivil.values());

		private EstadoCivil(String value) {
			this.val 	  = value;
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

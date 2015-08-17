package ec.edu.ug.erp.util.dto.generic.impl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import ec.edu.ug.erp.util.dto.generic.IGenericDTO;
import ec.edu.ug.erp.util.type.StringValuedEnum;
import ec.edu.ug.erp.util.type.StringValuedEnumReflect;
import ec.edu.ug.erp.util.type.StringValuedEnumType;

@MappedSuperclass
public abstract class GenericDTO<DTO extends GenericDTO<DTO>> implements IGenericDTO<Long>,Serializable {
	private static final long serialVersionUID = -374580369079967296L;
	
	@Transient
	 private Class<DTO> clazz;
	
	@Column(name = "DESCRIPCION",length=500)
	protected String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHACREACION")
	protected Date fechaCreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAMODIFICACION")
	protected Date fechaModificacion;
	
	@Column(name = "ESTADO",length=2)
	@Type(type=Estado.TYPE)
	protected Estado estado;
		
	
	public abstract String getCodigo();

	public abstract void setCodigo(String codigo);

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public String getKey() {
		return getCodigo();
	}

	public String getValue() {
		return getDescripcion();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (getClass().isInstance(other) && (getId() != null))
			return getId().equals(((GenericDTO<DTO>) other).getId());
		return (other == this);
	}

	public boolean equalsId(DTO other) {
		if (other == null)
			return false;
		if (getId() != null)
			return getId().equals(other.getId());
		return (other == this);
	}

	@Override
	public int hashCode() {
		return getId() != null ?
				this.getClass().hashCode() + getId().hashCode() : super.hashCode();
	}

	@Override
	public final String toString() {
		return String.format(" %s #%s [(%s) %s] ", this.getClass().getName(),this.getId()==null? "":this.getId(),this.getKey(),this.getValue());
	}
	
	public DTO getInstance() throws InstantiationException, IllegalAccessException{		
		return clazz.newInstance();
	}
	
	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-08-10
	 *
	 */
	public enum Estado implements StringValuedEnum<Estado> {
		ACTIVO("A"),
		INACTIVO("I"),
		;

		public static class Type extends StringValuedEnumType<Estado> {}
		public static final String TYPE = "ec.edu.ug.erp.util.dto.generic.impl.GenericDTO$Estado$Type";

		public boolean isActivo() { return this.equals(ACTIVO); }
		public boolean isInactivo() { return this.equals(INACTIVO); }

		private String val;
		private String labelKey;
		
		public static Map<String, Estado> LABELED_MAP;
		
		public static final List<Estado> LIST =
			Arrays.asList(Estado.values());

		private Estado(String value) {
			this.val 	  = value;
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

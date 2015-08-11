package ec.edu.ug.chamaleon.dto.seguridad;

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

import ec.edu.ug.chamaleon.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.chamaleon.util.type.BooleanToCharType;
import ec.edu.ug.chamaleon.util.type.StringValuedEnum;
import ec.edu.ug.chamaleon.util.type.StringValuedEnumReflect;
import ec.edu.ug.chamaleon.util.type.StringValuedEnumType;

@Entity
@Table(name="USEGTTAREA")
public class TareaDTO extends GenericDTO<TareaDTO>{
	
	private static final long serialVersionUID = 9029604394724370809L;
	
	@Id
	@SequenceGenerator(name = "SG_TAREA", sequenceName = "USEGSTAREA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SG_TAREA")
	private Long id;
	
	@JoinColumn(name="MODULO_ID")
	@ManyToOne(fetch=FetchType.LAZY)
	private ModuloDTO modulo;
	
	@Column(name="CODIGO",length=50)
	private String codigo;
	
	@Column(name="CREAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean crear;
	
	@Column(name="EDITAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean editar;
	
	@Column(name="PROCESAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean procesar;
	
	@Column(name="GENERAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean generar;
	
	@Column(name="LISTAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean listar;
	
	@Column(name="VER")
	@Type(type=BooleanToCharType.TYPE)
	private boolean ver;
	
	@Column(name="DUPLICAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean duplicar;
	
	@Column(name="ENVIAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean enviar;
	
	@Column(name="RECUPERAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean recuperar;
	
	@Column(name="REVERSAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean reversar;
	
	@Column(name="ELIMINAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean eliminar;
	
	@Column(name="ANULAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean anular;
	
	@Column(name="AUTORIZAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean autorizar;
	
	@Column(name="RECHAZAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean rechazar;
	
	@Column(name="IMPRIMIR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean imprimir;
	
	@Column(name="REPORTAR")
	@Type(type=BooleanToCharType.TYPE)
	private boolean reportar;

	@Column(name="ACCIONGENERICA",length=500)
	private String accionGenerica;

	@Column(name="TIPO",length=1)
	@Type(type=Tipo.TYPE)
	private Tipo tipo;

	@OneToMany(mappedBy="tarea",fetch=FetchType.LAZY)
	private List<TareaRolDTO> tareaRolDTOs;
	
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

	public ModuloDTO getModulo() {
		return modulo;
	}

	public void setModulo(ModuloDTO modulo) {
		this.modulo = modulo;
	}

	public boolean isCrear() {
		return crear;
	}

	public void setCrear(boolean crear) {
		this.crear = crear;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public boolean isProcesar() {
		return procesar;
	}

	public void setProcesar(boolean procesar) {
		this.procesar = procesar;
	}

	public boolean isGenerar() {
		return generar;
	}

	public void setGenerar(boolean generar) {
		this.generar = generar;
	}

	public boolean isListar() {
		return listar;
	}

	public void setListar(boolean listar) {
		this.listar = listar;
	}

	public boolean isVer() {
		return ver;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}

	public boolean isDuplicar() {
		return duplicar;
	}

	public void setDuplicar(boolean duplicar) {
		this.duplicar = duplicar;
	}

	public boolean isEnviar() {
		return enviar;
	}

	public void setEnviar(boolean enviar) {
		this.enviar = enviar;
	}

	public boolean isRecuperar() {
		return recuperar;
	}

	public void setRecuperar(boolean recuperar) {
		this.recuperar = recuperar;
	}

	public boolean isReversar() {
		return reversar;
	}

	public void setReversar(boolean reversar) {
		this.reversar = reversar;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}

	public boolean isAnular() {
		return anular;
	}

	public void setAnular(boolean anular) {
		this.anular = anular;
	}

	public boolean isAutorizar() {
		return autorizar;
	}

	public void setAutorizar(boolean autorizar) {
		this.autorizar = autorizar;
	}

	public boolean isRechazar() {
		return rechazar;
	}

	public void setRechazar(boolean rechazar) {
		this.rechazar = rechazar;
	}

	public boolean isImprimir() {
		return imprimir;
	}

	public void setImprimir(boolean imprimir) {
		this.imprimir = imprimir;
	}

	public boolean isReportar() {
		return reportar;
	}

	public void setReportar(boolean reportar) {
		this.reportar = reportar;
	}

	public String getAccionGenerica() {
		return accionGenerica;
	}

	public void setAccionGenerica(String accionGenerica) {
		this.accionGenerica = accionGenerica;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<TareaRolDTO> getTareaRolDTOs() {
		return tareaRolDTOs;
	}

	public void setTareaRolDTOs(List<TareaRolDTO> tareaRolDTOs) {
		this.tareaRolDTOs = tareaRolDTOs;
	}



	/**
	 * 
	 * @author Joel Alvarado
	 *
	 */
	public enum Tipo implements StringValuedEnum<Tipo> {
		 CABECERA ("C")
		,DETALLE  ("D")
		,TODOS	  ("T")
		;

		public static class Type extends StringValuedEnumType<Tipo> {}
		public static final String TYPE = "ec.edu.ug.chamaleon.dto.seguridad.TareaDTO$Tipo$Type";

		public boolean isCabecera()  { return this.equals(CABECERA);	}
		public boolean isDetalle() 	 { return this.equals(DETALLE);		}
		public boolean isTodos()  	 { return this.equals(TODOS); 		}
		
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

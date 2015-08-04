package edu.ug.dto.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import edu.ug.dto.generic.interfaz.impl.GenericDTO;



@Entity
@Table(name="UADMTSISTEMA")
public class SistemaDTO extends GenericDTO<Long> {

	private static final long serialVersionUID = 3781376647430403022L;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="HOST")
	private String host;
	
	@Column(name="PUERTO")
	private String puerto;
	
	@Column(name="AMBIENTE")
	private String ambiente;
	
	@Column(name="URL")
	private String url;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPOCONEXION")
	private TipoConexion tipoConexion;
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	
	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	
	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public TipoConexion getTipoConexion() {
		return tipoConexion;
	}

	public void setTipoConexion(TipoConexion tipoConexion) {
		this.tipoConexion = tipoConexion;
	}




	public enum TipoConexion{
		 LOCAL("L")
		,REMOTA("R")
		;
		
		private String value;
		TipoConexion(String value){
			 this.value=value;
		}
		
		public String getValue() {
			return value;
		}
		
		
	}

}
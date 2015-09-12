package ec.edu.ug.erp.util.constantes;


/**
 * interfaz con constantes usadas en el proyecto
 * 
 * @author Joel Alvarado
 * @version 1.0
 * @since 2015/09/01
 *
 */
public interface IConstantes {

	public static final String ALIAS_MODULO="modulo";
	public static final String ALIAS_USUARIO="usuario";
	public static final String ALIAS_PERSONA="persona";
	public static final String ALIAS_SUCURSAL="sucursal";
	public static final String ALIAS_USUARIOSUCURSAL="usuarioSucursal";
	public static final String ALIAS_EMPRESA="empresa";
	public static final String ALIAS_ROL="rol";
	public static final String ALIAS_USUARIOROL="usuarioRol";
	public static final String ALIAS_TAREA="tarea";
	public static final String ALIAS_TAREAROL="tareaRol";
	public static final String ALIAS_IMPUESTO="impuesto";
	public static final String ALIAS_REGION="region";
	public static final String ALIAS_MODULOROL="moduloRol";
	public static final String ALIAS_DIVISIONNEGOCIO="divisionNegocio";
	public static final String ALIAS_DIVISIONGEOGRAFICA="divisionGeografica";
	public static final String ALIAS_EMPRESA_PERSONA="empresaPersona";
	public static final String ALIAS_MODULOMENU="moduloMenu";
	public static final String ALIAS_MODULOMODULO="moduloModulo";
	public static final String ALIAS_MODULOOPCION="moduloOpcion";
	
	public static final String ALIAS_EMPRESAPERSONA_TO_PERSONA="empresaPersona.persona";
	public static final String ALIAS_EMPRESAPERSONA_TO_EMPRESA="empresaPersona.empresa";
	public static final String ALIAS_TAREA_TO_MODULO="tarea.modulo";
	
	public static final String FIELD_TAREAMODULO_TIPO="modulo.tipo";
	public static final String FIELD_TAREAMODULO_PADRE="modulo.padre";
	public static final String FIELD_TIPO="tipo";
	public static final String FIELD_ORDEN="orden";
	public static final String FIELD_PERSONA="persona";
	public static final String FIELD_PADRE="padre";
	public static final String FIELD_EMPRESA="empresa";
	public static final String FIELD_SUCURSAL="sucursal";
	public static final String FIELD_PREDETERMINADO="predeterminado";
	public static final String FIELD_PAIS="pais";
	public static final String FIELD_CIUDAD="ciudad";
	public static final String FIELD_MONEDA="moneda";
	public static final String FIELD_REGION="region";
	public static final String FIELD_EMPRESA_PERSONA="empresaPersona";
	public static final String FIELD_MODULO="modulo";
	public static final String FIELD_ROL="rol";
	public static final String FIELD_TAREA="tarea";
	public static final String FIELD_USUARIO="usuario";
	public static final String FIELD_CODIGO="codigo";
	public static final String FIELD_CLAVE="clave";
	public static final String FIELD_ESTADO="estado";
	public static final String FIELD_ID="id";
	public static final String FIELD_USUARIOS_ROLES_FETCH="usuarioRolDTOs";
	public static final String FIELD_ACIONLISTAR="accionListar";
	
	public static final String POINT=".";
	public static final String STRING_EMPTY="";
	
	/*
	 *SECURITY CONFIG 
	 */
	public static final String URL_LOGIN="/login.jsf?faces-redirect=true";
	public static final String URL_LOGIN_PROCESSING="/login";
	public static final String URL_SUCCESS="/pages/index.jsf?faces-redirect=true";
	public static final String URL_LOGIN_ERROR="/login.jsf?error";
	public static final String URL_LOGOUT="/login.jsf?faces-redirect=true";
	public static final String URL_ACCESDENIED="/errorPages/403.html";	
	public static final String PARAM_USERNAME="username";
	public static final String PARAM_PASSWORD="password";
	
	public static final String PATH_FACES_RESOURCES="/javax.faces.resource/**";
	public static final String PATH_SECURE_PAGES="/pages/**";
	public static final String PATH_UNSECURE_PAGES="/errorPages/**";
	
	
	
}

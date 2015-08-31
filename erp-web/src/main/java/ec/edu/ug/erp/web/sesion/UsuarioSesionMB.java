package ec.edu.ug.erp.web.sesion;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.dto.rrhh.EmpresaPersonaDTO;
import ec.edu.ug.erp.dto.rrhh.PersonaDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;
import ec.edu.ug.erp.util.dto.DTOUtils;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;
import ec.edu.ug.erp.util.jsf.GenericManagedBean;

@Named("usuarioSesionMB")
@SessionScoped
public class UsuarioSesionMB extends GenericManagedBean {

	private static final long serialVersionUID = 9094363117358009348L;
	
	@Autowired
	private SeguridadService servicio;
	
	private UsuarioDTO usuario;	
	private EmpresaDTO empresa;
	private EmpresaPersonaDTO empresaPersona;
	private PersonaDTO persona;
	private UsuarioSucursalDTO usuarioSucursal;
	private List<UsuarioSucursalDTO> usuariosSucursal;
	
	
	
	
	@PostConstruct
	public void init(){
		System.out.println("INICIANDO USUARIO SESION");
		
		load();
		
		
	}
	
	public void load(){
		UsuarioDTO usuario=new UsuarioDTO();
		usuario.setCodigo("JALVARADO");		
		usuario.setClave("123");
		usuario.setEstado(Estado.ACTIVO);
		try {
			usuario=servicio.obtenerUsuarioSesion(usuario,null);
			
			if(DTOUtils.isPersistent(usuario)){
				setUsuariosSucursal(servicio.obtenerUsuariosSucursal(usuario));
				setUsuarioSucursal(servicio.obtenerUsuarioSucursal(usuario));
				setEmpresa(usuario.getEmpresaPersona().getEmpresa());
				setEmpresaPersona(usuario.getEmpresaPersona());
				setPersona(usuario.getEmpresaPersona().getPersona());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError(e.getMessage());
		}
		
		
		System.out.println(usuario);
		System.out.println(usuario.getEmpresaPersona());
		System.out.println(usuario.getEmpresaPersona().getPersona());
		System.out.println(usuario.getEmpresaPersona().getEmpresa());
		
		System.out.println(getUsuariosSucursal());
		
		System.out.println("usuarios sucursal");
		getUsuariosSucursal().forEach((x)->System.out.println(x));
		System.out.println("sucursales");
		getUsuariosSucursal().forEach((x)->System.out.println(x.getSucursal()));
	}
	
	
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public UsuarioSucursalDTO getUsuarioSucursal() {
		return usuarioSucursal;
	}

	public void setUsuarioSucursal(UsuarioSucursalDTO usuarioSucursal) {
		this.usuarioSucursal = usuarioSucursal;
	}

	public List<UsuarioSucursalDTO> getUsuariosSucursal() {
		return usuariosSucursal;
	}

	public void setUsuariosSucursal(List<UsuarioSucursalDTO> usuariosSucursal) {
		this.usuariosSucursal = usuariosSucursal;
	}


	public EmpresaPersonaDTO getEmpresaPersona() {
		return empresaPersona;
	}


	public void setEmpresaPersona(EmpresaPersonaDTO empresaPersona) {
		this.empresaPersona = empresaPersona;
	}


	public PersonaDTO getPersona() {
		return persona;
	}


	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}
	
	

	

}

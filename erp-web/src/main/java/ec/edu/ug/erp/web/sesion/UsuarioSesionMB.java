package ec.edu.ug.erp.web.sesion;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ug.erp.util.jsf.GenericManagedBean;

@Named("usuarioSesionMB")
@SessionScoped
public class UsuarioSesionMB extends GenericManagedBean {

	private static final long serialVersionUID = 9094363117358009348L;
	
	@PostConstruct
	public void init(){
		System.out.println("INICIANDO USUARIO SESION");
	}
	
	public void close(){
		System.out.println("FINALIZANDO SESION");
	}
	

}

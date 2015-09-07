package ec.edu.ug.erp.web.sesion;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.AuthenticationException;

import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;
import ec.edu.ug.erp.util.jsf.GenericManagedBean;

@Named("loginMB")
@RequestScoped
public class LoginMB extends GenericManagedBean {
	
	private static final long serialVersionUID = -8837467056736388830L;
	
	@Inject UsuarioSesionMB usuarioSesion;
	
	private String userName;
	private String password;
	


    public String login() {
        try {
        	HttpServletRequest request=getHttpServletRequest();
        	request.login(userName, password);
        	
        	UsuarioDTO usuario=new UsuarioDTO();
        	usuario.setClave(password);
    		usuario.setEstado(Estado.ACTIVO);
        	usuarioSesion.setUsuario(usuario);        	
        	usuarioSesion.load();

        } catch (AuthenticationException e) {
            addMessageError(e.getMessage());
            return URL_LOGIN_ERROR;
            
        } catch (ServletException e) {
			addMessageError(e.getMessage());
			return URL_LOGIN_ERROR;
		}
        return URL_SUCCESS;
    }

    public String cancel() {
        return STRING_EMPTY;
    }

    public String logout(){
        try {
			getHttpServletRequest().logout();
		} catch (ServletException e) {			
			addMessageError(e.getMessage());
		}
        return URL_LOGOUT;
    }
 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

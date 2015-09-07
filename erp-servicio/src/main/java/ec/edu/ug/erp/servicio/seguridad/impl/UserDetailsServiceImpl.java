package ec.edu.ug.erp.servicio.seguridad.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioRolDTO;


/**
 * Servicio para la integracion de los usuarios y roles con spring security framework 
 * @author Joel Alvarado
 * @version  1.0
 * @since 2015-09-02
 * 
 * @see <a href="http://docs.spring.io/spring-security/site/docs/3.2.3.RELEASE/reference/htmlsingle/"> http://docs.spring.io/spring-security/site/docs/3.2.3.RELEASE/reference/htmlsingle/</a>
 * @see <a href="http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/"> http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/</a>
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired SeguridadDao seguridadDao;

	
	/**
	 * Implementacion del metodo para realizar la autenticacion
	 * @author Joel Alvarado
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
	
		UsuarioDTO usuario;
		try {
			usuario=seguridadDao.findByUserName(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}		
		List<GrantedAuthority> authorities = usuarioRolDTOToGrantedAutority(usuario.getUsuarioRolDTOs());
		return usuarioDTOToUser(usuario, authorities);
		
	}

	/**
	 * recibe loa lista de UsuarioRolDTO y la transforma a lista de org.springframework.security.core.GrantedAuthority;
	 * 
	 * @author Joel Alvarado
	 * @param userRoles
	 * @return
	 */
	private List<GrantedAuthority> usuarioRolDTOToGrantedAutority(List<UsuarioRolDTO> userRoles) {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		userRoles.forEach((userRole)->(result.add(userRole.getRol())));
		return result;
	}

	/**
	 * recibe UsuarioDTO y lista de org.springframework.security.core.GrantedAuthority; y crea unorg.springframework.security.core.userdetails.User
	 * 
	 * @author Joel Alvarado
	 * @param user
	 * @param authorities
	 * @return
	 */
	private User usuarioDTOToUser(UsuarioDTO user, List<GrantedAuthority> authorities) {
		return new User(user.getCodigo(), user.getClave(), user.getEstado().isActivo(), true, true, true, authorities);
	}


	
	

}

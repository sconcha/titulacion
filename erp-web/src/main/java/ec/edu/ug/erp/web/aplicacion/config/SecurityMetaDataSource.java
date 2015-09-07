package ec.edu.ug.erp.web.aplicacion.config;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import ec.edu.ug.erp.dto.seguridad.RolDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;

@Component
public class SecurityMetaDataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired SeguridadService seguridad;
	
	private Collection<ConfigAttribute> configAttributes;
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		final HttpServletRequest request = ((FilterInvocation) object)
				.getRequest();

		String urlWithoutContextPath = request.getRequestURI().substring(request.getContextPath().length());
				
		try {
			Collection<RolDTO> roles= seguridad.findRolesByUrl(urlWithoutContextPath);
			if(roles!=null&&!roles.isEmpty()){
				this.configAttributes=new ArrayList<ConfigAttribute>();
				roles.forEach(rol->configAttributes.add(rol));				
			}
		} catch (Exception e) {
			this.configAttributes=null;
		}
		return getAllConfigAttributes();
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return this.configAttributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

}

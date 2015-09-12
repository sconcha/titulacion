package ec.edu.ug.erp.web.aplicacion.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import ec.edu.ug.erp.web.controller.AuthController;

public class SpringMvcInitializer// extends AbstractAnnotationConfigDispatcherServletInitializer 
{

	
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AuthController.class };
	}
 
	
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}
 
	
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

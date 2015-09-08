package ec.edu.ug.erp.web.aplicacion;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ec.edu.ug.erp.web.template.TemplateMB;


@Named("configMB")
@ApplicationScoped
public class ConfiguracionMB extends TemplateMB {

	private static final long serialVersionUID = -6316545902371086618L;
	
	@PostConstruct
	public void init(){
		System.out.println("INICIANDO APLICACION");
		getUsuarioSesion().validaSesion();
	}
	
	
	@PreDestroy
	public void close(){
		System.out.println("FINALIZANDO APLICACION");
	}
	

}

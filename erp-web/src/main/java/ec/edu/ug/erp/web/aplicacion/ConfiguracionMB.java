package ec.edu.ug.erp.web.aplicacion;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import ec.edu.ug.erp.util.jsf.GenericManagedBean;


@Named("configMB")
@ApplicationScoped
public class ConfiguracionMB extends GenericManagedBean {

	private static final long serialVersionUID = -6316545902371086618L;
	
	@PostConstruct
	public void init(){
		System.out.println("INICIANDO APLICACION");
	}
	
	
	@PreDestroy
	public void close(){
		System.out.println("FINALIZANDO APLICACION");
	}
	

}

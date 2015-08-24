package ec.edu.ug.erp.servicio.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ec.edu.ug.erp.dao.configuration.DaoConfiguration;
import ec.edu.ug.erp.dao.configuration.DataSourceConfiguration;


@Configuration
@EnableCaching
@EnableTransactionManagement
@Import({DataSourceConfiguration.class,DaoConfiguration.class})
@ComponentScan(basePackages = {DaoConfiguration.CONTEXT_COMPONENT_SCAN,ServiceConfiguration.CONTEXT_COMPONENT_SCAN})
public class ServiceConfiguration {
	public static final String CONTEXT_COMPONENT_SCAN	= "ec.edu.ug.erp.servicio";

}

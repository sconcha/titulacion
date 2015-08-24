package ec.edu.ug.erp.dao.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQLDialect;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

//@Configuration
//@Profile("default")
//@PropertySource({"properties/database.properties"})
public class DataSourceConfiguration   {

	private static final String PACKAGES_UTIL_DTOS 		= "ec.edu.ug.erp.util.dto";
	private static final String PACKAGES_ERP_DTOS  		= "ec.edu.ug.erp.dto";
	private static final String PROPERTY_JDBC_DRIVER  	= "jdbc.driverClassName";
	private static final String PROPERTY_JDBC_USERNAME  = "jdbc.username";
	private static final String PROPERTY_JDBC_PASSWORD  = "jdbc.password";
	private static final String PROPERTY_JDBC_URL  		= "jdbc.url";
	private static final String PROPERTY_HIBERNATE_HBM2DLL	= "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_HIBERNATE_SHOWSQL	= "hibernate.show_sql";
	
//	@Autowired
	Environment environment;
	

//    @Bean(name="datasource")
    public DataSource dataSource() throws Exception {    
        String user = environment.getProperty(PROPERTY_JDBC_USERNAME),
               pass = environment.getProperty(PROPERTY_JDBC_PASSWORD),
                url = environment.getProperty(PROPERTY_JDBC_URL);        
        Class<Driver> driverClass = environment.getPropertyAsClass( PROPERTY_JDBC_DRIVER, Driver.class );
        DriverManagerDataSource  basicDataSource = new DriverManagerDataSource();
        basicDataSource.setDriverClassName  ( driverClass.getName() );
        basicDataSource.setPassword			( pass );
        basicDataSource.setUrl				( url  );
        basicDataSource.setUsername			( user );
        return basicDataSource;    
    }

//    @Bean(name="sessionFactory")
    public LocalSessionFactoryBean sessionFactoryBean( DataSource dataSource  ) throws Exception {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource( dataSource );
        sessionFactory.setPackagesToScan(PACKAGES_UTIL_DTOS
        					,PACKAGES_ERP_DTOS);
        Properties p = new Properties();
        p.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, environment.getProperty(PROPERTY_HIBERNATE_HBM2DLL));        
        p.put(org.hibernate.cfg.Environment.DIALECT, PostgreSQLDialect.class.getName());
        p.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getProperty(PROPERTY_HIBERNATE_SHOWSQL));
        sessionFactory.setHibernateProperties(p);
        return sessionFactory;
    }

    

}

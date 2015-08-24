package ec.edu.ug.erp.dao.configuration;

import org.hibernate.SessionFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableCaching
//@EnableTransactionManagement
//@Import({DataSourceConfiguration.class})
//@ComponentScan(basePackages = {DaoConfiguration.CONTEXT_COMPONENT_SCAN})
public class DaoConfiguration {
	
	public static final String CONTEXT_COMPONENT_SCAN	= "ec.edu.ug.erp.dao";
	
//    @Bean(name="transactionManager")
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
    
//    @Bean(name="template")
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory){
    	return new HibernateTemplate(sessionFactory);
    	
    }
    
//    @Bean(name="daoSupport")
    public void daoSupport(HibernateTemplate template){
    	new HibernateDaoSupport() {
    		@Override
    		protected HibernateTemplate createHibernateTemplate(
    				SessionFactory sessionFactory) {    			
    			return super.createHibernateTemplate(sessionFactory);
    		}
		}.setHibernateTemplate(template); 
    }
}

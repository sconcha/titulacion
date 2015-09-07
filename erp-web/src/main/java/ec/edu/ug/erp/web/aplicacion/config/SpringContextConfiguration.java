package ec.edu.ug.erp.web.aplicacion.config;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@Configuration
//@EnableWebMvc
//@Import({SecurityConfig.class})
//@ComponentScan(basePackages = "ec.edu.ug")
//@ImportResource(locations={"classpath:/META-INF/spring/bo/config/appContext.xml"})
public class SpringContextConfiguration //extends WebMvcConfigurerAdapter 
{
	
//	@Bean(name="erp")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/*
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     *
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
package ec.edu.ug.erp.web.aplicacion.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ec.edu.ug.erp.util.constantes.IConstantes;
import ec.edu.ug.erp.util.crypto.CryptoUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements IConstantes {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired
	private SecurityMetaDataSource securityMetaDataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(userDetailsService).passwordEncoder(CryptoUtils.getEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher(URL_LOGOUT))
        .invalidateHttpSession(true)
        .logoutSuccessUrl(URL_LOGIN);
		
		AffirmativeBased affirmativeBased = new AffirmativeBased(Arrays.asList(new RoleVoter(),new WebExpressionVoter()));
		http.authorizeRequests()
		.accessDecisionManager(affirmativeBased)
			.antMatchers(PATH_FACES_RESOURCES).permitAll()
			.antMatchers(PATH_UNSECURE_PAGES).permitAll()
//			.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//				public <O extends FilterSecurityInterceptor> O postProcess(	O fsi) {					
//					fsi.setSecurityMetadataSource(securityMetaDataSource);					
//					return fsi;
//				}
//			})
			
			.antMatchers(PATH_SECURE_PAGES)
			.hasAuthority("RADM")
			.and().formLogin().loginPage(URL_LOGIN).permitAll()
			.failureUrl(URL_LOGIN_ERROR)
			.loginProcessingUrl(URL_LOGIN_PROCESSING)
			.defaultSuccessUrl(URL_SUCCESS)
			.and().exceptionHandling().accessDeniedPage(URL_ACCESDENIED);
	
	}
	
	
}
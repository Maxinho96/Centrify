package it.mdm.centrify.security;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Component;

@Component
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.antMatcher("/**").
	  authorizeRequests()
	  .antMatchers("/", "/index.html", "/assets/**")
	  .permitAll()
	  .anyRequest()
	  .authenticated()
	  .and()
	  .logout()
	  .logoutSuccessUrl("/")
	  .permitAll()
	  .and()
	  .csrf()
	  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

}

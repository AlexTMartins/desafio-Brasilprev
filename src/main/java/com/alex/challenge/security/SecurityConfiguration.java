package com.alex.challenge.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
 
	private static final String[] AUTH_WHITELIST = {
			"/swagger-resources/configuration/ui",
			"/swagger-resources",
			"/swagger-resources/configuration/security",
			"/swagger-ui.html",
			"/swagger-ui/",
			"/v2/api-docs",
			"/webjars/**"
	};
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("admin").password("admin").roles("ADMIN");    
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PATCH, "/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                    .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                .and()
                	.authorizeRequests()
                	.antMatchers(AUTH_WHITELIST)
                	.permitAll()
                .and()
                    .csrf()
                        .disable();
    }
}
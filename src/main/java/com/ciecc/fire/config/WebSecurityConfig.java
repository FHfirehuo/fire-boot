package com.ciecc.fire.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("fire").password("openfire").roles("USER")
		.and()
		.withUser("wangtao").password("wangtao").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.portMapper().http(80).mapsTo(443);
		http.authorizeRequests()
		.antMatchers("/", "login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		//.loginPage("/login")
		.defaultSuccessUrl("/chat")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
		//ws
		web.ignoring().antMatchers("/bootstrap/**","/images/**","/**/*.js", "/jpa/**");

	}

}

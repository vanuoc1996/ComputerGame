package com.vti.config.authentication;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Khong can Đăng nhập
		http.authorizeRequests()
			.anyRequest().permitAll()
			.and()
			.httpBasic()
			.and()
			.csrf().disable();
		// Đăng nhập
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();
		// Phân quyền (chưa haonf thiện)
//		http.authorizeRequests()
//		.antMatchers("/")
//		.hasAnyAuthority("ADMIN")
//		.and()
//		.httpBasic()
//		.and()
//		.csrf().disable(); 
		
	}
} 
package com.journaldev.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@EnableWebMvcSecurity
@EnableWebSecurity  
@ComponentScan("com.journaldev")  
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	static{
		System.out.println("syso sec configs loaded.. ");
		
		String password = "ninad"; 
	    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	    String encodedPassword = passwordEncoder.encode(password);  
	    System.out.print(encodedPassword);
		
	} 
	
	@Autowired
	DataSource dataSource;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	public StandardPasswordEncoder pwdenc(){
		return new StandardPasswordEncoder();
	}
	
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select username,password ,true from user where username=?")
		.authoritiesByUsernameQuery(
			"select username, role_user from user where username=?");
	}
	
	
	
	
	protected void configure(HttpSecurity http) throws Exception {  
	    
    	http.antMatcher("/")
    	.authorizeRequests()  
    	.anyRequest()
    	.authenticated()  
    	.and()  
    	.formLogin()
    	.and() 
    	.httpBasic();
    }


/* @Bean  
    public UserDetailsService userDetailsService() throws Exception { 
	 
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        
        JdbcUserDetailsManager jdbcmanager = new JdbcUserDetailsManager(dataSource);        
        
        manager.createUser(User.withDefaultPasswordEncoder().username("javatpoint").  
        password("java123").roles("USER").username("ninad").password("ninad").roles("ADMIN").build());  
        
        return manager;  
    } 
	
	
	*/
	

	
	/*protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.and()
		  .formLogin().loginPage("/login").failureUrl("/login?error")
		  .usernameParameter("username").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/login?logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();
	}*/
	
	
	 
	      
	    
	    

	     	// protected void configure( AuthenticationManagerBuilder auth ) throws Exception{				
			// auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and().withUser("tanmayee").password("123").roles("USER");
			//}
	
	
}

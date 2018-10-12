package com.journaldev.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer  {
	static{
		System.out.println("iinit security filters");
	}                       

}

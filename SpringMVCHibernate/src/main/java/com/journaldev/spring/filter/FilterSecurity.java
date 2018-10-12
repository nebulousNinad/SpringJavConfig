package com.journaldev.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/")
public class FilterSecurity  implements Filter {
	
	static {
		System.out.println("Filter loaded....");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
		System.out.println("Initializing filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		System.out.println("New Request :"+request);		
		System.out.println("Filter Response :"+response);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("In destroy method");
	}

}

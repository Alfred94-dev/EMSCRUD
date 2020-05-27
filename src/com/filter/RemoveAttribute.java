package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RemoveAttribute
 */
@WebFilter("/RemoveAttribute")
public class RemoveAttribute implements Filter {
    public RemoveAttribute() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpSession session = ((HttpServletRequest) request).getSession();
		session.removeAttribute("uname");
		session.removeAttribute("pass");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
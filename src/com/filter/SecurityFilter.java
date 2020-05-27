package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.dao.EmployeeDaoImpl;
/**
 * Servlet Filter implementation class SecurityFilter
 */
//@WebFilter("/*")
public class SecurityFilter implements Filter {
	
	HttpSession session;
	
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		
	}
	
	public void loginOptions(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Welcome " + session.getAttribute("uname") + "     <a href = 'logout'>Logout</a></br>");
		chain.doFilter(request, response);
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		session = ((HttpServletRequest) request).getSession();
		Object nameAtt = session.getAttribute("uname");
		if(nameAtt != null) {
			loginOptions(request, response, chain);
			return;
		}
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		EmployeeDaoImpl db = new EmployeeDaoImpl();
		Connection conn = null;
		Statement stmt = null;
		boolean found = false;
		try {
			conn = db.getConnection();
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from usercrud");
			while(result.next()) {
				if(result.getString("name").equals(name) && result.getString("password").equals(pass)) {
					found = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(found) {
			session.setAttribute("uname", name);
			session.setAttribute("pass", pass);
			
			loginOptions(request, response, chain);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}

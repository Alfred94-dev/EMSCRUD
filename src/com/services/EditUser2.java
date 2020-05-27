package com.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDaoImpl;
import com.entity.Employee;

/**
 * Servlet implementation class EditUser2
 */
@WebServlet("/EditUser2")
public class EditUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Employee emp = new Employee();
    	
    	emp.setEmpId(Integer.parseInt(request.getParameter("id")));
    	emp.seteName(request.getParameter("name"));
    	emp.setEmail(request.getParameter("email"));
    	emp.setPassword(request.getParameter("password"));
    	emp.setCountry(request.getParameter("country"));
    	
    	
    	EmployeeDaoImpl db = new EmployeeDaoImpl();
    	int i = db.Update(emp);
    	if(i > 0)
    	{
    		response.sendRedirect("userload");
    	}
    	
	}
}

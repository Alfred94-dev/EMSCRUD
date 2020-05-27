package com.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDaoImpl;
import com.entity.Employee;

/**
 * Servlet implementation class Updateuser
 */
@WebServlet("/Updateuser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	           throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	       
	        EmployeeDaoImpl db = new EmployeeDaoImpl();

	        response.setContentType("text/html");
	 		out.print("<!DOCTYPE html>" + 
					"<html>" + 
					"<head>" + 
					"<meta charset=\"ISO-8859-1\">" + 
					"<title>Insert title here</title>" + 
					"</head>" + 
					"<body>");
	        out.println("<h1>Update Employee</h1>");  
	        String sid=request.getParameter("id");  
	        
	         int id=Integer.parseInt(sid);  
	           
	         Employee e = db.getEmployeeById(id);  
	          
	        out.print("<form action='EditUser2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getEmpId()+"'/></td></tr>");  
	        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.geteName()+"'/></td></tr>");  
	        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
	        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
	        out.print("<tr><td>Country:</td><td>");  
	        out.print("<select name='country' style='width:150px'>");  
	       
	        out.print("</td></tr>");  
	        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
	        out.print("</table>");  
	        out.print("</form>");  
	          
	        out.close();  
	    }  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
    	Employee emp = new Employee();
    	
    	emp.setEmpId(Integer.parseInt(request.getParameter("id")));
    	emp.seteName(request.getParameter("name"));
    	emp.setEmail(request.getParameter("email"));
    	emp.setPassword(request.getParameter("password"));
    	emp.setCountry(request.getParameter("country"));
    	EmployeeDaoImpl db = new EmployeeDaoImpl();
    	db.Update(emp);
    }
	}  


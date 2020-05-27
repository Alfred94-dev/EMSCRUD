package com.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDaoImpl;
import com.entity.Employee;

/**
 * Servlet implementation class Userload
 */
@WebServlet("/Userload")
public class Userload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @To print the list in your Counsle
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
////		EmployeeDaoImpl db = new EmployeeDaoImpl();
////		List<Employee> employees = db.getAllEmployee();
////		for(Employee emp : employees)
////			System.out.println(emp);
////	}
	
	
	
	

	/**
	 * @To print the list in your html file
	 * 
	 * <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	 *  integrity="sha384-9aIt2nRpC12Uk9gS
	 * 9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	 */
	
	
	public Userload() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDaoImpl db = new EmployeeDaoImpl();
		List<Employee> employees = db.getAllEmployee();
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.print("<!DOCTYPE html>" + 
				"<html>" + 
				"<head>" + 
				"<meta charset=\"ISO-8859-1\">" + 
				"<title>Insert title here</title>" + 
				"</head>" + 
				"<body>");
		
		out.print("<h1>Employee's List</h1></br>");
		
        out.print("<table border=\\\"1\\\">");
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Options</th></tr>");
		
		for(Employee emp : employees)
		{
			out.print("<tr>");
			out.print("<td>" + emp.getEmpId() + "</td>");
			out.print("<td>" + emp.geteName() + "</td>");
			out.print("<td>" + emp.getEmail() + "</td>");
			out.print("<td>" + emp.getPassword() + "</td>");
			out.print("<td>" + emp.getCountry() + "</td>");
			
			out.print("<td>");
			out.print("<a href = 'deleteuser?id=" + emp.getEmpId() + "'>delete</a> ");
			out.print("<a href = 'EditUser?id=" + emp.getEmpId() + "'>edit</a>");
			out.print("</td>");
			
			out.print("</tr>");
		}
		out.print("</table>");
		
		out.print("<a href = 'useradd.html'>Add User</a>");
		
		out.print("</body></html>");
		
		
	}

}



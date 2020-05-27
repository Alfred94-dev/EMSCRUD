package com.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDaoImpl;
import com.entity.Employee;

/**
 * Servlet implementation class useradd
 */
@WebServlet("/useradd")
public class useradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id = 0001;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Employees List</h1>");
		String name = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		
		String Dob 	=request.getParameter("dob");
		Date OB= new Date();
		try {
			OB = new SimpleDateFormat("dd/MM/yyyy").parse(Dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if (name != null && pass != null && email != null && city != null && !name.isEmpty() && !pass.isEmpty()
				&& !email.isEmpty() && !city.isEmpty()) {

			Employee emp = new Employee(id, name, email, pass, OB,city);
			id++;
			EmployeeDaoImpl DBemp = new EmployeeDaoImpl();
			DBemp.Save(emp);

			response.getWriter().print("user Addeed");
			response.setContentType("text/html");
			request.getRequestDispatcher("emp.html").include(request, response);

		} else {
			response.getWriter().print("user Not Addeed");
			response.setContentType("text/html");
			request.getRequestDispatcher("emp.html").include(request, response);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		out.println("<h1>Employees List</h1>");


	      String title = "Welcome Back to my website";

	      String userIDKey = new String("userID");
	      String userID = new String(request.getParameter("uname"));
	     
	      
		 // Check if this is new comer on your web page.
	      if (session.isNew()) {
	         title = "Welcome to my website"+userIDKey;
	         session.setAttribute(userIDKey, userID);
	      } else {
	        
	         userID = (String)session.getAttribute(userIDKey);
	      }
	  
	     

		
		
	
//     List<Emp> list=EmpDao.getAllEmployees(); 
		EmployeeDaoImpl db = new EmployeeDaoImpl();
		List<Employee> employees = db.getAllEmployee();

		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th></tr>");
		for (Employee emp : employees) {
			out.print("<tr><td>" + emp.getEmpId() + "</td><td>" + emp.geteName() + "</td><td>" + emp.getPassword()
					+ "</td><td>" + emp.getEmail() + "</td><td>" + emp.getCountry() + "</td><td></td>  </tr>");
		}
		out.print("</table>");
		out.print("<a href=userload>view GO </a>");

		out.close();
	}
}

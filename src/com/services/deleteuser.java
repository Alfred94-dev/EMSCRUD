package com.services;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class deleteuser
 */
@WebServlet("/deleteuser")
public class deleteuser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out = response.getWriter();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		EmployeeDaoImpl empImp = new  EmployeeDaoImpl();
		int idToDelete = 0;
		idToDelete = Integer.parseInt(request.getParameter("id"));
		
		empImp.Delete(idToDelete);
		
		
		
		
	}
	
}


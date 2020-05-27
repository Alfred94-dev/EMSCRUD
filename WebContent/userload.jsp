<%@page import="com.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
  
    %>
<!DOCTYPE html>
<html>
<head>
<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" \r\n" +
					"integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" \r\n" +
					"crossorigin=\"anonymous\">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
		EmployeeDaoImpl empImp = null;
		empImp = new EmployeeDaoImpl();
		
		
		List<Employee> list = empImp.getAllEmployee();
		System.out.println();
		try {
			
			
			 out.print("<table border='2' width='50%' class='table table-dark'>");
		     out.print("<tr class='thread-dark'><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th></tr>");
		        for(Employee e : list){
		         out.print("<tr><td>"+e.getEmpId()+"</td><td>"+e.geteName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td></td>"
		         		
		         		+ "<td><a href='useredit?id="+e.getEmpId()+"'>edit</a></td>"
		         		+ "<td><a href='DeleteUser?id="+e.getEmpId()+"'>delete</a></td>"
		         		+ "</tr>");
		    
	       
		        }
		        out.print("<table >");
		        out.print("<form action='LogOut' method='post'>");
				out.print("<tr><td colspan='2'><input type='submit' value='Logout'/></td></tr>");
				out.print("</table >");
		        out.print("<a href='useradd.html'> Add User</a>");
		         
		        out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		%>
		
</body>
</html>
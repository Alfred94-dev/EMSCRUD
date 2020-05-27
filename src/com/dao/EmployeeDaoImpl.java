package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root1-9");

		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

	@Override
	public int Update(Employee E) {

		Connection conn = getConnection();
		PreparedStatement pst = null;

		try {

			pst = conn
					.prepareStatement("update userCrud set name = ?, email = ? password = ?, country = ? where id = ?");

			pst.setString(1, E.geteName());
			pst.setString(2, E.getEmail());
			pst.setString(3, E.getPassword());
			pst.setString(4, E.getCountry());
			pst.setInt(5, E.getEmpId());

			pst.executeUpdate();

		} catch (Exception e) {

			System.out.println(e);
		}
		return 0;
	}

	@Override
	public int Delete(int id) {
		int status = 0;
		Connection conn = getConnection();
		PreparedStatement pst = null;
		try {
			conn = getConnection();
			pst = conn.prepareStatement("delete from userCrud where id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int Save(Employee e) {
		try {
			Connection con = getConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into userCrud(name,password,email,country)values(?,?,?,?)");

			pst.setString(1, e.geteName());
			pst.setString(2, e.getPassword());
			pst.setString(3, e.getEmail());
			pst.setString(4, e.getCountry());
			pst.executeUpdate();

		} catch (Exception e1) {
			System.out.println(e1);
		}

		return 0;
	}

	@Override
	public Employee getEmployeeById(int id) {

		Connection conn = getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("select * from usercrud where id=?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();

			
			if (result.next()) {
				Employee emp = new Employee(id, result.getString("name"), result.getString("email"),
						result.getString("password"), result.getString("country"));
				return emp;
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> list = new ArrayList<Employee>();
		Connection conn = getConnection();
		PreparedStatement stmt = null;
		try {
			 conn = getConnection();
			 stmt = conn.prepareStatement("select * from userCrud");
			ResultSet RS = stmt.executeQuery();
			while (RS.next()) {
				Employee e = new Employee(RS.getInt(1), RS.getString(2), RS.getString(3), RS.getString(4),
						RS.getString(5));
				list.add(e);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return list;
	}

}

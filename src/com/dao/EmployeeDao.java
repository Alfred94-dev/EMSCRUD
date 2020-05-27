package com.dao;

import java.util.List;

import com.entity.Employee;

	public interface EmployeeDao {

//	public int Update(int id);

	public int Delete(int id);

	public int Save(Employee e);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployee();

	public int Update(Employee E);

}

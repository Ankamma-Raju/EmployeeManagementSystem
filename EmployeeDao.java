package com.jsp.dao;

import java.util.List;

import com.jsp.model.Employee;
import com.jsp.servlet.GetEmployeesById;

public interface EmployeeDao 
{
	List<Employee> getAllEmployee();
	List<Employee> getEmployeeDetailsBySalaryOrDeptno(int deptno);
	Employee getEmployeeById(int id);
	int updateEmployeeDetails(Employee employee);
	int employeeRegistration(Employee employee);
	
	
	

}

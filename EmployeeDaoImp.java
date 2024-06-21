package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.jsp.model.Employee;

public class EmployeeDaoImp implements EmployeeDao
{
	String url="jdbc:mysql://localhost:3306/teca53?user=root&password=12345";
	String select="select * from employee";
	List<Employee> listEmployee=new ArrayList<Employee>();
	public List<Employee> getAllEmployee()
	{
		try 
		{			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url);
		Statement st=connection.createStatement();
		ResultSet resultSet=st.executeQuery(select);
		
		if(resultSet.isBeforeFirst())
		{
			while(resultSet.next())
			{
				Employee employee=new Employee();
			    employee.setEmpId(resultSet.getInt(1));
			    employee.setEmpName(resultSet.getString(2));
			    employee.setEmpSal(resultSet.getDouble(3));
			    employee.setEmpDeptNo(resultSet.getInt(4));
			    listEmployee.add(employee);
			    
			}
		}
		else
		{
			System.out.println("not data found");
		}	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return listEmployee;
	}
	
	public List<Employee> getEmployeeDetailsBySalaryOrDeptno(int deptno) {
		String select="select * from employee where emp_sal=? or emp_dept=?";
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(select);
			ps.setInt(1, deptno);
			ps.setInt(2, deptno);
			ResultSet resultSet=ps.executeQuery();
			if (resultSet.isBeforeFirst()) 
			{
				while(resultSet.next()) 
				{
					Employee employee =new Employee();
					employee.setEmpId(resultSet.getInt(1));
				    employee.setEmpName(resultSet.getString(2));
				    employee.setEmpSal(resultSet.getDouble(3));
				    employee.setEmpDeptNo(resultSet.getInt(4));
				    listEmployee.add(employee);					
				}
				return listEmployee;
			} 
			else 
			{
				return null;

			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;		
	}

	@Override
	public Employee getEmployeeById(int id) {
		String select="select * from employee where emp_id=?";
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet resultSet=ps.executeQuery();
			if (resultSet.next()) 
			{
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setEmpSal(resultSet.getDouble("emp_sal"));
				employee.setEmpDeptNo(resultSet.getInt("emp_dept"));
				
				return employee;
			}
			else
			{
				return null;

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public int updateEmployeeDetails(Employee employee) {
		String update="update employee set emp_name=?.emp_sal=?,emp_dept=? where emp_dept=?";
		try {
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(update);
			ps.setString(1, employee.getEmpName());
			ps.setDouble(2, employee.getEmpSal());
			ps.setInt(3,employee.getEmpDeptNo());
			ps.setInt(4, employee.getEmpId());
			int result =ps.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;		
	}
	public int employeeRegistration(Employee employee)
	{
		String insert="insert into employee (emp_name,emp_sal,emp_dept) values(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setString(1, employee.getEmpName());
			ps.setDouble(2,employee.getEmpSal());
			ps.setInt(3,employee.getEmpDeptNo());
			int result=ps.executeUpdate();
			return result;
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
}

package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImp;
import com.jsp.model.Employee;
@WebServlet("/Update")
public class UpdateEmployeeDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("empname");
		String salary=request.getParameter("empsalary");
		String deptno=request.getParameter("empdeptno");
		String tempid=request.getParameter("empid");
		
		
		Employee employee=new Employee();
		employee.setEmpId(Integer.parseInt(tempid));
		employee.setEmpName(name);
		employee.setEmpSal(Integer.parseInt(salary));
		employee.setEmpDeptNo(Integer.parseInt(deptno));
		
		
		EmployeeDao dao=new EmployeeDaoImp();
		int details=dao.updateEmployeeDetails(employee);
		PrintWriter pr=response.getWriter();
		response.setContentType("text/html");
		if (details!=0) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("Alltheemployees");
			rd.forward(request, response);
		} 
		else 
		{
			RequestDispatcher rd=request.getRequestDispatcher("Null.html");
			rd.forward(request, response);

		}	
	}

}

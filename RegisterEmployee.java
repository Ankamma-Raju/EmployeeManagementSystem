package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImp;
import com.jsp.model.Employee;
@WebServlet("/employeeRegistration")
public class RegisterEmployee extends HttpServlet
{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String tempSalary=request.getParameter("salary");
		double salary=Double.parseDouble(tempSalary);
		String tempDeptno=request.getParameter("deptno");
		int deptno= Integer.parseInt(tempDeptno);
		
		
		Employee emp=new Employee();
		emp.setEmpName(name);
		emp.setEmpSal(salary);
		emp.setEmpDeptNo(deptno);
		
		EmployeeDao dao=new EmployeeDaoImp();
		int registration= dao.employeeRegistration(emp);
		if (registration!=0) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("/RegisterEmployee.html");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("RegisterEmployee.html");
			rd.include(request, response);

		}
		
	}

}

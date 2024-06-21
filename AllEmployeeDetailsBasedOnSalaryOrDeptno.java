package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.EmployeeDao;
import com.jsp.dao.EmployeeDaoImp;
import com.jsp.model.Employee;
@WebServlet("/allemployeesBySalaryOrDeptno")
public class AllEmployeeDetailsBasedOnSalaryOrDeptno extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempdeptno=request.getParameter("deptno");
		int deptno=Integer.parseInt(tempdeptno);
		EmployeeDao dao=new EmployeeDaoImp();
		List<Employee> salaryOrDeptno= dao.getEmployeeDetailsBySalaryOrDeptno(deptno);
		HttpSession session=request.getSession();
		if (salaryOrDeptno!=null) 
		{
			session.setAttribute("listOfEmployees", salaryOrDeptno);
			RequestDispatcher dispatcher=request.getRequestDispatcher("AllEmployeeDetails.jsp");
			dispatcher.forward(request, response);
		} 
		else 
		{
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("Null.html");
			dispatcher.forward(request, response);
		}
	}
}

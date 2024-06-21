package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/Alltheemployees")
public class AllEmployeeDetails extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao dao=new EmployeeDaoImp();
		List<Employee> employees=dao.getAllEmployee();
//		System.out.println(employees);
		PrintWriter ps=response.getWriter();
		HttpSession session=request.getSession();
		session.setAttribute("listOfEmployees", employees);
		RequestDispatcher rd=request.getRequestDispatcher("AllEmployeeDetails.jsp");
		rd.forward(request, response);
		
		
//		ps.println(employees);
		
	}
	

}

package com.jsp.model;

public class Employee 
{
	private int EmpId;
	private String empName;
	private double empSal;
	private int empDeptNo;
	public Employee()
	{
		
	}
	
	public Employee(int empId, String empName, double empSal, int empDeptNo) {
		super();
		EmpId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empDeptNo = empDeptNo;
	}
	
	
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public int getEmpDeptNo() {
		return empDeptNo;
	}
	public void setEmpDeptNo(int empDeptNo) {
		this.empDeptNo = empDeptNo;
	}
	
	
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", empName=" + empName + ", empSal=" + empSal + ", empDeptNo=" + empDeptNo
				+ "]";
	}
	

}

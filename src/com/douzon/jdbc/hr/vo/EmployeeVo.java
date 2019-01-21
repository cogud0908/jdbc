package com.douzon.jdbc.hr.vo;

public class EmployeeVo {

	private int emp_no;
	private String name;
	private String hire_date;
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		
		return "사원 번호: "+getEmp_no()+" 이름 : "+getName()+" 입사일 : "+getHire_date();
	}	
}

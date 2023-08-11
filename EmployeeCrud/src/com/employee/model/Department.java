package com.employee.model;


public class Department {

	private int deptid;
	
	private String deptname;
	
	private int deptcode;
	


	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public int getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(int deptcode) {
		this.deptcode = deptcode;
	}



	public Department(int deptid, String deptname, int deptcode) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptcode = deptcode;
	;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Department(String deptname, int deptcode) {
		super();
		this.deptname = deptname;
		this.deptcode = deptcode;
	}

	@Override
	public String toString() {
		return "Department [deptid=" + deptid + ", Deptname=" + deptname + ", deptcode=" + deptcode+ "]";
	}
	
	
}

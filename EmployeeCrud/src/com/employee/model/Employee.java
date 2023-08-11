package com.employee.model;

import java.util.Arrays;
import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private int age;
	private Double salary;
	private Date joiningdate;
	private String[] skills;
	private int deptid;
	private String deptname;
	

	public Employee(int id, String name, int age, Double salary, Date joiningdate, String[] skills, int deptid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
		this.deptid = deptid;
	}

	public Employee(String name, int age, Double salary, Date joiningdate, String[] skills, int deptid) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String departmentName) {
		this.deptname = departmentName;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public Employee(int id, String name, int age, Double salary, Date joiningdate, String[] skills) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public Employee(String name, int age, Double salary, Date joiningdate, String[] skills) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
	}

	public Employee(int id, String name, int age, Double salary, Date joiningdate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
	}

	public Employee(int id, String name, int age, Double salary, Date joiningdate, String[] skills,
			String departmentName) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.joiningdate = joiningdate;
		this.skills = skills;
		this.deptname = departmentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", joiningdate="
				+ joiningdate + ", skills=" + Arrays.toString(skills) + ", deptid=" + deptid + ", DepartmentName="
				+ deptname + "]";
	}

	



}
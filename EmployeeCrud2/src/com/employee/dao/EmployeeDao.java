package com.employee.dao;

import java.sql.Array;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.employee.model.Employee;


public class EmployeeDao {
    int generateId;
	private String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	
	private String jdbcUsername = "root";
	
	private String jdbcpassword = "1234";

	private static final String insertEmp = "insert into employee (id,name,Age,Salary,skills, joining_date) "
			+ "values(?,?,?,?,?,?);";
	
	private static final String selectEmpById = "select e.id,e.name,e.Age,e.Salary,e.Joining_date,e.Skills from employee e where e.id=?;";
	
	private static final String selectAllEmP = "SELECT * FROM EMPLOYEE;";
	
	private static final String deleteEmpById = "delete  FROM EMPLOYEE where id= ?;	";
	
	private static final String UpdateEmpById = "update demo.employee set name=? ,  Age=?, Salary = ?, `Joining_date` = ? , skills = ? where id = ? ";

	
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	
	}
	 public void  insertEmp(Employee emp) throws SQLException{
		 try (Connection connecion = getConnection();
					PreparedStatement ps = connecion.prepareStatement(insertEmp,java.sql.Statement.RETURN_GENERATED_KEYS)) {
					ps.setInt(1, emp.getId());
					ps.setString(2, emp.getName());
					ps.setInt(3, emp.getAge());
					ps.setDouble(4, emp.getSalary());
					Date s1 =emp.getJoiningdate(); 
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
					String strDate = dateFormat.format(s1); 
					ps.setString(6,  strDate);
					String concat = null;
					
					String[] ans = new String[2];
					if(emp.getSkills() == null) {
						System.out.println("hello from if ");
					}
					else {
					ans = emp.getSkills();
					System.out.println(emp.getSkills() + "helllo");
					for(int i=0;i<ans.length;i++) {
						if(i<ans.length-1) {
							concat+= ans[i]+", ";
						}
						else {
							concat+= ans[i];
						}
					}
					}
//					for(String a:ans) {
//						if(a ans.length-1) {
//							
//						}
//						concat += a+" ";
//					}
					ps.setString(5, concat);
					System.out.println(ps);
					int affectedrows = ps.executeUpdate();
					if(affectedrows > 0)
					{
						ResultSet generatedKeys = ps.getGeneratedKeys();
						if(generatedKeys.next())
						{
							generateId = generatedKeys.getInt(1);
						}
						generatedKeys.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		 
	 }
	 
	 public boolean updateEmployee(Employee emp ) throws SQLException
	 {boolean rowupdated = false;
		try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(UpdateEmpById)) {
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getAge());
		    ps.setDouble(3, emp.getSalary());
			Date s1 =emp.getJoiningdate(); 
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			String strDate = dateFormat.format(s1); 
			ps.setString(4, strDate);
			String concat = "";
			System.out.println(Arrays.toString(emp.getSkills()));
			//System.out.println(emp.getSkills());
			String[] ans = emp.getSkills();
			System.out.println(Arrays.toString(emp.getSkills()));
			for(int i=0;i<ans.length;i++) {
				if(i<ans.length-1) {
					concat+= ans[i]+", ";
				}
				else {
					concat+= ans[i];
				}
			}
			ps.setString(5, concat);
			ps.setInt(6, emp.getId());
			System.out.println(ps);
			rowupdated = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowupdated;
		 
	 }
	 
	 public Employee selectEmployee(int id) {
			Employee emp = null;
			try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(selectEmpById)) {
				ps.setInt(1, id);
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("Age");
					Double salary = rs.getDouble("Salary");
					String joiningdate = rs.getString("Joining_date");
					Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(joiningdate);
					String str = rs.getString("Skills");
					String[] arr = str.split(" ");
					//Array skill =  rs.getArray("Skills")
					emp = new Employee(id, name,age, salary, date1,arr);
					System.out.println("Dao employee " +  emp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return emp;
		}
	 public List<Employee> ListAllEmployee() {
			List<Employee> emp = new ArrayList<Employee>();
			try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(selectAllEmP)) {
				System.out.println(ps);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int age = rs.getInt("Age");
					Double salary = rs.getDouble("Salary");
//					int salary = rs.getInt("Salary");
					String joiningdate = rs.getString("Joining_date");
					Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(joiningdate);
					//String skill = rs.getString("Skills");
					String str = rs.getString("Skills");
					String[] arr = null;
					if(str != null) {
					 arr = str.split(" ");}
					
					emp.add(new Employee(id, name, age, salary, date1, arr));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return emp;
		}
		
	   public boolean deleteEmployee(int id) {
			boolean rowdeleted=false;
			try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(deleteEmpById)) {
				ps.setInt(1, id);
				rowdeleted = ps.executeUpdate() > 0;
			} catch (Exception e) {
			}
			return rowdeleted;
		}
		

}

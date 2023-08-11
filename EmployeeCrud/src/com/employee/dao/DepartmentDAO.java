package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.employee.model.Department;
import com.employee.model.Employee;

public class DepartmentDAO {

	
	private String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";

	private String jdbcUsername = "root";

	private String jdbcpassword = "1234";
	
	private static final String AddDepartment = "insert into department (deptid,deptname,deptcode) values(?,?,?)";
	
	private static final String selectAllDept = "select * from department";
	
	private static final String selectDeprById = "select * from department where deptid = ? ";
	
	private static final String updateDeparmentById = "update department set deptname = ?, deptcode = ?  where deptid = ? ";
	
	private static final String deleteDepartmentById = "delete from department where deptid = ?;";
	
	int generateId;
	
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
	
	public void addDepartment(Department dept) throws SQLException {
		try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(AddDepartment, java.sql.Statement.RETURN_GENERATED_KEYS)) {
			
			ps.setInt(1, dept.getDeptid());
			ps.setString(2, dept.getDeptname());
			ps.setInt(3, dept.getDeptcode());
			int affectedrows = ps.executeUpdate();
			
			if (affectedrows > 0) {
				ResultSet generatedKeys = ps.getGeneratedKeys();
				if (generatedKeys.next()) {
					generateId = generatedKeys.getInt(1);
				}
				generatedKeys.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<Department> ListAllDepartment() {
		List<Department> dept = new ArrayList<Department>();
		try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(selectAllDept)) {
			//System.out.println(ps);
			System.out.println("hello i am list all department ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int deptid = rs.getInt("deptid");
				String deptname = rs.getString("deptname");
				int deptcode = rs.getInt("deptcode");

				dept.add(new Department(deptid, deptname, deptcode));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("hello i am list all department end ");
		return dept;
	}

	public boolean deleteDepartment(int id) {
		// TODO Auto-generated method stub
		boolean rowdeleted = false;
		try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(deleteDepartmentById)) {
			ps.setInt(1, id);
			rowdeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
		}
		return rowdeleted;
	}

	public Department selectDepartment(int deptid) {
		// TODO Auto-generated method stub
		Department dept = null;
		try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(selectDeprById)) {
			ps.setInt(1, deptid);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("deptname");
				int deptcode = rs.getInt("deptcode");
				
				dept = new Department(deptid,name, deptcode);
				System.out.println("Dao employee " + dept);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dept;
	}
	public boolean updateDepartment(Department dept) throws SQLException {
		boolean rowupdated = false;
		try (Connection connecion = getConnection(); PreparedStatement ps = connecion.prepareStatement(updateDeparmentById)) {
			
			ps.setString(1, dept.getDeptname());
			ps.setInt(2, dept.getDeptcode());
			ps.setInt(3,dept.getDeptid());
			rowupdated = ps.executeUpdate() > 0;
			System.out.println(dept);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowupdated;

	}
				
	
}

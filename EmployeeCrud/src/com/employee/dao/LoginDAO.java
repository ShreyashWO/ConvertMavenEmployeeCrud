package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	
	static final String jdbcUrl = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	static final String jdbcUsername = "root";
	static final String jdbcpassword = "1234";

	static final String checkUser = "select * from LoginDB where uname=? and pass=?";
	
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
	public boolean verifyUser(String uname, String password) {
	
	try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(checkUser)) {
			
		ps.setString(1, uname);
		ps.setString(2, password);
			System.out.println(ps+"this is quety");
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				return true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return false;
	}
	
}

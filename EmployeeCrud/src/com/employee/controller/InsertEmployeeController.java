package com.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;

//@WebServlet("/new")
public class InsertEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao empdao;

	public InsertEmployeeController() {
		this.empdao = new EmployeeDao();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("do get method from emp cont start");
		switch (action) {
		
		case "/new":
			try {
				showNewForm(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			try {
				System.out.println("i am default ");
				listemp(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		System.out.println("hello this is doGet Method  end");
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("employee-update.jsp");
		rd.forward(request, response);
	}
	private void listemp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Employee> listemp = empdao.ListAllEmployee();
		
		request.setAttribute("listemp", listemp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/emp-list.jsp");
		
		rd.forward(request, response);
	}
}

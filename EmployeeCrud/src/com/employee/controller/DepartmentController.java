package com.employee.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.DepartmentDAO;
import com.employee.model.Department;
import com.employee.model.Employee;

@WebServlet(urlPatterns = {"/dept","/newdept","/insertdept","/showdept","/updatedept","/listdept","/deptdelete","/deptedit"})
public class DepartmentController extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	private DepartmentDAO deptdao;
	
	public DepartmentController() {
		this.deptdao = new DepartmentDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("this is do get method from deptdaocontroller");
		System.out.println(action);
		switch (action) {
		
		case "/newdept":
			try {
				showNewForm(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "/deptdelete":
			try {
				this.doDelete(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/deptedit":
			try {
				showEditForm(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			try {
				listdept(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {

		case "/insertdept":
			try {
				insertDepartment(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "/updatedept":
			try {
				this.doPut(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listdept(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		System.out.println("hello this is doPost Method ");
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	String action = request.getServletPath();
		
		switch (action) {
		case "/deptdelete":
			try {
				deleteDepartment(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			try {
				listdept(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
         //System.out.println("hello this is deDelete method ");
     	//this.doGet(request,response);
	}
    
	
	private void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("deptid"));
		System.out.println(id+ "deptid is at first"); 
		deptdao.deleteDepartment(id);
		System.out.println(deptdao.deleteDepartment(id)); 
		response.sendRedirect("listdept");
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
    
		case "/updatedept":
			try {
				updateDepartment(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listdept(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		} //System.out.println("hello this is dePut method ");
	}
	private void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		String deptname = request.getParameter("deptname");
		int deptcode = Integer.parseInt(request.getParameter("deptcode"));

		Department dept = new Department(deptid, deptname, deptcode);
		deptdao.updateDepartment(dept);
		response.sendRedirect("listdept");
	}

	private void insertDepartment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		String deptname = request.getParameter("deptname");
		
		int deptCode = Integer.parseInt(request.getParameter("deptcode"));
		
		Department dept = new Department(deptname, deptCode);
		
		deptdao.addDepartment(dept);

		response.sendRedirect("listdept");
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Department> listdept = deptdao.ListAllDepartment();
		
		request.setAttribute("listdept", listdept);
		
		RequestDispatcher rd = request.getRequestDispatcher("department-form.jsp");
		
		rd.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		Department existingDepa = deptdao.selectDepartment(deptid);
		String deptname = existingDepa.getDeptname();
		int deptcode = existingDepa.getDeptcode();

		System.out.println("exist " + existingDepa);
		RequestDispatcher rd = request.getRequestDispatcher("department-form.jsp");
		request.setAttribute("dept", existingDepa);
		rd.forward(request, response);
	}


	private void listdept(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hello listdept from controller 1"); 
		
		List<Department> listdept = deptdao.ListAllDepartment();
		
		request.setAttribute("listdept", listdept);
		
		RequestDispatcher rd = request.getRequestDispatcher("dept-list.jsp");
		
		System.out.println("hello listdept from controller 4");
		
		rd.forward(request, response);
		
		System.out.println("hello listdept from controller 5");
	}
}

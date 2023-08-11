package com.employee.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.dao.LoginDAO;

@WebServlet(urlPatterns = {"/Login","/checkauth"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		LoginDAO loginDao = new LoginDAO();

		if (loginDao.verifyUser(uname, pass)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);

			response.sendRedirect("listdept");

		} else {
			String invalidmsg = "Your credentials are invalid";
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", invalidmsg);
			System.out.println(invalidmsg+ "i am in else");
			
			rd.forward(request, response);
			//response.sendRedirect("login.jsp");
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		// employee/new 
		case "/Login":
			try {
				showNewForm(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		default:
			try {
				System.out.println("i am default ");
				this.doPost(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		System.out.println("hello this is doGet Method  end");
		
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

}

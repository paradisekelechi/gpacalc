package com.sfx.gpcalc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sfx.gpcalc.dao.AccountDao;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		
		AccountDao daoHandler = new AccountDao();
    	try {
			daoHandler.connectDb();
		} catch (Exception e) {
			response.sendRedirect("register.jsp");
		}
    	
    	try {
			daoHandler.instantiateDao();
		} catch (Exception e) {
			response.sendRedirect("register.jsp");
		}
    	
    	Boolean register;
		try {
			register = daoHandler.addUser(username, password, email);
			
			if(register){
				session.setAttribute("user", username);
				session.setAttribute("loggedIn", true);
				response.sendRedirect("dashboard.jsp");
	    	}else{
	    		response.sendRedirect("register.jsp");
	    	}
		} catch (Exception e) {
			response.sendRedirect("register.jsp");
		}
    	
		double userGpa = daoHandler.getGpa(username);
		session.setAttribute("gpa", userGpa);
		
        try {
			daoHandler.closeConnection();
		} catch (Exception e) {
			response.sendRedirect("register.jsp");
		}
		
		
	}
	
	

}

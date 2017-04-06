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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		
		AccountDao daoHandler = new AccountDao();
    	try {
			daoHandler.connectDb();
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
    	
    	try {
			daoHandler.instantiateDao();
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
    	
    	Boolean check;
		try {
			check = daoHandler.checkUser(username, password);
			if(check){
				session.setAttribute("user", username);
				session.setAttribute("loggedIn", true);
				response.sendRedirect("dashboard.jsp");
	    	}else{
	    		response.sendRedirect("login.jsp");
	    	}
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
		
		double userGpa = daoHandler.getGpa(username);
		session.setAttribute("gpa", userGpa);
		
    	
        try {
			daoHandler.closeConnection();
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
		
		
	}

}

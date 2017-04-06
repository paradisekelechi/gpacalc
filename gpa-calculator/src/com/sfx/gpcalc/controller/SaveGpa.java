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
 * Servlet implementation class SaveGpa
 */
@WebServlet("/SaveGpa")
public class SaveGpa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveGpa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDao daoHandler = new AccountDao();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user");
		double gpa = 0.0;
		gpa = (double) session.getAttribute("gpa");
		
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
    	
    	Boolean save;
		try {
			save = daoHandler.saveGpa(username, gpa);
			if((boolean) session.getAttribute("loggedIn")){
				response.sendRedirect("dashboard.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
			
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
    	
        try {
			daoHandler.closeConnection();
		} catch (Exception e) {
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

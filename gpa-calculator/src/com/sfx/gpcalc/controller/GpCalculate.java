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
 * Servlet implementation class GpCalculate
 */
@WebServlet("/GpCalculate")
public class GpCalculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GpCalculate() {
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
		
		double total = 0.0;
		int courseTotal = 0;
		double gpa = 0.0;
		String resultClass;
		String[] courses;
		String[] grades;
		String[] units;
		String level = request.getParameter("level");
		courses = request.getParameterValues("courses");
		grades = request.getParameterValues("grades");
		units = request.getParameterValues("units");
		
		
		for(int i = 0; i < grades.length; i++)
		{
			int grade = Integer.parseInt(grades[i]);
			int unit = Integer.parseInt(units[i]);
			total += grade * unit;
			courseTotal += unit;
			
		}
		gpa = total/courseTotal;
		String formattedGpa = String.format("%.5g%n", gpa);
		request.setAttribute("gradepoint", formattedGpa);
		
		if(gpa < 2.5){
			resultClass = "Third Class";
		}else if(gpa < 3.5 && gpa >= 2.5){
			resultClass = "Second Class Lower";
		}else if(gpa >= 3.5 && gpa < 4.5){
			resultClass = "Second Class Upper";
		}else{
			resultClass = "First Class";
		}
		
		
		
		try {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}

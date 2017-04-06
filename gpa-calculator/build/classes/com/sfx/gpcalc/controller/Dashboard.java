package com.sfx.gpcalc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sun.net.www.URLConnection;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Set Facebook App details here 
    private static final String clientID = "1261598180625121";
    private static final String clientSecret = "8a45368bd8ea6511f63e1abaa3128ac0";
    private static final String redirectURI = "https://localhost/gpa-calculator/Dashboard";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            String rid = request.getParameter("request_ids");
            if (rid != null) {
                response.sendRedirect("https://www.facebook.com/dialog/oauth?client_id="
                        + clientID + "&redirect_uri=" + redirectURI);
            } else {
                // Get code
                String code = request.getParameter("code");
                if (code != null) {
                    
                    // Format parameters
                    URL url = new URL(
                            "https://graph.facebook.com/oauth/access_token?client_id="
                                    + clientID + "&redirect_uri=" + redirectURI
                                    + "&client_secret=" + clientSecret
                                    + "&code=" + code);
                    
                    // request for Access Token
                    HttpURLConnection conn = (HttpURLConnection) url
                            .openConnection();
                    conn.setRequestMethod("GET");
                    String line, outputString = "";
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        outputString += line;
                    }
                    System.out.println(outputString);
                    
                    // extract access token from response
                    String accessToken = null;
                    if(outputString.indexOf("access_token")!=-1) {
                        accessToken = outputString.substring(13,outputString.indexOf("&"));
                    }
                    
                    // request for user info
                    url = new URL("https://graph.facebook.com/me?access_token="
                            + accessToken);
                    System.out.println(url);
                    URLConnection conn1 = (URLConnection) url.openConnection();
                    outputString = "";
                    reader = new BufferedReader(new InputStreamReader(
                            conn1.getInputStream()));
                    while ((line = reader.readLine()) != null) {
                        outputString += line;
                    }
                    reader.close();
                    System.out.println(outputString);
                    response.sendRedirect("dashboard.jsp");
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

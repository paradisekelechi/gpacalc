package com.sfx.gpcalc.util;

public class Constant {

private static final String SERVER =  "localhost";
public static final String USERNAME =  "postgres";
public static final String PASSWORD =  "Skiposki";

public static String getServerUrl() {
		 String server = "jdbc:postgresql://" + SERVER +":5433/gpa_calculator";
	     System.out.println(server);
		return  server;
	}

}
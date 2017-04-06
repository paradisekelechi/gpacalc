<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Dashboard </title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="Login Page layout for the gpa-calculator application" content="">
<meta name="Kelechi" content="">

<!-- Le styles -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles -->
<link href="assets/css/custom.css" rel="stylesheet">
<link href="assets/css/style.css" rel="stylesheet">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Macondo" rel="stylesheet"> 

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">

		<div class="row title_row">
			<div class="col-md-6">
				<h1>GPA CALCULATOR </h1>
				
				<p>Calculate your Grade Point Average on the fly!</p>
			</div>
			<div class="col-md-6 welcome">
				<h3>Welcome ${sessionScope.user}!</h3>
				
				<p>A great platform for your GPA calculation!</p>
			</div>

		</div>
		
		<div class="row actions_row">
			<div class="col-md-2 pull-right  calculator_header">
				<h3><a href="Logout">Logout</a></h3>
			</div>
		</div>
			
			
		<div class="row actions_row">
				
			<div class="col-md-6">
				<h2 class="tiles">Latest Gpa: ${sessionScope.gpa}</a> </h2>
			</div>
			<div class="col-md-6">
				<h2 class="tiles"> <a href="gpa-calculator.jsp">Calculate GPA</a> </h2>
			</div>
			
		</div>

    </div> <!-- /container -->

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
			<div class="col-md-6 col-md-offset-3" >
				<form action="Register" method="post">
					<div class="form-group">
						<label class="special" for="username">Username</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username">
					</div>
					<div class="form-group">
						<label class="special" for="email">Email</label>
						<input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
					</div>
					<div class="form-group">
						<label class="special" for="Password">Password</label>
						<input type="password" class="form-control" name="password" id="password" placeholder="Enter Password">
					</div>
					<div class="form-group">
						<div class="col-md-8 pull-right">
							<button type="submit" class="btn btn-block btn-default">Register</button>
						</div>
					</div>
					
				</form>
			</div>

		</div>
		<div class="row actions_row">
			<div class="col-md-6 col-md-offset-3" >
				<div class="form-group">
					<div class="col-md-4">
						<label >Already a User?</label>
					</div>
					<div class="col-md-8">
						<a href="login.jsp">
							<button type="submit" class="btn btn-default btn-block">Login</button>
						</a>
					</div>
				</div>				
			</div>

		</div>
		
    </div> <!-- /container -->

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
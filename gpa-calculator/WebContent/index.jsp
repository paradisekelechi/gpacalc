<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GPA Calculator</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
  <script src="https://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>
<body>
	<body>
	<div class="container">

		<form action="GpCalculate" method="post">
		
			<div class="row title_row">
				<a href="login.jsp">
					<div class="col-md-3 btn btn-primary calculator_header" >
						<h3>Login</h3>
						<p>Save your GPA</p>
					</div>
				</a>
				
				<div class="col-md-6 calculator_header pull-right" >
					<div class="col-md-8">
						<h3>GRADE POINT AVERAGE</h3>
						<h1><%= request.getAttribute("gradepoint")%></h1>
						<p><%= request.getAttribute("result")%> Degree</p>
					</div>
					
				</div>
			</div>
			
			<div class="row actions_row">
				<div class="col-md-12 calculator_header">
					<h3 style="text-transform:capitalize !important;">calculate your grade point Average (GPA)</h3>
					<p>Enter the course unit load and grades to calculate your Grade Point Average. </p>
				</div>
			</div>

			<div class="row actions_row">
				<div class="col-md-12 calculator_header header_data">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label for="units">Course Level</label>
							<select name="level" class="select">
								<option value="0">Select Course Level</option>
								<option value="1">100</option>
								<option value="2">200</option>
								<option value="3">300</option>
								<option value="4">400</option>
								<option value="5">500</option>
								<option value="6">600</option>
							</select>
						</div>
						
					</div>
				</div>
			</div>

			<div class="row actions_row">
					
				
				<div class="col-md-12 calculator_wrapper" >
					
					<div>
						<div class="input_fields_wrap" id="courseAdd">
							<div class="col-md-4">
								<div class="form-group">
									<label for="course" >Course Title</label>
									<input  type="text" class="form-control" id="course" name="course" value=" ">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label for="units">Unit Load</label>
									<select name="units" class="select">
										<option value="1">Select Unit Load</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label for="grade">Course Grade</label>
									<select name="grades" class="select">
										<option value="0">Select Grade</option>
										<option value="5">A</option>
										<option value="4">B</option>
										<option value="3">C</option>
										<option value="2">D</option>
										<option value="1">E</option>
										<option value="0">F</option>
									</select>
								</div>
							</div>
							<div class="col-md-2">
								<button class="btn btn-block btn-primary __button add-button">Add Course</button>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>

					<div class="col-md-12">
						<button class="btn btn-primary btn-block __button submit_button"> Calculate Grade Point Average</button>
					</div>
					
				</div>
				
			</div>

		</form>

    </div> <!-- /container -->

   

	<script>
	$(document).ready(function() {
	    var max_fields      = 30; //maximum input boxes allowed
	    var wrapper         = $(".input_fields_wrap"); //Fields wrapper
	    var add_button      = $(".add-button"); //Add button ID
	   
	    var x = 1; //initlal text box count
	    $(add_button).click(function(e){ //on add input button click
	        e.preventDefault();
	        if(x < max_fields){ //max input box allowed
	            x++; //text box increment
	            
	            $(wrapper).append('<div class="addedData"><div class="col-md-4"><div class="form-group"><label for="course" >Course Title</label><input  type="text" class="form-control" id="course" name="course" value=" "></div></div><div class="col-md-3"><div class="form-group"><label for="units">Unit Load</label><select name="units" class="select"><option value="1">Select Unit Load</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option></select></div></div><div class="col-md-3"><div class="form-group"><label for="grade">Course Grade</label><select name="grades" class="select"><option value="0">Select Grade</option><option value="5">A</option><option value="4">B</option><option value="3">C</option><option value="2">D</option><option value="1">E</option><option value="0">F</option></select></div></div><div class="col-md-2"><button class="btn btn-block btn-danger btn-default __button remove_button">Remove</button></div><div class="clearfix"></div></div></div>'); //add input box
	        }
	    });
	   
	    $(wrapper).on("click",".remove_button", function(e){ //user click on remove text
	        e.preventDefault(); 
	        $(this).parents('.addedData').remove(); 
	        x--;
	    })
	});
	</script>

	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
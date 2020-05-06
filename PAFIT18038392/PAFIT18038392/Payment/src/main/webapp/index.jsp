<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Health care System</title>
    <!-- Bootstrap -->
<link rel="stylesheet" href="Views/css/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/payments.js"></script>
	  	<link href="customcss/style.css" rel="stylesheet" type="text/css">
	  	  	<link href="customcss/button.css" rel="stylesheet" type="text/css">


	  
  </head>
  <body>
  	<!-- body code goes here -->

	  
	  <nav class="navbar navbar-expand-lg navbar-light bg-dark table-responsive-sm">
  <a class="navbar-brand text-white" href="Home.html"><h3>HEALTH CARE ONLINE</h3></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  
</nav>
	
	  
	<div class="containerhead">
	<img src="img/45596.jpg" alt="" style="height:400px" width="100%">
		<div class="container1">
		<div class="centered">
		<span class="text1">Welcome in</span>
  <span class="text2">Payment management</span>
			 


		
		</div>
		</div>
	
	  </div>
	  
	  
	  
	 
<div class="container mt-5">
<div class="row ">
<div class="col-12 col-md-6 col-lg-6">
<h3 class="text-center mb-4">MANAGE YOUR PAYMENTS</h3>
<form id="formItem" name="formItem" method="post" action="index.jsp">
 Appointment ID:
 <input id="appID" name="appID" type="text"
 class="form-control form-control-sm">
 <br> Patient Name:
 <input id="pName" name="pName" type="text"
 class="form-control form-control-sm">
 <br> Amount:
 <input id="pAmount" name="pAmount" type="text"
 class="form-control form-control-sm">
 <br> Card Name:
 <input id="cName" name="cName" type="text"
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave"
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
	


</div>
	
	<div class="col-12 col-md-6 col-lg-6 mt-5">
	<div id="divItemsGrid">
 <%
 Payment paymentObj = new Payment();
 out.print(paymentObj.readPayments());
 %>
</div>
	
	</div>
 </div>
</div>
	  
	  

	  
	  
	 
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="Views/js/bootstrap.min.js"></script>
	<!--   <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>-->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
	<footer>
	
	<div class="container-fluid bg-dark mt-5">
	  <div class="row">
		<div class="col-12 text-center text-white mt-1 mb-1">
			
		<!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <a href="https://mdbootstrap.com/">IT18039214 (Kekirideniya K.R)</a>
  </div>
  <!-- Copyright -->

		  </div>
		
		
		</div>
	  
	  
	  </div>
	
	
	</footer>
</html>
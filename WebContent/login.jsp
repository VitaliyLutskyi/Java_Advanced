<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>

<!-- Font Icon -->
<link rel="stylesheet" 	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
<!-- Main css -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="main">
		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an	account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form class="register-form" id="login-form">
							<div class="form-group">
								<label for="eMail"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="email" name="eMail" id="your_email"
									placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="your_pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="your_pass"
									placeholder="Password" />
							</div>

							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
							<div class="form-group">
								<p style="display: none; color: red">Please fill all fields!</p>
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="#"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>
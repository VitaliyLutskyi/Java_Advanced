<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Create</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
  <link rel="stylesheet" href="css/style.css">  
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	 <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Create new magazine</h2>
                        <form method="POST" action="magazine" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"></label>
                                <input type="text" name="name" id="name" placeholder="Title"/>
                            </div>
                            <div class="form-group">
                                <label for="description"></label>
                                <input type="text" name="description" id="description" placeholder="Description"/>
                            </div>
                            <div class="form-group">
                                <label for="price"></label>
                                <input type="number" name="price" id="price" placeholder="Price"/>
                            </div>
                            <div class="form-group">
                                <label for="stock_quantity"></label>
                                <input type="number" name="stock_quantity" id="stock_quantity" placeholder="Stock quantity"/>
                            </div>
                            
                            <div class="form-group">
								<p style="display: none; color: red">Please fill all fields!</p>
							</div>
                            <div class="form-group form-button">
                                <input type="submit" name="add" id="add" class="form-submit" value="Add"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        
                    </div>
                </div>
            </div>
        </section>
        </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
    
    <!-- JS -->
 <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/serverCalls.js"></script>
    
</body>
</html>
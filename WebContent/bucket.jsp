<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bucket</title>
<link rel="stylesheet" href="css/bucket.css">

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="Features-section paddingTB60 ">
		<div class="container">
			<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for names.." title="Type in a name">

			<table id="myTable">
				
			</table>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="js/bucket.js"></script>
	<script src="js/serverCalls.js"></script>
</body>
</html>
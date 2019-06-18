$(document).ready(function() {
	$('input#signin').click(function() {
		var userLog = {
			eMail : $('#login-form input#your_email').val(),
			password : $('#login-form input#your_pass').val()
		};
		if (userLog.eMail == '' || userLog.password == '')
			$('div.form-group p').show();
		else {
			$('div.form-group p').hide();
			$.ajax({
				type : "POST",
				url : "login",
				data : userLog,
				success : function(response) {
						if (response != '')
							window.location = response.destinationUrl;
						else
							$("form")[0].reset();					
				}
			});
		}
		return false;
	});

	$('input#signup').click(function(){
		var userReg = {
				firstName : $('#register-form input#name').val(),
				lastName : $('#register-form input#surname').val(),
				age : $('#register-form input#age').val(),
				address: $('#register-form input#addresss').val(),
				eMail: $('#register-form input#email').val(),
				password: $('#register-form input#pass').val(),
				cpassword :$('#register-form input#re_pass').val()
			};
		if (userReg.firstName == '' || userReg.lastName == '' || userReg.age == ''
				|| userReg.eMail == '' || userReg.password == '' || userReg.cpassword == '')
			$('div.form-group p').show();
		else if (userReg.password !== userReg.cpassword) {
			$('div.form-group p').hide();
			alert ("Password and repeat password don't match!");
		}
		else {
			$('div.form-group p').hide();
			
			$.ajax({
				type : "POST",
				url : "registration",
				data : userReg,
				success : function(response) {
					if (response != '')
						window.location = response.destinationUrl;
					else
						$("form")[0].reset();
				}
			});
		}
		return false;
	});
	
	
	
	
});







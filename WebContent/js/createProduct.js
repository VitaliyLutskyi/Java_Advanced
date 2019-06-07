$('input#add').click(function() {
		var magazine = {
			name : $('#register-form input#name').val(),
			description : $('#register-form input#description').val(),
			price : $('#register-form input#price').val(),
			stock_quantity : $('#register-form input#stock_quantity').val()
		};
		if (magazine.name == '' || magazine.description == '' || magazine.price == '' || magazine.stock_quantity == '')
			$('div.form-group p').show();
		else {
			$('div.form-group p').hide();
			$.ajax({
				type : "POST",
				url : "magazine",
				data : magazine,
				success : function(response) {
						if (response != '')
							window.location = response;
						else
							$("form")[0].reset();					
				}
			});
		}
		return false;
	});
$('form').submit(function(e) {
	e.preventDefault();
	if (validform() === true) {

		var $photo = $("#photo");
	    var fd = new FormData;

	    fd.append('photo', $photo.prop('files')[0]);
	    fd.append('name', $('#name').val());
	    fd.append('surname', $('#surname').val());
	    fd.append('age', $('#age').val());

	    $.ajax({
	        url: 'register',
	        data: fd,
	        processData: false,
	        contentType: false,
	        type: 'POST',
	        success: function (student) {
	        	$('form').hide();
	        	$('div.show_photo').html('	<h2>'+	student.name	 + '</h2> '+
										 '	<h3>'+	student.surname + '</h3> '+
										 '  <h3>'+	student.age		+	'</h3> '+
										 '	<img src=""	width="240" height="300" /> ' );
	        	
	            $('img').attr("src", 'data:image/png;base64,'+student.base64Image);
	        	$('div.show_photo').show();
	        }
	    });
		
	}
	

});

function validform() {

	var a = document.forms["my-form"]["name"].value;
	var b = document.forms["my-form"]["surname"].value;
	var c = document.forms["my-form"]["age"].value;
	var d = document.forms["my-form"]["photo"].value;

	if (a == null || a == "") {
		alert("Please Enter Your Name");
		return false;
	} else if (b == null || b == "") {
		alert("Please Enter Your Surname");
		return false;
	} else if (c == null || c == "") {
		alert("Please Enter Your Age");
		return false;
	} else if (d == null || d == "") {
		alert("Please load your photo");
		return false;
	}
	return true;

}

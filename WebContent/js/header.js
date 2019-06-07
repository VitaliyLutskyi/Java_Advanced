$('a.logout').click(function(){
	$.ajax({
		type : "GET",
		url : "logout",
		success : (response) => window.location = response	
	});
})
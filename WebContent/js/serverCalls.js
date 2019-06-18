// Create magazine
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

// Logout
$('a.logout').click(function(){
	$.ajax({
		type : "GET",
		url : "logout",
		success : (response) => window.location = response	
	});
})

// Add to bucket
$('button[product-id]').click(function(){
	
	var id = jQuery(this).attr('product-id');
	
	$.ajax({
		type : "POST",
		data : {'magazineId': id},
		url : "bucket",
		success : (response) =>	response == 'ok' ? $('#buyMagazineModal').modal('hide') : ''
		
	});
	
	});

//Delete magazine from bucket
function deleteRecordFromBucket(bucketId){
	$.ajax({
		type : "DELETE",
		url : "bucket?bucketId=" + bucketId,
		success : (response) =>	response == 'ok' ? location.reload() : ''
		
	});
}






































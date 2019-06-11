var products = null;

$.get("magazines", function(data) {
	if (data !== '') {
		products = data;
	}
}).done(function() {
	
	var cardsContent = "";
	jQuery.each(products, function(i, value) {
	
		cardsContent+="<div class='Features-section paddingTB60'>" +
					  "<div class='container'>" +
					  "<div class='row'>" +
					  "<div class='col-sm-6 col-md-3'>" +
					  "<div class='col-md-12 feature-box'>" +
					  
					  "<h4>" + value.name + "</h4>"+
					  "<h5>" + value.price + "$" + "</h5>"+
					  "<h6>" + "In stock " + value.stockQuantity + "</h6>"+
					  "<p>" + value.description + "</p>"+
					  "<a href='magazine?id=" + value.id + "' class='btn btn-primary site-btn'>Open</a>"+
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>" +
					  "</div>"

	});
	
	  $('.product-card').html(cardsContent);
	
});
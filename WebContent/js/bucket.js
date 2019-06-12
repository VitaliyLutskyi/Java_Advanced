// Filtering elements
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

// Fill bucket
var buckets = null;

$.get("bucket", function(data) {
	if (data != '') {
		buckets = data;
	}
}).done(function() {
	
	var tableContent = "<tr class='header'>"+
							"<th>Name</th>"+
							"<th>Description</th>"+
							"<th>Price</th>"+
							"<th>Purchase date</th>"+
							"<th></th>"+
						"</tr>";
	jQuery.each(buckets, function(i, value) {
	
		tableContent+= "<tr>"+
							"<td>" + value.name + "</td>"+
							"<td>" + value.description + "</td>"+
							"<td>" + value.price + "</td>"+
							"<td>" + value.purchaseDate + "</td>"+
							"<td><button onclick='deleteRecordFromBucket(" + value.bucketId + ")'>Delete</button></td>"+							
						"</tr>";

	});
	
	  $('#myTable').html(tableContent);
	
});































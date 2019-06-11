<jsp:include page="header.jsp"></jsp:include>

<div class="Features-section paddingTB60" style="margin-top: 60px">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3">
				<div class="col-md-12 feature-box">
					
					<h4>${magazine.name}</h4>
					<h5>${magazine.price}</h5>
					<h6>${magazine.stockQuantity}</h6>
					<p>${magazine.description}</p>
					<button type="button" class="btn btn-primary site-btn" data-toggle="modal" data-target="#buyMagazineModal">Buy now</button> 

				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="buyMagazineModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Sure you want to buy it?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary buy-product" product-id="${magazine.id}">Buy</button>
      </div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script src="js/serverCalls.js"></script>
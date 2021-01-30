<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/common/menu.jsp"></jsp:include>
		<div class="row">
			<div class="col">
			<h3>Sale History</h3>
				<div class="row my-4">
					<div class="col-8 mr-auto ml-auto">
					<c:url value="/sale-search" var="search"></c:url>
						<form action="${search}" class="form form-inline">
							<div class="form-group">
								<label for="from">From</label>
								<input value="${param.from}" type="date" class="form-control mx-2" id="from" name="from">
								<label for="to">To</label>
								<input value="${param.to}" type="date" class="form-control mx-2" id="to" name="to">
							</div>
							<button type="submit" class="btn btn-primary mx-2">Search</button>
						</form>
			</div>
		</div>
		<!--sale history -->
			<table class="table" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>Id</th>
							<th>Sale Date</th>
							<th>Total Quantity</th>
							<th>Tax</th>
							<th>Total Balance</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="table">
					
						<c:forEach items="${salesList}" var="s">
							<tr>
								<td>${s.id}</td>
								<td>${s.saleDate}</td>
								<td>${s.totalSaleQty}</td>
								<td>${s.tax}</td>
								<td>${s.total}</td>
								<td>
									<!-- Button trigger modal -->
									<button type="button" class="btn btn-outline-primary detail" data-toggle="modal" data-id="${s.id}" data-target="#saledetail">
									  Sale Items
									</button>
								</td>
							</tr>
						</c:forEach>
						
						
					</tbody>
				</table>
	</div>
	<!-- sale-detail modal -->
	<div class="modal fade" id="saledetail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Sale Items</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>Product</th>
						<th>Price</th>
						<th>Qty</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
				</tbody>
			</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary px-3" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
		<script type="text/javascript">
		$(document).ready(function(){
			$('#table').on('click','.detail',function(){
				var id=$(this).data('id');
				//alert(id);
				$.get('sale-detail?id='+id,function(responseJson){
				 	
					//console.log(typeof responseJson);
					var saledetailList=JSON.parse(JSON.stringify(responseJson));
					var html = "";
					//console.log(typeof saledetailList);
					$.each(saledetailList,function(i,v){
						/* console.log(v.product); */
						html += '<tr>'+
									'<td>'+v.product+'</td>'+
									'<td>'+v.price+'</td>'+
									'<td>'+v.qty+'</td>'+
									'<td>'+v.price * v.qty+'</td>'+
								'</tr>';
					})
					$('#tbody').html(html);
				}); 
			
				
			})
			
	    })
	</script>
</body>
</html>
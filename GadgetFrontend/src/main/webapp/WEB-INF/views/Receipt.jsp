<%@ include file="Header.jsp" %>  
<div class="container">

<table align="center" class="table table-bordered" style="width:50%">
<tr>
<td colspan=2 bgcolor="pink"><center><b><h3>Invoice</h3></b></center></td></tr>

<tr>
<td>Order Id </td>
<td>${orderId}</td>
</tr>
<tr>
<td>Order Date</td> 
<td>${orderDate}</td>
</tr>
<tr>
<td>Order Total</td> 
<td>Rs.${orderTotal}</td>
</tr>
<tr>
<td>Payment Mode</td>
 <td>${orderPayment}</td>
</tr>
</table>

<table align="center" class="table table-bordered">

<tr bgcolor="cyan">
<td colspan=4></td>
<td colspan=4>Product Name</td>
<td>Price</td>
<td>Quantity</td>
<td colspan=2>Total Item Price</td>
</tr>

<c:forEach items="${listCartItems}" var="cartItem">
<tr>
<td colspan=4><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>"  height=50 width=30 /></td>

<td colspan=4>${cartItem.productName}</td>

<td>Rs.${cartItem.price}</td>

<td>${cartItem.quantity}</td>

<td colspan=2>${cartItem.quantity*cartItem.price}</td>

</tr>
</c:forEach>

<tr>
 <td colspan=8><b><center>Order Value</center></b>
 <td colspan=4><b>Rs.${CartValue}</b> 
</tr>
</table>


<div class="container">
<h3>Shipping Address</h3>
${Address}<br>
</div>

<div class="container">
<h3>Unlock Your Credit Points</h3>
<a href="<c:url value="/generateCredits/${orderId}"/>" ><button type="button" class="btn btn-primary">Hurray!</button></a>

</div>

</div>

</body>
</html>
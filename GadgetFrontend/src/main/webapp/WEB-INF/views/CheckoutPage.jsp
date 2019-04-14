<%@ include file="Header.jsp" %>  

<div class="container">

<table class="table table-bordered">
<tr><center><b><h3>Checkout List</h3></b></center></tr>

<tr>
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

</div>


<div class="container">
<form action="<c:url value="/confirmAddress" />"  method="post">
<table class="table table-bordered" style="width:80%">
<center><b><h3>Confirm Shipping Address</h3></b></center>
<tr>
<td>Full Name</td>
<td><input type="text"  name="Name"/></td>
</tr>
<tr>
<td>Mobile Number</td>
<td><input type="text"  name="Number"/></td>
</tr>
<tr>
<td>Pin Code</td>
<td><input type="text"  name="PinCode"/></td>
</tr>
<tr>
<td>House Address</td>
<td><input type="text"  name="HouseAddress"/></td>
</tr>
<tr>
<td>City</td>
<td><input type="text"  name="City"/></td>
</tr>
<tr>
<td>State</td>
<td><input type="text"  name="State"/></td>
</tr>

<tr>
<td></td>
<td><input type="submit"  value="Set Delivery Address"/>&nbsp;&nbsp;
<input type="reset"  value="Clear Details"/></td>
</tr>

</table>

</form>
</div>
</body>
</html>
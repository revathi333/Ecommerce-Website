<%@ include file="Header.jsp" %>   

<div class="container">
<table class="table table-bordered">
<tr><center><b><h3>Shopping Cart</h3></b></center></tr>
<tr>
<td colspan=4></td>
<td colspan="4">Product Name</td>
<td>Price</td>
<td>Quantity</td>
<td>Total Item Price</td>
<td></td>

</tr>


<c:forEach items="${listCartItems}" var="cartItem">

<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}" />" method="get" >

<tr>
<td colspan=4><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>"  height=50 width=30 /></td>

<td colspan="4">${cartItem.productName}</td>

<td>Rs.${cartItem.price}</td>

<td><select name="quantity">
  <option value="1">${cartItem.quantity}</option>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
</select></td>

<td>${cartItem.quantity*cartItem.price}</td>

<td colspan=3><center>
<input type="submit" value="update Qty" class="btn btn-success"/>
<a class="btn btn-info" href="<c:url value="/moveTosaveForLater/${cartItem.cartItemId}" />">Save for Later</a>
<a class="btn btn-danger" href="<c:url value="/deleteCartItem/${cartItem.cartItemId}" />">Delete</a></center>
</td>
</tr>

</form>

</c:forEach>
 
 <tr>
 <td colspan=8><b><center>Cart Value</center></b>
 <td colspan=4><b>Rs.${CartValue}</b>
</tr>

<tr>
<td colspan=10><b><center><a href="<c:url value="/productsDisplay"/>">Continue Shopping</a></center></b> </td>
<c:if test="${cartsize>0}">
<td colspan=4><b><center><a href="<c:url value="/checkout"/>">CheckOut</a></center></b> </td>
</c:if>
</tr>

</table>
 </div>
 
<c:if test="${count>0}">

<div class="container">
<h3><center>Saved For Later</center></h3>

<table class="table table-bordered" >
<tr>
<td colspan=4></td>
<td colspan="4">Product Name</td>
<td>Price</td>
<td></td>
</tr>
<c:forEach items="${savedItemsList}" var="savedItem">
<tr>

<td colspan=4><img src="<c:url value="/resources/images/${savedItem.productId}.jpg"/>"  height=50 width=30 /></td>

<td colspan=4>${savedItem.productName}</td>

<td>Rs.${savedItem.price}</td>

<td><b><a class="btn btn-info" href="<c:url value="/moveToCart/${savedItem.savedItemId}"/>">Move To Cart</a></b> 
 
<b><a class="btn btn-danger" href="<c:url value="/deletesaveditem/${savedItem.savedItemId}"/>">Delete</a></b> </td>

</tr>
</c:forEach>
</table>
</div>

</c:if>
</body>
</html>
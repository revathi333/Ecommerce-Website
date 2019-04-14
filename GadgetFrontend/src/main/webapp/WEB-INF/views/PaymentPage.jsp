<%@ include file="Header.jsp" %>   

<div class="container">
<form action="<c:url value="/confirmPayment" />" method="post">
<table class="table table-bordered" align="center" style="width:50%">
<h3><center>Select a payment method</center></h3>

<tr>
<td>Amount Payable : Rs.<c:out value="${CartValue}" /></td>
</tr>
<tr>
 <td><input type="radio" name="paymentMode" value="POD" checked>Pay on Delivery</td>
 </tr>
 
 <tr>
 <td><input type="radio" name="paymentMode" value="CC">Prepaid Order<br>
 
 <table class="table table-bordered" align="center" style="width:50%">
 
 <tr>
<td>Name on Card</td>
<td><input type="text" name="Name"/></td>
</tr>
<tr>
<td>Card Number</td>
<td><input type="text" name="CardNumber"/></td>
</tr>

<tr>
<td>Expiry Date</td>
<td><input type="month" name="ExpiryDate">
</td>
</tr>

<tr>
<td>CVV Number</td>
<td><input type="text" name="CVVNumber"/></td>
</tr>

 </table>
 
 </td>
 
 <tr>
<td colspan=2><Center><b><input type="submit" class="btn btn-success" value="Place Order"/></b></Center></td>
</tr>
 </tr>
 

</table>
</form>
</div>
</body>
</html>
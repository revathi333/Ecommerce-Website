<%@ include file="Header.jsp" %>

<c:if test="${O_Id ne 0}" >
<div class="container">
<h2><b>You've earned Rs.${orderCredits.credits} on your latest order</b></h2><br>
</div>
</c:if>

<c:if test="${size==0}" >
<div class="item-photo">
<center>
<img src="<c:url value="/resources/images/credits.jpg"/>"  height=300 width=500 />
<h3>You've not earned any credit points yet.<br><a href="<c:url value="/productsDisplay"/>"><br>Shop Now For Instant CashBack</a></h3>
</center>
</div>
</c:if>

<c:if test="${size ne 0}" >

<div class="container">

<table align="center" class="table table-bordered" style="width:50%">

<tr>
<td colspan=2 bgcolor="pink"><h3><b><center>Your Credit Points Statement<center></b></h3></td>
</tr>

<tr>
   <td><b>Credits ID</b></td>
   <td><b>Earned credits</b></td>
</tr>


<c:forEach items="${listCredits}" var="Credits">  
<tr>
  <td>${Credits.creditsId}</td>
  <td>Rs. ${Credits.credits}</td>  
</tr>
</c:forEach>
</table>

<br>
<div class="container">
<h2><b>Total Credits : Rs.${totalCredits}</b></h2>
</div>


</div>

</c:if>

</body>
</html>
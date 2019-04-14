<%@ include file="Header.jsp" %>

<div class = "row">

<c:forEach items="${listProducts}" var="product">

   <div class = "col-sm-2 col-sm-2">
<a href="<c:url value="/detailProductDisplay/${product.productId}" />" class="thumbnail">
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" alt="Generic placeholder thumbnail" width=300 height=300/></a> 


<br>
<strong>${product.productName}</strong><br>
<strong>Rs.${product.price}</strong><br>


  <c:choose>
  
    <c:when test="${product.stock>0}" >
     <i>In Stock</i>
    </c:when>   
    
    <c:otherwise>
       <font color="red"><b>Out of Stock</b></font>
    </c:otherwise>
    
   </c:choose> 
 
</div> 
</c:forEach>


</div>

</body>
</html>
<%@ include file="Header.jsp" %>


<div class="container">
<div class="col-md-4 item-photo">
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>"  height=500 width=300 />
</div>

<div class="col-md-4">
<h3><b>${product.productName}</b></h3>
<h5><small>Stock : ${product.stock}</small></h5>
<h4><b>M.R.P. : Rs.${product.price}</b></h4>
<h6>Description : ${product.productDesc}</h6>


<c:choose>
<c:when test="${product.stock>0}">
<a href="<c:url value="/addToCart/${product.productId}"/> "><input type="submit" class="btn btn-success" value="Add to Cart"/></a>
</c:when>
<c:otherwise>
<i>Will be soon In Stock</i>
<a class="btn btn-info" href="<c:url value="/saveForLater/${product.productId}" />">Save for Later</a>
</c:otherwise>
</c:choose>
</div>

</div>

</body>
</html>
</body>
</html>
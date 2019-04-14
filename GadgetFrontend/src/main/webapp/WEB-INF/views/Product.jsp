<%@ include file="Header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
<form:form modelAttribute="product"  action="InsertProduct" method="post" enctype="multipart/form-data" >
<table align="center" class="table table-bordered" style="width:50%">

<tr>
  <td colspan=2 bgcolor="green"><center><strong>Enter Product Details<strong></center></td>
</tr>

<tr>
<td colspan=2><h5 align="center"><font color="red">${Error}</font></h5>
</td>
</tr>

<tr>
  <td>Product Name</td>
  <td><form:input path="productName"/></td>
</tr>

<tr>
  <td>Product Desc</td>
  <td><form:input path="productDesc"/></td>
</tr>

<tr>
  <td>Category ID</td>
  <td>
  <form:select path="categoryId">
  <form:option value="0" label="---Select Category---" />
  <form:options items="${listOfCategories}" />
  </form:select>
  </td>
</tr>

<tr>
  <td>Supplier ID</td>
  <td>
  <form:select path="supplierId">
  <form:option value="0" label="---Select Supplier---" />
  <form:options items="${listOfSuppliers}" />
  </form:select>
  </td>
</tr>

<tr>
  <td>Product Stock</td>
  <td><form:input path="stock"/></td>
</tr>

<tr>
  <td>Product Price</td>
  <td><form:input path="price"/></td>
</tr>

<tr>
<td>Product Image</td>
<td><form:input type="file" path="pimage" /></td>
</tr>

<tr bgcolor="yellow">
  <td colspan=2><center><strong><input type="submit" value="Insert New Product" />    <input type="reset" value="Clear All" /></strong></center></td><br>
</tr>

</table>
</form:form>

<br><br><br>
<table align="center" class="table table-bordered">

<tr>
<td colspan=9 bgcolor="pink"><h3><b><center>Total Products List<center></b></h3></td>
</tr>

<tr>
    <td><b>Product ID</b></td>
    <td><b>Product Name</b></td>
    <td><b>Category Id</b></td>
    <td><b>Supplier ID</b></td>
    <td><b>Product Stock</b></td>
    <td><b>Product Price</b></td>
    <td><b>Operations</b></td>
</tr>


<c:forEach items="${listProducts}" var="product">  
<tr>
  <td>${product.productId}</td>
  <td>${product.productName}</td>
  <td>${product.categoryId}</td>
  <td>${product.supplierId}</td>
  <td>${product.stock}</td>
  <td>${product.price}</td>
  <td>
  <a href="<c:url value="/editProduct/${product.productId}"/>">Edit   </a>   /
  <a href="<c:url value="/deleteProduct/${product.productId}"/>">    Delete</a>
  </td>
</tr>
</c:forEach>
</table>
</div>

</body>
</html>
<%@ include file="Header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
<form:form modelAttribute="supplier"  action="InsertSupplier" method="post" >
<table align="center" class="table table-bordered" style="width:50%">

<tr>
  <td colspan=2 bgcolor="green"><center><strong>Enter Supplier Details<strong></center></td>
</tr>

<tr>
  <td>Supplier Name</td>
  <td><form:input path="supplierName"/></td>
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
  <td>Category Name</td>
  <td><form:input path="categoryName"/></td>
</tr>

<tr>
  <td>ProductId</td>
  <td><form:input path="productId"/></td>
</tr>

<tr>
  <td>Product Name</td>
  <td><form:input path="productName"/></td>
</tr>

<tr>
  <td>Product Price</td>
  <td><form:input path="price"/></td>
</tr>

<tr>
  <td>Supplier Stock</td>
  <td><form:input path="supplierStock"/></td>
</tr>

<tr bgcolor="yellow">
  <td colspan=2><center><strong><input type="submit" value="Insert New Supplier" />    <input type="reset" value="Clear All" /></strong></center></td><br>
</tr>

</table>
</form:form>


<br><br><br>
<table align="center" class="table table-bordered">

<tr>
<td colspan=9 bgcolor="pink"><h3><b><center>Total Suppliers List<center></b></h3></td>
</tr>

<tr>
    <td><b>Supplier ID</b></td>
    <td><b>Supplier Name</b></td>
    <td><b>Category Id</b></td>
    <td><b>Category Name</b></td>
    <td><b>Product ID</b></td>
    <td><b>Product Name</b></td>
    <td><b>Product Price</b></td>
    <td><b>Supplier Stock</b></td>
    <td><b>Operations</b></td>
</tr>


<c:forEach items="${listSuppliers}" var="supplier">  
<tr>
  <td>${supplier.supplierId}</td>
  <td>${supplier.supplierName}</td>
  <td>${supplier.categoryId}</td>
  <td>${supplier.categoryName}</td>
  <td>${supplier.productId}</td>
  <td>${supplier.productName}</td>
  <td>${supplier.price}</td>
  <td>${supplier.supplierStock}</td>
  <td>
  <a href="<c:url value="/editSupplier/${supplier.supplierId}"/>">Edit  </a>  /
  <a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">    Delete</a>
  </td>
</tr>
</c:forEach>
</table>


</div>
</body>
</html>




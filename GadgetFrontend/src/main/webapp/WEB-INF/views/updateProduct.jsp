<%@ include file="Header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
<form:form action="http://localhost:8086/GadgetFrontend/updateProduct"  modelAttribute="editableProduct"  method="post" >
<table align="center" class="table table-bordered" style="width:50%">

<tr>
  <td colspan=2 bgcolor="green"><center><strong>Edit Product Details<strong></center></td>
</tr>

<tr>
<td colspan=2><h5 align="center"><font color="red">${Error}</font></h5>
</td>
</tr>

<tr>
  <td>Product ID</td>
  <td><form:input path="productId" readonly="true"/></td>
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

<tr bgcolor="yellow">
  <td colspan=2><center><strong><input type="submit" value="Confirm Update" />
</tr>

</table>
</form:form>

</div>
</body>
</html>
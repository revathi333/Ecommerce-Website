<%@ include file="Header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div>
<form:form action="http://localhost:8086/GadgetFrontend/updateSupplier"  modelAttribute="ediatblesupplier"  method="post" >
<table align="center" class="table table-bordered" style="width:50%">

<tr>
  <td colspan=2 bgcolor="green"><center><strong>Edit Supplier Details<strong></center></td>
</tr>

<tr>
<td>Supplier ID</td>
  <td><form:input path="supplierId" readonly="true"/></td>
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
<td>Product ID</td>
<td><form:input path="productId" /></td>
</tr>


<tr>
<td>Product Name</td>
<td><form:input path="productName" /></td>
</tr>


<tr>
<td>Supplier Stock</td>
<td><form:input path="supplierStock" /></td>
</tr>


<tr>
<td>Price</td>
<td><form:input path="price" /></td>
</tr>

<tr bgcolor="yellow">
  <td colspan=2><center><strong><input type="submit" value="Confirm Update" />
</tr>

</table>
</form:form>
</div>


</body>
</html>
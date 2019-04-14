
    
<%@ include file="Header.jsp" %>    

<div class="container">
<br>

<form action="InsertCategory" method="post" >
<table cellspacing="3" style="width:50" align="center" class="table table-bordered">

<tr>
<td colspan=2 bgcolor="green"><center><strong>Enter Category Details</strong></center></td>
</tr>

    <tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName"/></td>
	</tr>
	
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc" id="catDesc"/></td>
	</tr>
	
	<tr bgcolor="yellow">
      <td colspan=2><center><strong><input type="submit" value="Insert New Category" />    <input type="reset" value="Reset" /></strong></center></td><br>
  </tr>
  
</table>

</form>
<br><br><br><br>
<table align="center" cellspacing="2" border="1" class="table table-bordered">
	<tr bgcolor="orange">
<td colspan=4 bgcolor="pink"><h3><b><center>Total Categories List<center></b></h3></td>
	</tr>
	<tr bgcolor="cyan">
		<td><b>Category ID</b></td>
		<td><b>Category Name</b></td>
		<td><b>Category Desc</b></td>
		<td><b>Operations</b></td>
	</tr>
	<c:forEach items="${categories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit   </a>/
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">   Delete</a>
		</td>
	</tr>	
	</c:forEach>
</table>

<form>

</form>

</div>


</body>
</html>
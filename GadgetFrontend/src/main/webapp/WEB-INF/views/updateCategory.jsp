    
<%@ include file="Header.jsp" %>    

<div class="container">

<br><br><br>
<form action="<c:url value="/UpdateCategory" />" method="post">
<table cellspacing="3" align="center" class="table table-bordered" style="width:50%">
	<tr bgcolor="orange"><td colspan="2"><center><strong>Edit Category Details<strong></center></td></tr>
	
	<tr>
		<td>Category ID</td>
		<td><input type="text" name="catId" id="catId" value="${editablecategory.categoryId}" readonly/></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName" value="${editablecategory.categoryName}"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc" id="catDesc" value="${editablecategory.categoryDesc}"/></td>
	</tr>
	<tr bgcolor="green">
		<td colspan=2><center><strong><input type="submit" value="Confirm Update" /></strong></center>
		</td>
	</tr>
</table>
</form>

</div>


</body>
</html>
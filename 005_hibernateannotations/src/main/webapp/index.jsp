<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hibernate Annotations</title>
</head>
<body>
	<h3>Product Details</h3>
	<form action="InsertServlet" method="post">
		<table>
			<tr>
				<td>Product ID*</td>
				<td><input type="text" name="T1" /></td>
			</tr>
			<tr>
				<td>Product Name*</td>
				<td><input type="text" name="T2" /></td>
			</tr>
			<tr>
				<td>Product Price*</td>
				<td><input type="text" name="T3" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Operation</title>
</head>
<body>
	<h3>Delete Operation</h3>
	<form action="DeleteServlet" method="post">
		<table>
			<tr>
				<td>Book ID*</td>
				<td><input type="text" name="T1" /></td>
				<td></td>
				<td><input type="submit" value="Delete" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
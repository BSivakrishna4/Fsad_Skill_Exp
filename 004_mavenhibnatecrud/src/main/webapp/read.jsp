<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Operation</title>
</head>
<body>
	<h3>Read Operation</h3>
	<%
	List<Book> bookList = (List<Book>) request.getAttribute("booklist");
	%>
	<table border="1">
		<tr>
			<th>Book ID</th>
			<th>Book Title</th>
			<th>Book Price</th>
		</tr>
		<%for (Book B : bookList) {%>
		<tr>
			<td><%=B.getBookid()%></td>
			<td><%=B.getTitle()%></td>
			<td><%=B.getPrice()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
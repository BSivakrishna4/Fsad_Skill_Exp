<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="model.Students" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HQL Demo</title>
</head>
	<body>
	   <h3>FROM Clause</h3>
	   <%List<Students> slist = (List<Students>)request.getAttribute("slist");%>
	   <table border='1'>
	       <tr>
	           <th>Student ID</th>
	           <th>Student Name</th>
	           <th>CGPA</th>
	       </tr>
	       <%for(Students S:slist){ %>
	          <tr> 
	             <td><%=S.getSid() %></td>
	             <td><%=S.getName() %></td>
	             <td><%=S.getCgpa() %></td>
	          </tr>
	       <%}%>
	   </table>
	   <%List<Students> slist1 = (List<Students>)request.getAttribute("slist1");%>
	   <h3>SELECT Clause</h3>
	   <table border="1">
	       <tr>
	         <th>Student ID</th>
	         <th>CGPA</th>
	       </tr>
	         <%for(Students S:slist1) { %>
	         <tr>
	           <td><%=S.getSid() %></td>
	            <td><%=S.getCgpa() %></td>
	         </tr>
	         <%}%>
	   </table>
	   <%List<Students> slist2 = (List<Students>)request.getAttribute("slist2");%>
	   <h3>WHERE Clause</h3>
	   <table border="1">
	       <tr>
	         <th>Student ID</th>
	         <th>CGPA</th>
	       </tr>
	         <%for(Students S:slist2) { %>
	         <tr>
	           <td><%=S.getSid() %></td>
	            <td><%=S.getCgpa() %></td>
	         </tr>
	         <%}%>
	   </table>
	   <%List<Students> slist3 = (List<Students>)request.getAttribute("slist3");%>
	   <h3>Named Parameters</h3>
	   <table border="1">
	       <tr>
	         <th>Student ID</th>
	         <th>CGPA</th>
	       </tr>
	         <%for(Students S:slist3) { %>
	         <tr>
	           <td><%=S.getSid() %></td>
	            <td><%=S.getCgpa() %></td>
	         </tr>
	         <%}%>
	   </table>
	   
	   <%String count=(String) request.getAttribute("count"); %>
	   <h3>No of students: <%=count%></h3>
	   
	   <%String sum=(String) request.getAttribute("sum"); %>
	   <h3>Sum of CGPA: <%=sum%></h3>
	   
	   <%String average=(String) request.getAttribute("average"); %>
	   <h3>Average of CGPA: <%=average%></h3>
	   
	   <%String min=(String) request.getAttribute("min"); %>
	   <h3>Minimum CGPA: <%=min%></h3>
	   
	   <%String max=(String) request.getAttribute("max"); %>
	   <h3>Maximum CGPA: <%=max%></h3>
	</body>
</html>
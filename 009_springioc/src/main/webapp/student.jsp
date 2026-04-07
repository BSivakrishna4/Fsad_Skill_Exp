<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Info</title>
</head>
<body>
    <table border="1">
       <tr>
          <td>Student Roll No</td>
          <td>${rollno}</td>
       </tr>
       <tr>
          <td>Name</td>
          <td>${name}</td>
       </tr>
       <tr>
          <td>Department</td>
          <td>${department}</td>
       </tr>
       <tr>
         <td>Cgpa</td>
         <td>${cgpa}</td>
       </tr>
    </table>
</body>
</html>
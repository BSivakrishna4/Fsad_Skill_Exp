<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
    <h3>Employee Details</h3>
    <form action="InsertEmployee" method="post">
    <table>
    <tr>
    <td>Emp ID*</td>
    <td><input type="text" name="T1" /></td>
    </tr>
    <tr>
    <td>Name*</td>
    <td><input type="text" name="T2" /></td>
    </tr>
    <tr>
    <td>Salary*</td>
    <td><input type="text" name="T3" /></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Save" ></td>
     </tr>
    </table>
    </form>
</body>
</html>
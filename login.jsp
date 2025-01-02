<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body align ="center">
<h1>user login</h1>
<form action ="LoginServlet" method = "post">
<div>
  <label>User Name :</label>
  <input type="text" name="username">
  </div>
  <div>
  <label>password :</label>
  <input type="password" name="password">
  </div>
  <div>
  <input type="submit">
  <input type="reset">
  </div><br>
  <div>
  <a href = "register.jsp">Register Here</a>
  </div>
  
</form>
</body>
</html>
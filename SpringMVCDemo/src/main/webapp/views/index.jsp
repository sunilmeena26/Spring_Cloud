<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     Welcome To Capgemini
 <!--     <form action="/add">
     Enter 1st Number: <input type="text" name ="num1"><br>
     Enter 1st Number: <input type="text" name ="num2"><br>
     <input type="submit">
     </form>    -->
     
      <form action="addAlien" method="post">
     Enter Your Id: <input type="text" name ="aid"><br>
     Enter Your Name: <input type="text" name ="aname"><br>
     <input type="submit">
     </form>
     <hr>
      <form action="getAlien" method="get">
     Enter Your Id: <input type="text" name ="aid"><br>
     <input type="submit">
     </form>
     
     <hr>
      <form action="getAlienByName" method="get">
     Enter Your Name: <input type="text" name ="aname"><br>
     <input type="submit">
     </form>
</body>
</html>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
  background-image: url('books4.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
h1 {
  color: Blue;
  font-family: verdana;
  font-size: 300%;
  border:2px red;
  
}
h2{
	color : Fuchsia;
}
</style> 
<link rel="stylesheet" href="Styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
			<h1>Shopping Cart For Book Store</h1>
			<h2><i>Selected Book details are Displayed</i></h2>
			
			<form action="./Customer" method="post">
			<%
			try{
				ResultSet rs = (ResultSet)session.getAttribute("rs1");
				
			    while(rs.next())
				{
			%>
				<b>Book Name : </b><%=rs.getString("Books_Name")%> <br><br>
				<b>Author : </b><%=rs.getString("Author") %><br><br>
				<b>Price : </b><%=rs.getInt("price") %><br><br>
				<b>Quantity : </b><input type="text" name="quantity"><br><br>
				<% 
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				%>
				<input type="submit" value="Purchase">
			</form>
			
			<form action="index.jsp">
				
				<input type="submit" value="Cancel">
			</form>
	</center>

</body>
</html>
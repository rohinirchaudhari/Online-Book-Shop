<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
  background-image: url('books2.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
h1 {
  color: White;
  font-family: verdana;
  font-size: 300%;
  border:2px red;
}
h2{
	color : Gold;
}
</style> 

<link rel="stylesheet" href="Styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
 <!-- <img src="imagess.jpg" alt="Books" style="width:100%;height:100%;"> --> 
		<center>
			<h1>Shopping Cart For Book Store</h1>
			<h2><i>Welcome to Book Store</i></h2>
			<table id="t01">
				<thead>
					<th>Books_ID</th>
					<th>Books_Name</th>
					<th>Author</th>
					<th>price</th>
				</thead>
				
				<tbody>
				<%
				try{
					
					ResultSet rs=(ResultSet)session.getAttribute("rs");
					while(rs.next())
						{
							
				%>
					<tr>
						<td><%=rs.getString("Books_ID") %></td>
						<!-- from here get the id of selected book in BookId variable -->
						<td><a href="Book.jsp?BookId=<%=rs.getString("Books_ID") %>"><%=rs.getString("Books_Name") %></a></td>
						<td><%=rs.getString("Author") %></td>
						<td><%=rs.getString("price") %></td>
					</tr>
					
				</tbody>
				<%
						}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				%>
				
			</table>
		</center>
		
</body>
</html>
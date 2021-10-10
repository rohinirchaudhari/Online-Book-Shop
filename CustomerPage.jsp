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
	<form action="./CustomerServlet" method = "post">
	<b>Customer Name : </b> <input type="text" name="name"><br><br>
	<b>Address : </b> <input type="address" name="address"><br><br>
	<b>Phone No : </b> <input type="text" name="phno"><br><br>
	<b>Order Date : </b><input type="date" name="date">
	
	
	<h2><i>Your Order Details : </i></h2>
	
	<table id="t02">
				<thead>
					
					<th>Book Name</th>
					<th>Author</th>
					<th>price</th>
					<th>Quantity</th>
					<th>Total Price</th>
				</thead>
				
				<tbody>   
				<%
				try{
					
					ResultSet rs=(ResultSet)session.getAttribute("rs2");
					String qty=(String)session.getAttribute("qty");
					int quantity=Integer.parseInt(qty);
					
					while(rs.next())
						
						{		
						int price = rs.getInt("price");
				%>
				
				 	<tr>
				 	
				 		<td><%=rs.getString("Books_Name") %></td>
						<td><%=rs.getString("Author") %></td>
						<td><%=rs.getInt("price") %></td>
						<td><%=quantity %></td>
						<td><%=price*quantity %></td>
						
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
			 
			  <br>
			  	<input type="submit" value = "Confirm">
			  	
			  	</form>
			 
			   <form action="index.jsp">
			   
			  	<input type="submit" value = "Cancel">
			  	
			  </form>
			
	</center>
</body>
</html>
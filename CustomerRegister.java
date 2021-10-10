

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerServlet")
public class CustomerRegister extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("name");
		String a=request.getParameter("address");
		String p=request.getParameter("phno");
		String d=request.getParameter("date");
		
		Date dtd=Date.valueOf(d);                 //convert string date into date type.
		
		HttpSession session=request.getSession();
		String qty=(String)session.getAttribute("qty");
		int quantity=Integer.parseInt(qty);
		
		String Id=(String) session.getAttribute("BkId");
		
		System.out.println(n);
		System.out.println(a);
		System.out.println(p);
		System.out.println(dtd);
		System.out.println(Id);
		System.out.println(quantity);
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookshop", "root", "Pankaj@17");
			System.out.println("Connection success");
			
			PreparedStatement pstm=con.prepareStatement("insert into Order_Details(Cust_Name,Phone_No,Address,Quantity, Book_Id,Order_Date) values(?,?,?,?,?,?)");
			pstm.setString(1,n);
			pstm.setString(2, a);
			pstm.setString(3, p);
			pstm.setInt(4, quantity);
			pstm.setString(5,Id);
			pstm.setDate(6, dtd);
			
			int i=pstm.executeUpdate();
			PrintWriter pw = response.getWriter();
			if(i!=0)
			{
				//pw.write("Record Inserted");  // Msg print on browser
				response.sendRedirect("Thanks.jsp");  
			}
			else {
				pw.write("Error");
				 //response.sendRedirect("Error.jsp");
			}
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

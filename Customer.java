

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Customer")
public class Customer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String qty=request.getParameter("quantity");
		
		HttpSession session=request.getSession();
		String Id=(String) session.getAttribute("BkId");
		session.setAttribute("qty", qty);
		
		System.out.println("Id in customer servlet= "+Id);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookshop", "root", "Pankaj@17");
			System.out.println("Connection success");
			
			PreparedStatement pstm=con.prepareStatement("select * from Books where Books_ID=?");
			pstm.setString(1, Id);
			
			ResultSet rs2=pstm.executeQuery();
		//	This Prints on console
			/*while(rs2.next())
			{
				System.out.print(rs2.getString("Books_Name")+"|");
				System.out.print(rs2.getString("Author")+"|");
				System.out.println(rs2.getInt("price")+"|");
			}*/
			session.setAttribute("rs2", rs2);
			response.sendRedirect("CustomerPage.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

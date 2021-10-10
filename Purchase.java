

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


@WebServlet("/PurchaseServlet")
public class Purchase extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String Id=(String) session.getAttribute("BkId");
		
		System.out.println("Id in purchase servlet= "+Id);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookshop", "root", "Pankaj@17");
			System.out.println("Connection success");
			
			PreparedStatement pstm=con.prepareStatement("select * from Books where Books_ID=?");
			pstm.setString(1, Id);
			
			ResultSet rs1=pstm.executeQuery();
		/*	This Prints on console
		 * while(rs1.next())
			{
				System.out.print(rs1.getString("Books_Name")+"|");
				System.out.print(rs1.getString("Author")+"|");
				System.out.println(rs1.getInt("price")+"|");
			}*/
			session.setAttribute("rs1", rs1);
			response.sendRedirect("PurchasePage.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

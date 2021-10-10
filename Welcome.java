

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookshop", "root", "Pankaj@17");
			System.out.println("Connection success");
			
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from Books");
			
			//we need rs on WelcomePage.jsp,thats why we create session object and fetch the rs to WelcomePage.jsp.
			HttpSession session=request.getSession();
			session.setAttribute("rs", rs);
		 /*	while(rs.next())
			{
				System.out.print(rs.getString("Books_ID")+"|");
				System.out.print(rs.getString("Books_Name")+"|");
				System.out.print(rs.getString("Author")+"|");
				System.out.println(rs.getInt("price")+"|");
				//System.out.println();
				
			}*/
			
			response.sendRedirect("WelcomePage.jsp");
			//con.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

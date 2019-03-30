
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register_User extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","lit");  
			  
			PreparedStatement ps=con.prepareStatement(  
			"insert into userid_password values(?,?)");  
			  
			ps.setString(1,username);  
			ps.setString(2,password);  
		
			          
			int i=ps.executeUpdate();  
			if(i>0)  
			out.print("You are successfully registered...");  
			      
			          
			}
		   catch (Exception e2)
		      {
			   System.out.println(e2);
			   }  
			          
			out.close();  
	}

}

package jdbc;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VendorServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Vendor List</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Location</th></tr>");

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/company", "root", "root");

            Statement stmt =con.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM vendors");

            while (rs.next()) {
                int id =rs.getInt("id");
                String name =rs.getString("name");
                String location= rs.getString("location");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + location + "</td>");
                out.println("</tr>");
            }

            con.close();
        } catch (Exception e){
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}

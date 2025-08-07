package formHandling;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletRegistration extends HttpServlet{

	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException{

		        String name =request.getParameter("Name");
		        String age =request.getParameter("Age");
		        String email =request.getParameter("Email");

		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();

		        out.println("<html><body>");
		        out.println("<h2>Student Details Received Successfully:</h2>");
		        out.println("Name: " + name + "<br>");
		        out.println("Age: " + age + "<br>");
		        out.println("Email: " + email + "<br>");
		        out.println("</body></html>");
		    }
		}

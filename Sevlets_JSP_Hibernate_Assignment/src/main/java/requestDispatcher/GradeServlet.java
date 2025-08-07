package requestDispatcher;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GradeServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String markStr =(String) request.getAttribute("marks");
        String nameStr=(String) request.getAttribute("name");

        int marks = Integer.parseInt(markStr);

        String grade;
        if (marks >=90) grade= "A";
        else if (marks >= 75) grade ="B";
        else if (marks >= 50) grade= "C";
        else grade = "Fail";

        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Name: " +nameStr +"</h2>");
        out.println("<h2>Grade: " + grade + "</h2>");
        out.println("</body></html>");
    }
}
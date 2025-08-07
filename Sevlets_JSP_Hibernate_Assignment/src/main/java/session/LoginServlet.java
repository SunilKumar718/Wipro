package session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNo = request.getParameter("account");
        String pwd = request.getParameter("password");

        if ("12345".equals(accNo) &&"pass".equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("name","Sunil");
            session.setAttribute("balance", "50,000");

            response.sendRedirect("balance");
        } else {
            PrintWriter out =response.getWriter();
            out.println("<html><body>");
            out.println("<h3>Invalid credentials!</h3>");
            out.println("<a href='login.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}

package requestDispatcher;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String marks = request.getParameter("marks");
        String name = request.getParameter("name");

        request.setAttribute("marks", marks);
        request.setAttribute("name", name);

        RequestDispatcher rd = request.getRequestDispatcher("grade");
        rd.forward(request, response);
    }
}
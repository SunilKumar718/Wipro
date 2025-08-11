package transaction;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class TransactionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String amount = request.getParameter("amount");

        response.setContentType("text/html");
        response.getWriter().println("<h3 style='color:green;'>Transaction of Rs." + amount + " processed successfully.</h3>");
    }
}

package cookies;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String product = null, quantity = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("product")) product = c.getValue();
                if (c.getName().equals("quantity")) quantity = c.getValue();
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        if (product != null && quantity != null) {
            out.println("<h2>Cart Details:</h2>");
            out.println("<p>Product: " + product + "</p>");
            out.println("<p>Quantity: " + quantity + "</p>");
        } else {
            out.println("<p>No items found in cart.</p>");
        }
        out.println("</body></html>");
    }
}

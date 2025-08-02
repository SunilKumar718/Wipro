package hiddenForms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String product = request.getParameter("product");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        int pricePerItem = 100;
        int total = quantity * pricePerItem;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Confirm Your Order</h2>");
        out.println("<form action='order' method='post'>");
        out.println("Product: " + product + "<br>");
        out.println("Quantity: " + quantity + "<br>");
        out.println("Total Price: " + total + "<br><br>");

        out.println("<input type='hidden' name='product' value='" + product + "'>");
        out.println("<input type='hidden' name='quantity' value='" + quantity + "'>");
        out.println("<input type='hidden' name='total' value='" + total + "'>");

        out.println("<input type='submit' value='Confirm Purchase'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

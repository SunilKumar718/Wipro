package hiddenForms;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String product = request.getParameter("product");
        String quantity = request.getParameter("quantity");
        String total = request.getParameter("total");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Receipt</h2>");
        out.println("Product: " + product + "<br>");
        out.println("Quantity: " + quantity + "<br>");
        out.println("Total Amount: " + total + "<br>");
        out.println("<h3>Thank you for your purchase!</h3>");
        out.println("</body></html>");
    }
}

package cookies;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        String product = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        Cookie p =new Cookie("product", product);
        Cookie q =new Cookie("quantity", quantity);

        p.setMaxAge(3600);
        q.setMaxAge(3600);

        response.addCookie(p);
        response.addCookie(q);

        response.sendRedirect("viewcart");
    }
}

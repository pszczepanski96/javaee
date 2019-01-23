package pl.pszczepanski.javaee.zad03.web;

import pl.pszczepanski.javaee.zad03.domain.Shoe;
import pl.pszczepanski.javaee.zad03.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/confirm")

public class Confirm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        StorageService ss = null;

        if (session.getAttribute("session_cart") == null) {
            ss = new StorageService();
        } else {
            ss = (StorageService) session.getAttribute("session_cart");
        }
        out.append("<html><body><h2>Thank you for shopping</h2></body></html>");

        session.removeAttribute("session_cart");

        
        out.println("<html><body><ul>"+
                "<li><a href='zad03'>Back to main site</a></li>"+
                "</ul></body></html>");

        out.close();

    }
}
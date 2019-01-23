package pl.pszczepanski.javaee.zad03.web;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")

public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body><h1>Welcome in shop!</h1></body></html>");
        out.println("<html><body><h2>What do you want to do?</h2></body></html>");
        out.println("<html><body><ul>"+
                "<li><a href='add'>Add Shoe</a></li>"+
                "<li><a href='buy'>Buy Shoe</a></li>"+
                "<li><a href='basket'>Check your basket</a></li>"+
                "<li><a href='store'>Check store</a></li>"+
                "</ul></body></html>");

        out.close();

    }
}

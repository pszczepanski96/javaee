package pl.pszczepanski.kol1poprawa.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Welcome in my shop</h1> <br>" +
                "Menu: <br>" +
                "<ul>" +
                "<li><a href='add-bookmark'>Add bookmark</a></li>" +
                "<li><a href='all-bookmarks'>List of bookmarks</a></li>" +
                "<li><a href='cart'>Cart</a></li>" +
                "</ul>" +
                "</body></html>");
        out.close();
    }

}

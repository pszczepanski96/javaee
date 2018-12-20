package pl.pszczepanski.kol1poprawa.web;

import pl.pszczepanski.kol1poprawa.domain.Bookmark;
import pl.pszczepanski.kol1poprawa.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/all-bookmarks")
public class AllBookMarksServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        List<Bookmark> allBookmarks = ss.getAllBookmarks();

        out.append("<html><body><h2>All bookmarks:</h2>");

        for (Bookmark bookmark: allBookmarks) {
            if(bookmark.getQuantity() > 0) {
                out.append("<form action='add-to-cart'>");
                out.append("<input type='hidden' name='id' value='" + bookmark.getId() + "'/>");
                out.append("<p>id: " + bookmark.getId() + "</p>");
                out.append("<p>name: " + bookmark.getName() + "</p>");
                out.append("<p>date: " + bookmark.getDate() + "</p>");
                out.append("<p>color: " + bookmark.getColor() + "</p>");
                out.append("<p>extras: " + bookmark.getExtras() + "</p>");
                out.append("<p>price: " + bookmark.getPrice() + "</p>");
                out.append("<p>quantity: " + bookmark.getQuantity() + "</p><br>");
                out.append("<input type='submit' value=' Add to Cart' />");
                out.append("</form>");
            }
        }

        out.append("</body></html>");
        out.close();
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }
}

package pl.pszczepanski.kol1poprawa.web;

import pl.pszczepanski.kol1poprawa.domain.Bookmark;
import pl.pszczepanski.kol1poprawa.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        StorageService ss = null;

        if (session.getAttribute("session_cart") == null) {
            ss = new StorageService();
        } else {
            ss = (StorageService) session.getAttribute("session_cart");
        }

        List<Bookmark> bookmarksInCart = ss.getCart();

        out.append("<html><body><h2>All bookmarks in cart:</h2>");

        int total = 0;

        for (Bookmark bookmark: bookmarksInCart) {
            out.append("<p>id: " + bookmark.getId() + "</p>");
            out.append("<p>name: " + bookmark.getName() + "</p>");
            out.append("<p>date: " + bookmark.getDate() + "</p>");
            out.append("<p>color: " + bookmark.getColor() + "</p>");
            out.append("<p>extras: " + bookmark.getExtras() + "</p>");
            total += bookmark.getPrice();
        }


        out.append("Total: $" + total);
        out.append("<br><a href='all-bookmarks'>Go back to shop</a><br>");
        out.append("<a href='purchase'>Buy</a><br>");
        out.append("</body></html>");
        out.close();

    }
}

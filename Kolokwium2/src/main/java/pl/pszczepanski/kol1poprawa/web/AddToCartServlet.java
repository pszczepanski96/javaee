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

@WebServlet(urlPatterns = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
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

        int id = Integer.parseInt(request.getParameter("id"));

        ss.addToCart(getBookmark(id));

        session.setAttribute("session_cart", ss);

        List<Bookmark> bookmarksInCart = ss.getCart();

        out.append("<html><body><h2>All Bookmarks in cart:</h2>");

        for (Bookmark bookmark: bookmarksInCart) {
            out.append("<p>id: " + bookmark.getId() + "</p>");
            out.append("<p>name: " + bookmark.getName() + "</p>");
            out.append("<p>date: " + bookmark.getDate() + "</p>");
            out.append("<p>color: " + bookmark.getColor() + "</p>");
            out.append("<p>extras: " + bookmark.getExtras() + "</p>");
        }

        out.append("<a href='all-bookmarks'>Go back to shop</a><br>");
        out.append("<a href='cart'>Go to checkout</a>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {


        getServletContext().setAttribute("storage_service", new StorageService());
    }

    private Bookmark getBookmark(int id){
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Bookmark> allBookmarks = appStorage.getAllBookmarks();
        Bookmark bookmarkToCart = null;

        for(Bookmark bookmark: allBookmarks) {
            if(bookmark.getId() == id) {
                bookmarkToCart = bookmark;
            }
        }

        return bookmarkToCart;
    }
}

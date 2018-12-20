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

@WebServlet(urlPatterns = "/purchase")
public class BuyServlet extends HttpServlet {
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

        out.append("<html><body><h2>Thank you for purchase</h2>");

        for (Bookmark bookmark: bookmarksInCart) {
            removeBookmarkQuantity(bookmark);
        }

        session.removeAttribute("session_cart");

        out.append("<a href='zad03'>Go back to menu</a><br>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }

    private void removeBookmarkQuantity(Bookmark bought){
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Bookmark> allBookmarks = appStorage.getAllBookmarks();

        for(Bookmark bookmark: allBookmarks) {
            if(bought == bookmark) {
                int quantity = bookmark.getQuantity();
                quantity--;
                bookmark.setQuantity(quantity);
            }
        }
    }
}

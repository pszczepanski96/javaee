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

@WebServlet(urlPatterns = "/basket-add")
public class AddToBasket extends HttpServlet {

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

        ss.addToBasket(getShoe(id));

        Shoe shoe1 = getShoe(id);
        shoe1.setQuantity(shoe1.getQuantity()-1);

        session.setAttribute("session_cart", ss);

        List<Shoe> shoesInBasket = ss.getBasket();

        out.append("<html><body><h2>All Shoes in your basket:</h2>");

        for (Shoe shoe : shoesInBasket) {
            out.append("<p>ID: " + shoe.getId() + "</p>");
            out.append("<p>Producer: " + shoe.getProducer() + "</p>");
            //out.append("<p>Production date: " + shoe.getProductionDate() + "</p>");
            //out.append("<p>Quantity: " + shoe.getQuantity() + "</p>");
            out.append("<p>Price: " + shoe.getPrice() + "</p>");
            out.append("<p>Waterproof: " + shoe.getWaterproof() + "</p><br>");
        }

        out.append("<a href='buy'>Buy another shoe</a><br>");
        out.append("<a href='zad03'>Go to main site</a>");
        out.append("</body></html>");
        out.close();


    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }

    private Shoe getShoe(int id) {
        StorageService appStorage = (StorageService) getServletContext().getAttribute("storage_service");
        List<Shoe> allShoes = appStorage.getAllShoes();
        Shoe find = null;

        for (Shoe shoe : allShoes) {
            if (shoe.getId() == id) {
                find = shoe;
            }
        }

        return find;
    }
}
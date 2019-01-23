package pl.pszczepanski.javaee.zad04.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.pszczepanski.javaee.zad04.domain.Shoe;
import pl.pszczepanski.javaee.zad04.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



@WebServlet(urlPatterns = "/addingProces")

public class AddingProces extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        String producer = request.getParameter("producer");

        Date productionDate = null;
        try {
            productionDate = formatter.parse(request.getParameter("productionDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        boolean waterproof = Boolean.parseBoolean(request.getParameter("waterproof"));

        int id = ss.getId();

        Shoe newShoe = new Shoe(id, producer, productionDate, quantity, price, waterproof);

        ss.add(newShoe);

        List<Shoe> allShoes = ss.getAllShoes();

        out.append("<html><body><h2>All Shoes:</h2>");

        for (Shoe shoe : allShoes) {
            out.append("<p>ID: " + shoe.getId() + "</p>");
            out.append("<p>Producer: " + shoe.getProducer() + "</p>");
            out.append("<p>Date od production: " + shoe.getProductionDate() + "</p>");
            out.append("<p>Price: " + shoe.getPrice() + "</p>");
            out.append("<p>Quantity: " + shoe.getQuantity() + "</p>");
            out.append("<p>Waterproof: " + shoe.getWaterproof() + "</p><br>");
        }
        out.append("<a href='add'>Add another shoe</a><br>");
        out.append("<a href='store'>Show all shoes</a>");
        out.append("</body></html>");
        out.close();


    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }
}
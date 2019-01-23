package pl.pszczepanski.javaee.zad03.web;

import pl.pszczepanski.javaee.zad03.domain.Shoe;
import pl.pszczepanski.javaee.zad03.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/buy")

public class Buy extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        List<Shoe> allShoes = ss.getAllShoes();

        out.append("<html><body><h2>Select Shoes:</h2>");
        for (Shoe shoe: allShoes) {
                if(shoe.getQuantity()>0){
                out.append("<form action='basket-add'>");
                out.append("<input type='hidden' name='id' value='" + shoe.getId() + "'/>");
                out.append("<p>ID: " +shoe.getId() + "</p>");
                out.append("<p>Producer: " + shoe.getProducer() + "</p>");
                out.append("<p>Production date: " + shoe.getProductionDate()+ "</p>");
                out.append("<p>Price: " + shoe.getPrice() + "</p>");
                out.append("<p>Quantity: " + shoe.getQuantity() + "</p>");
                out.append("<p>Waterproof: " + shoe.getWaterproof() + "</p><br>");
                out.append("<input type='submit' value='Add to Cart' />");
                out.append("</form>");}
        }


        out.append("<a href='zad03'>Go to main site</a>");
        out.append("</body></html>");
        out.close();



    }


}


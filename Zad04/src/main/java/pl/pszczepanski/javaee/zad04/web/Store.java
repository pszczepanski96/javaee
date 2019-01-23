package pl.pszczepanski.javaee.zad04.web;
import pl.pszczepanski.javaee.zad04.domain.Shoe;
import pl.pszczepanski.javaee.zad04.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/store")
public class Store extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StorageService ssRodo = (StorageService) getServletContext().getAttribute("rodo_service");

		if(!ssRodo.getRodoStatus()) {
			response.sendRedirect("rodo.jsp");
		}

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

		List<Shoe> allShoes = ss.getAllShoes();

		out.append("<html><body><h2>All Shoes:</h2>");

		for (Shoe shoe: allShoes) {
			out.append("<p>ID: " +shoe.getId() + "</p>");
			out.append("<p>Producer: " + shoe.getProducer() + "</p>");
			out.append("<p>Production date: " + shoe.getProductionDate() + "</p>");
			out.append("<p>Quantity: " + shoe.getQuantity() + "</p>");
			out.append("<p>Price: " + shoe.getPrice() + "</p>");
			out.append("<p>Waterproof: " + shoe.getWaterproof() + "</p><br>");
		}

		out.append("<a href='zad04'>Go to main site</a>");
		out.append("</body></html>");
		out.close();
	}

	@Override
	public void init() throws ServletException {

		// application context
		getServletContext().setAttribute("storage_service", new StorageService());
	}

}
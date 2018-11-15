package pl.pszczepanski.javaee.zad03.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add")
public class AddShoe extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add shoe</h2>" +
				"<form action='addingProces'>" +
				"Producer: <input type='text' name='producer' /> <br />" +
				"Date of production: <input type='text' name='productionDate' /> <br />" +
				"Price: <input type='text' name='price' /> <br />" +
				"Quantity: <input type='number' name='quantity' /> <br />" +
				"Waterproof: <select name='waterproof'>" +
				"<option value='true'>Yes</option>" +
				"<option value='false'>No</option>" +
				"</select></br>"+
				"<input type='submit' value=' ADDING' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}

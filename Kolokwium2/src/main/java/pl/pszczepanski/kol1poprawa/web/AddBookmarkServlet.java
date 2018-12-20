package pl.pszczepanski.kol1poprawa.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-bookmark")
public class AddBookmarkServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add bookmark:</h2>" +
				"<form action='store-bookmark'>" +
				"Name: <input type='text' name='name' /> <br />" +
				"Date production: <input type='text' name='date' /> <br />" +
				"Color: <br><input type=\"radio\" name=\"color\" value=\"red\">red<br>\n" +
				"    <input type=\"radio\" name=\"color\" value=\"blue\">blue<br>\n" +
				"    <input type=\"radio\" name=\"color\" value=\"white\">white<br>" +
				"Extras templates: <br><input type=\"checkbox\" name=\"extras\" value=\"planes\">planes<br>\n" +
				"    <input type=\"checkbox\" name=\"extras\" value=\"cars\">cars<br>\n" +
				"    <input type=\"checkbox\" name=\"extras\" value=\"cats\">cats<br><br>" +
				"Price: <input type='number' name='price' /> <br />" +
				"Quantity: <input type='number' name='quantity' /> <br />" +
				"<input type='submit' value=' Add ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}

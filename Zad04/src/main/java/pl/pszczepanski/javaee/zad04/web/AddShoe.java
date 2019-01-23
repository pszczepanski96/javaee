package pl.pszczepanski.javaee.zad04.web;

import pl.pszczepanski.javaee.zad04.service.StorageService;

import java.io.IOException;

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

		StorageService ssRodo = (StorageService) getServletContext().getAttribute("rodo_service");

		if(!ssRodo.getRodoStatus()) {
			response.sendRedirect("rodo.jsp");
		}

		response.sendRedirect("addShoe.jsp");
	}

}
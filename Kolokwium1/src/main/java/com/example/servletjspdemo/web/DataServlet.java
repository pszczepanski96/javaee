package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/newsellerdata")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String selectedTopics = "";
		for (String topic : request.getParameterValues("topic")) {
			selectedTopics += topic + ", ";
		}
		out.println("<html><body><h2>Your data</h2>" +
				"<p>First name: " + request.getParameter("firstName") + "<br />" +
				"<p>Newseller receiving time: "  + request.getParameter("dataStart") + " - "+ request.getParameter("dataStop")+ "<br />" +
				"<p>Frequency: " +request.getParameter("frequency")+ "<br />" +
				"<p>Your Topics: " + selectedTopics + "<br />" +
				"</body></html>");
		out.close();
	}

}

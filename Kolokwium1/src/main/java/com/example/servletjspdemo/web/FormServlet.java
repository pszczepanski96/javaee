package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/newseller")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Orrder newseller</h2>" +
				"<form action='data'>" +
				"First name: <input type='text' name='firstName' /> <br />" +
				"Date start: <input type='text' name='dataStart' /> <br />" +
				"Date stop: <input type='text' name='dataStart' /> <br />" +
				"How often? <br />"+
				"<input type='radio' name='frequency' value='everyday'> Every day <br />"+
				"<input type='radio' name='frequency' value='everyweek'> Once in a week <br />"+
				"<input type='radio' name='frequency' value='everymonth'> Once in a month <br />"+
				"Topics:<br />"+
				"<input type='checkbox' name='topic' value='football'>Football<br />" +
				"<input type='checkbox' name='topic' value='superstars'>Superstar<br />" +
				"<input type='checkbox' name='topic' value='drinks'>Drinks<br />" +
				"<input type='checkbox' name='topic' value='books'>Books<br />" +
				"<input type='submit' value=' ORDER ' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}

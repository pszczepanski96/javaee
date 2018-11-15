package com.example.servletjspdemo.web;

import com.example.servletjspdemo.service.StorageService;
import com.example.servletjspdemo.domain.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/allnewsletters")

public class AllPersons extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        List<Person> allPersons = ss.getAllPersons();

        out.append("<html><body><h2>All newsellers:</h2>");

        for(Person person: allPersons){
            out.append("<p>Firstname: " + person.getFirstName() + "</p>");
            out.append("<p>Start date: " + person.getDataStart() + "</p>");
            out.append("<p>Start date: " + person.getDataStop() + "</p>");
        }

        out.append("</body></html>");
        out.close();

        }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }

}




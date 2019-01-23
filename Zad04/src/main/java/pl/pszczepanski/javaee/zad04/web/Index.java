package pl.pszczepanski.javaee.zad04.web;


import pl.pszczepanski.javaee.zad04.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")

public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StorageService ssRodo = (StorageService) getServletContext().getAttribute("rodo_service");
        if(ssRodo.getRodoStatus()){
            response.sendRedirect("index.jsp");

        }
        else {
            response.sendRedirect("rodo.jsp");
        }
    }
    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("rodo_service", new StorageService());
    }
}
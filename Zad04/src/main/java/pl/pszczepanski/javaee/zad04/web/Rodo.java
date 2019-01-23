package pl.pszczepanski.javaee.zad04.web;

import pl.pszczepanski.javaee.zad04.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/rodoAccept")
public class Rodo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("rodo_service");

        StringBuffer url = request.getRequestURL();

        String rodo = request.getParameter("rodo");

        ss.setRodoStatus(rodo);

        if(ss.getRodoStatus())  {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("rodo.jsp");
        }
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("rodo_service", new StorageService());
    }
}
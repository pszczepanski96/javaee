package pl.pszczepanski.javaee.zad02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/menu")

public class Menu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        PrintWriter out =  response.getWriter();

        out.println("<html><body><h1>MENU</h1></body></html>");
        out.println("<html><body><ul><li><a href='/Zad02/date'>Date</a></li><li><a href='/Zad02/about'>About me</a></li></ul></body></html>");


    }
}
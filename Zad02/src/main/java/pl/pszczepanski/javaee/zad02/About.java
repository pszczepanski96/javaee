package pl.pszczepanski.javaee.zad02;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/about")

public class About extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        PrintWriter out =  response.getWriter();

        out.println("<html><body><h1>Patryk Szczepanski</h1><br>Nr indeksu: 246760</body></html>");


    }
}

package com.Servlet.FirstServletProject;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("In Service");
        
        res.setContentType("text/html");
        
        PrintWriter out = res.getWriter();
        out.println("<b><h2>Hello World..</b></h2>");
        
        //res.getWriter().println("Hello World....");
    }
}
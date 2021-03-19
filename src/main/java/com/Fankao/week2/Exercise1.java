package com.Fankao.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>" + "Name:Fan kao" + "</h1>");
        out.println("<h1>" + "ID:2019211001000821" + "</h1>");
        out.println("<h1>" + "Date and Time: Sun Feb 14 4:25  CST 2021" + "</h1>");
        out.println("</body></html>");
    }
}
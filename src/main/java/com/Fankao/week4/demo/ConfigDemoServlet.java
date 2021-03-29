package com.Fankao.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value="Fankao"),
                @WebInitParam(name="StudentID",value="2019211001000821")
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name= config.getInitParameter("name");
        String StudentID = config.getInitParameter("StudentID");
        response.getWriter().println("name:"+name);
        response.getWriter().println("StudentID:"+StudentID);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

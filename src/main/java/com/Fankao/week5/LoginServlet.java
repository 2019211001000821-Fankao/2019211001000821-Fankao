package com.Fankao.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/Login")

public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
    String driver=getServletConfig().getServletContext().getInitParameter("driver");//<param-name>driver</param-name>
    String url=getServletConfig().getServletContext().getInitParameter("url");
    String username=getServletConfig().getServletContext().getInitParameter("username");
    String password=getServletConfig().getServletContext().getInitParameter("password");

        try{
        Class.forName(driver);
        Connection con= DriverManager.getConnection(url,username,password);
        System.out.println("init()-->"+con);
    }catch (ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        try {
            String sql = "select * from userdb where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                out.println("Login Success!!!");
                out.println("Welcome" + username);
            } else
                out.println("Username or Password Error!!!");
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


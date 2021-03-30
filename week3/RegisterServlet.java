package com.Fankao.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(
        urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(name = "driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url",value="jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name = "username",value="sa"),
                @WebInitParam(name = "password",value="092524")
        },loadOnStartup = 1
)

public class RegisterServlet extends HttpServlet {
    Connection con = null;//class variable
    @Override
    public  void init() throws ServletException{

        ServletContext context = getServletConfig().getServletContext();
        String driver=context.getInitParameter("driver");//<param-name>driver</param-name>
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");


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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //request come here -<from method=post>
        //get parameter from request
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birthdate = request.getParameter("birthdate");
            PrintWriter writer = response.getWriter();


            try{
                String sql1="insert into usertable(username,password,email.gender,birthday) values(Fankao,0925,?,man,20000925);" ;
                PreparedStatement pstmt = con.prepareStatement(sql1);
                pstmt.setString(1,username);
                pstmt.setString(2,password);
                pstmt.setString(3,email);
                pstmt.setString(4,gender);
                pstmt.setDate(5, Date.valueOf(birthdate));
                int result =pstmt.executeUpdate();
                if(result==1)System.out.println("OK");
                else System.out.println("ERROR");

                String sql = "select * from usertable";
                ResultSet rs=con.createStatement().executeQuery(sql);
            //print - writer into response
            writer.println("<br>username"+username);
            writer.println("<br>password"+password);
            writer.println("<br>email"+email);
            writer.println("<br>gender"+gender);
            writer.println("<br>birthdate"+birthdate);
            writer.close();
    }catch (SQLException e){
                e.printStackTrace();
            }
    }
}

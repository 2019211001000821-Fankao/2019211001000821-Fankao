package com.Fankao.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//use @WebServlet - no web.xml code
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name = "driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url",value="jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name = "username",value="sa"),
                @WebInitParam(name = "password",value="092524")
        },loadOnStartup = 1
)
//end of @WebServlet

public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;//class variable
    @Override
    public  void init() throws ServletException{
        //only once
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost;databaseName=userdb";
        //String username="sa";
        //String password="092524";
        //code like this is bad way --because change is not easy
        //for example change password of db-chang in java code

        //get ServletConfig-->getInitParameters
        //ServletConfig config=getServletConfig();
        //String driver = config.getInitParameter("driver");//<param-name>driver</param-name>
        //String url = config.getInitParameter("url");//<param-name>url</param-name>
        //String username = config.getInitParameter("username");//<param-name>user</param-name>
        //String password = config.getInitParameter("password");//<param-name>password</param-name>

        //best way - use context param
        //get init parameter from context
        //get config --> get context

        ServletContext context = getServletConfig().getServletContext();
        String driver=context.getInitParameter("driver");//<param-name>driver</param-name>
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");


        try{
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);//ok-(java code)/ok-(use config-in web.xml)/ok-(use @WebServlet)
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //connection within doGet-many times--bad way
        System.out.println("i am in doGet()");
        //we need to use con within doget
        String sql = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                //get from rs - print -writer into response
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
        public void destroy() {
            super.destroy();
            try {
                con.close();//when tomcat stop
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }

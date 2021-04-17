package com.Fankao.week5;

import com.Fankao.dao.UserDao;
import com.Fankao.model.User;
import com.example.Fankao2019211001000821.HelloServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")

public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
    //String driver=getServletConfig().getServletContext().getInitParameter("driver");//<param-name>driver</param-name>
    //String url=getServletConfig().getServletContext().getInitParameter("url");
    //String username=getServletConfig().getServletContext().getInitParameter("username");
    //String password=getServletConfig().getServletContext().getInitParameter("password");

       // try{
       // Class.forName(driver);
       // Connection con= DriverManager.getConnection(url,username,password);
       // System.out.println("init()-->"+con);
    //   }catch (ClassNotFoundException | SQLException e){
     //   e.printStackTrace();
   // }
        super.init();
       con =(Connection)getServletContext().getAttribute("con");
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        //write mvc code
        //use model and dao
        UserDao userDao = new UserDao();
        try {
           User user = userDao.findByUsernamePassword(con,username,password);
           if(user!=null) {
               //valid
               //set user into request
               request.setAttribute("user",user);
               request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
           } else{
               //invalid
               request.setAttribute("message","Username or password Error !!!");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        /*String sql = "select * from usertable where username='"+username+"' and password='"+password+"'";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if (rs.next()) {
     //              out.println("Login Success!!!");
//                out.println("Welcome" + username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else{
                request.setAttribute("message","Username or password Error !!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
      //          out.println("Username or Password Error!!!");
            } catch(SQLException e){
                e.printStackTrace();
            }*/
        }
    }
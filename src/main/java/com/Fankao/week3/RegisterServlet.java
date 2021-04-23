package com.Fankao.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name="RegisterServlet", value ="/register")
public class RegisterServlet extends HttpServlet {
    Connection con = null;//class variable
    @Override
    public  void init() throws ServletException{

        /*tring url =getServletConfig().getServletContext().getInitParameter("url");
        String driver =getServletConfig().getServletContext().getInitParameter("driver");
        String username =getServletConfig().getServletContext().getInitParameter("username");
        String password =getServletConfig().getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

         */
     con=(Connection) getServletContext().getAttribute("con");
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


        try {
            Statement st=con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthdate)"+
                    " values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"');";
            System.out.println("sql"+sql);
            int n = st.executeUpdate(sql);
            System.out.println("n-->"+n);//==1 success

            //sql="select id,username,password,email,gender,birthdate from usertable";
            //ResultSet rs=st.executeQuery(sql);
            //  String sql = "select * from usertable";
            //             ResultSet rs=con.createStatement().executeQuery(sql);
            //print - writer into response
            // writer.println("<br>username"+username);
            // writer.println("<br>password"+password);
            // writer.println("<br>email"+email);
            // writer.println("<br>gender"+gender);
            // writer.println("<br>birthdate"+birthdate);
            // writer.close();
            response.sendRedirect("login");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
        public void destroy() {
        super.destroy();
        try {
            con.close();
         } catch (SQLException e) {
         e.printStackTrace();
        }
    }
}

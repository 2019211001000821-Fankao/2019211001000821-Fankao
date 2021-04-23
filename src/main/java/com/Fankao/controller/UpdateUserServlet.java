package com.Fankao.controller;

import com.Fankao.dao.UserDao;
import com.Fankao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con =null;
    @Override
    public void init() throws ServletException{
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code
        //TODO 1 : forward to WEB-INF/views/updateUser.jsp
        //TODO 2 :create one jsp page - updateUser
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code to update user info-can update username,password,email,gender,birthdate
        int id=Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthdate = Date.valueOf(request.getParameter("birthdate"));

        User user=new User(id,username,password,email,gender,birthdate);
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(con,user);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        HttpSession session =request.getSession();
        session.setAttribute("user",user);
        session.setMaxInactiveInterval(30);
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
    }
}

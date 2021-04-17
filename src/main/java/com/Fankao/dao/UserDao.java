package com.Fankao.dao;

import com.Fankao.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql ="insert into usertable values(?,?,?,?,?,?);";
        PreparedStatement ps =con.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6, (java.sql.Date)user.getBirthdate());
        int result = ps.executeUpdate();
        return result==1?true:false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql ="delete from usertable where id =?;";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,user.getId());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql ="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?;";
        PreparedStatement ps =con.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6, (java.sql.Date)user.getBirthdate());
        int result = ps.executeUpdate();
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql ="select * from usertable where id=?;";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet rs=preparedStatement.executeQuery();
        User user = new User();
        if(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql ="select * from usertable where username=? and password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if(rs.next()){
            user= new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));

        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> userList=new ArrayList<User>();
        String sql="select * from usertable where username=?;";
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setString(1,username);
        ResultSet rs = preparedStatement.executeQuery();
        User user = new User();
        while(rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> userList=new ArrayList<User>();
        String sql="select * from usertable where password=?;";
        PreparedStatement preparedStatement =con.prepareStatement(sql);
        preparedStatement.setString(1,password);
        ResultSet rs = preparedStatement.executeQuery();
        User user = new User();
        while(rs.next()) {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            userList.add(user);
        }
            return userList;

    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
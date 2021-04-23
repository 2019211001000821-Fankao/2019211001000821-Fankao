<%@ page import="com.sun.org.apache.xerces.internal.xinclude.XInclude11TextReader" %>
<%@ page import="com.Fankao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/04/10
  Time: 下午 04:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
        <h1>User Info</h1>
<%
    //read cookies
    Cookie [] allCookies =request.getCookies();
    for(Cookie c: allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+" --- "+c.getValue());
    }
%>
<%
    User u =(User)session.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=u.getEmail()%></td></tr>
    <tr><td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr><td>Birth date:</td><td><%=u.getBirthdate()%></td></tr>
</table>
<a href="updateUser">Update User</a>
<%@include file="footer.jsp"%>

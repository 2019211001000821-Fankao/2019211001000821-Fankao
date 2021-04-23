<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/04/23
  Time: 下午 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u =(User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input name="username" type="text" value="<%=u.getUsername()%>" /><br/>
    password<input name="password" type="password" value="<%=u.getPassword()%>"/><br/>
    Email<input name="email" type="text" value="<%=u.getEmail()%>" ><br/>
    Gender:<input name="gender" type="radio" value="Male"<%="male".equals(u.getGender())? "checked" :""%>/>Male
    <input name="gender" type="radio" value="Female"<%="female".equals(u.getGender())? "checked" :""%>/>Female<br/>
    Date of Birth<input type="text" name="birthdate" value="<%=u.getBirthdate()%>"/><br/>
    <input  type="submit" value="Save Changes"/>
    </form>
<%@include file="footer.jsp"%>
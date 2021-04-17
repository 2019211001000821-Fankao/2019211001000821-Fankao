<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/04/05
  Time: 下午 04:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<b><p>Login</p></b>
<%
    if(!(request.getAttribute("message")==null)) {
        out.println("<h3>" + request.getAttribute("message") + "</h3>");
    }
%>
<form method="post" action="/Login">
    <label>UserName:<input name="UserName" type="text" maxlength="10" size="30" placeholder="username input" required="required"/>
    </label><br/>
    <label>Password:<input name="Password" type="password" maxlength="10" size="30"placeholder="password" required="required"/>
    </label><br/>
    <label><input type="submit" name="Login" value="Login"/></label>
</form>
<%@include file="footer.jsp"%>
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
<%
    //read cookies
    Cookie [] allCookies = request.getCookies();//give all cookies
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies ){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")) {
                password = c.getValue();
            }
            if(c.getName().equals("cRememberMe")) {
                rememberMeVal = c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    <label>UserName:<input name="username" type="text" maxlength="10" size="30" placeholder="username input" required="required" value="<%=username%>"/>
    </label><br/>
    <label>Password:<input name="password" type="password" maxlength="10" size="30"placeholder="password" required="required" value="<%=password%>"/>
    </label><br/>
    <label>RememberMe<input name="rememberMe" type="checkbox" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/></label><br/>
    <label><input type="submit" name="login" value="login"/></label>
</form>
<%@include file="footer.jsp"%>
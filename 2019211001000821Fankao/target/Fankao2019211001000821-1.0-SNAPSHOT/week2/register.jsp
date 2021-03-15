<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/03/14
  Time: 下午 03:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">NEW USER REGISTRATION!</p>
<div style="width:100%;text-align:center">
<form>
    <label><input name="username" type="text" maxlength="10" size="30" placeholder="username input" required="required"/>
    </label><br/>
    <label><input name="userpsd" type="password" maxlength="10" size="30"placeholder="password" required="required"/>
    </label><br/>
    Gender <label><input name="sex" type="radio" value="Male"/>Male</label>
    <label><input name="sex" type="radio" value="Female"/>Female</label><br/>
    <label><input type="date" name="date" value="Date of birth(yyyy-mm-dd)"size="30" required="required"></label><br/>
    <label><input name="email" type="email" placeholder="Valid email "size="30" required="required"></label><br/>
    <label><input name="submit" type="submit" value="Register"/></label><br/>
</form>
</div>
</body>
</html>

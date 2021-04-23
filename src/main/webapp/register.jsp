<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/03/14
  Time: 下午 03:50
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<p align="center">NEW USER REGISTRATION!</p>
<div style="width:100%;text-align:center">
<form method="post" action="register">
    <label><input name="username" type="text" maxlength="10" size="30" placeholder="username input" required="required"/><br/>
    </label><br/>
    <label><input name="password" type="password" maxlength="10" size="30"placeholder="password" required="required"/>
    </label><br/>
    Gender <label><input name="gender" type="radio" value="Male"/>Male</label>
    <label><input name="gender" type="radio" value="Female"/>Female</label><br/>
    <label><input type="text" name="birthdate" placeholder="Date of birth(yyyy-mm-dd)"size="30" required="required"></label><br/>
    <label><input name="email" type="text" placeholder="Valid email "size="30" required="required"></label><br/>
    <label><input name="submit" type="submit" value="register"/></label><br/>
</form>
</div>
<%@include file="footer.jsp"%>


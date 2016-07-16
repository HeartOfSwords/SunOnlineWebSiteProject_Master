<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//邮箱回显
	String backShowUserEmail = "";
	if (request.getAttribute("useremail") != null) {
		backShowUserEmail = (String) request.getAttribute("useremail");
	}
	//登录信息回显
	String message = "";
	if (request.getAttribute("message") != null) {
		message = (String) request.getAttribute("message");
	}
	//注册信息回显
	String rMessage = "";
	if (request.getAttribute("rMessage") != null) {
		rMessage = (String) request.getAttribute("rMessage");
	}
%>
<h1>登录</h1>
<form action="UserLogin" method="POST">
	<%=message %>
	邮箱：<input type="text" name="useremail" maxlength="20" value="<%=backShowUserEmail%>"/><br/>
	密码：<input type="password" name="userpwd" maxlength="20"/><br/>
	<input type="submit" value="提交"/>
</form>
<hr>
<h1>注册</h1>
<form action="UserRegister" method="POST">
	<%=rMessage %>
	用户昵称：<input type="text" name="usernickname" maxlength="20"/><br/><br/>
	用户密码：<input type="text" name="userpwd" maxlength="20"/><br/><br/>
	用户手机：<input type="text" name="usermobile" maxlength="20"/><br/><br/>
	用户邮箱：<input type="text" name="useremail" maxlength="20"/><br/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>
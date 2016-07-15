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
	String backShowUserEmail = "";
	if (request.getAttribute("useremail") != null) {
		backShowUserEmail = (String)request.getAttribute("useremail");
	}
%>
<h1>登录</h1>
<form action="UserLogin" method="POST">
	邮箱：<input type="text" name="useremail" maxlength="20" value="<%=backShowUserEmail%>"/><br/>
	密码：<input type="password" name="userpwd" maxlength="20"/><br/>
	<input type="submit" value="提交"/>
</form>
<hr>
<h1>注册</h1>
<form action="UserRegister" method="POST">
	用户昵称：<input type="text" name="usernickname" maxlength="20"/><br/>
	用户密码：<input type="text" name="userpwd" maxlength="20"/><br/>
	用户手机：<input type="text" name="usermobile" maxlength="20"/><br/>
	用户邮箱：<input type="text" name="useremail" maxlength="20"/><br/>
</form>
</body>
</html>
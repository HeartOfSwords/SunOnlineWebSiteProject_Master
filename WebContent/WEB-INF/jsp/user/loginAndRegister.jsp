<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	if (request.getAttribute("rMessage") != null) {
		message = (String) request.getAttribute("rMessage");
	}
%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/userlogin.css" />
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/verify.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<style type="text/css">
			.input-group-addon {
				background-color: deepskyblue;
				font-size: large;
			}
		</style>

		<style type="text/css">
			select {
				width: 80px;
				height: 35px;
				box-shadow: #959CA8;
				font-size: 17px;
			}

			select option {
				width: 70px;
				height: 35px;
				box-shadow: #959CA8;
				font-size: 17px;
			}

			.web_login .input-tips2 {
				float: left;
				text-align: right;
				padding-right: 10px;
				width: 75px;
				height: 30px;
				font-size: 13px;
				margin-top: 10px;
				clear: both;
				line-height: 30px;
				font-family: "Hiragino Sans GB", "Microsoft Yahei";
			}

			.web_login.userRegister {
				width: 370px;
				position: relative;
				margin-left: 37px;
				margin-top: 5px;
			}
		</style>
		</head>

		<body>
			<h1>
		太阳在线用户登录
	</h1>
			<div class="login" style="margin-top: 50px;">
				<div class="header">
					<div class="switch" id="switch">
						<a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
						<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
						<div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
					</div>
				</div>
				<!--登录开始-->
				<div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
					<div class="web_login" id="web_login">
						<div class="login-box">
							<div class="login_form">
								<form action="UserLogin" method="post" id="loginform">
									<!--视频名称 -->
									<br />
									<!--登录返回信息-->
									<span class="server-result">
										<%=message %>
									</span>

									<div class="input-group">
										<div class="input-group-addon">账号</div>
										<input type="email" class="form-control inputstyle" id="user_login_email" name="useremail" placeholder="请输入注册邮箱" maxlength="20"
											value="<%=backShowUserEmail%>"/>
									</div>
									<!--视频链接 -->
									<br />
									<div class="input-group">
										<div class="input-group-addon userpwd">密码</div>
										<input type="password" class="form-control inputstyle" name="userpwd" id="user_login_pwd" placeholder="请输入密码" maxlength="20"/>
									</div><br/><br/>
									<center>
										<input type="submit" id="submitbtn" class="btn btn-primary btn-lg submit-login" value="提 交" />
									</center>
								</form>
							</div>
						</div>
					</div>
					<a href="IndexRouter"><span class="lg_return_index">返回首页</span></a>
				</div>
				<!--登录结束-->
				<!--注册-->
				<div class="qlogin" id="qlogin" style="display: none;">
					<!--注册返回信息-->
					<span class="regis-result"><%=message %></span>

					<div class="web_login userRegister">
						<form action="UserRegister" method="post">
							<!--用户昵称 -->
							<br />
							<div class="input-group">
								<div class="input-group-addon">用户昵称</div>
								<input type="text" class="form-control inputstyle" id="user_regis_id" name="usernickname" placeholder="请输入用户昵称" maxlength="20"/>
							</div>
							<!--用户密码 -->
							<br />
							<div class="input-group">
								<div class="input-group-addon">登录密码</div>
								<input type="password" class="form-control inputstyle" name="userpwd" id="user_regis_pwd" placeholder="请输入密码" maxlength="20"/>
							</div>
							<!--确认密码 -->
							<br />
							<div class="input-group">
								<div class="input-group-addon">确认密码</div>
								<input type="password" class="form-control inputstyle" name="reuserpwd" id="reuser_regis_pwd" placeholder="请再次输入密码" maxlength="20"/>
							</div>
							<!--登录邮箱 -->
							<br />
							<div class="input-group">
								<div class="input-group-addon">登录邮箱</div>
								<input type="email" class="form-control inputstyle" name="useremail" id="user_regis_email" placeholder="请输入登录邮箱" maxlength="20"/>
							</div>
							<!--手机号-->
							<br />
							<div class="input-group">
								<div class="input-group-addon">&nbsp;&nbsp;手机号&nbsp;</div>
								<input type="text" class="form-control inputstyle" name="usermobile" id="user_regis_mobile" placeholder="请输入您的手机号" maxlength="11"/>
							</div>
							<br/><br/>
							<div class="btn-set">
								<input type="submit" id="submitbtn" class="btn btn-primary btn-lg submit" value="提 交"/>
								<input type="reset" class="btn btn-warning btn-lg reset" value="重 置" />
							</div>
						</form>
					</div>
					<a href="IndexRouter"><span class="rg_return_index">返回首页</span></a>
				</div>
				<!--注册end-->
			</div>
			<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
		</body>
	</body>

</html>

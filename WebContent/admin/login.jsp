<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>太阳在线管理员后台登录</title>
		<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="images/login.js"></script>
		<script type="text/javascript" src="js/vilidate.js" ></script>
		<link href="css/login2.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<h1>太阳在线管理员后台登录<sup>2016</sup></h1>

		<div class="login" style="margin-top:50px;">

			<div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

				<!--登录-->
				<div class="web_login" id="web_login">

					<div class="login-box">

						<div class="login_form">
							<form action="adminLoginVerify" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0" />
								<input type="hidden" name="to" value="log" />
								<div class="uinArea Area" id="uinArea">
									<label class="input-tips" for="username">帐号：</label>
									<div class="inputOuter" id="uArea">

										<input type="text" id="username" name="username" class="inputstyle" placeholder="请输入账号"
										value="<%=request.getAttribute("admin_name") != null ? request.getAttribute("admin_name") : ""%>"/>
									</div>
								</div>
								<p>
								</p>
								
								<div class="pwdArea Area" id="pwdArea">
									<label class="input-tips" for="password">密码：</label>
									<div class="inputOuter" id="pArea">

										<input type="password" id="password" name="password" class="inputstyle" placeholder="请输入密码"/>
									</div>
								</div>
								
								<p>
										<!-- 认证失败 -->
										<%=request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : ""%>
										<!-- 绕过登录越权访问 -->
										<%=request.getAttribute("filterTip") != null ? request.getAttribute("filterTip") : ""%>
								</p>
								
								<div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue" /></div>
							</form>
						</div>

					</div>

				</div>
				<!--登录end-->
			</div>

			<!--注册-->
			<div class="qlogin" id="qlogin" style="display: none; ">

				<div class="web_login">
					<form name="form2" id="regUser" accept-charset="utf-8" action="" method="post">
						<input type="hidden" name="to" value="reg" />
						<input type="hidden" name="did" value="0" />
					</form>

				</div>

			</div>
			<!--注册end-->
		</div>
		<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
		<br/><br/>
		<div align="center">
			<font color="ghostwhite" size="3">2016太阳在线 All rights Reserved</font>
		</div>
	</body>

</html>
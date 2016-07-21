<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/userManagerDialog.css" />
		<script src="js/jquery-1.12.3.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#user-info").click(function() {
				$("#modal").css("display", "block");
			});
			$(".modal-close").click(function() {
				$("#modal").css("display", "none");
			});
			$("#userinfo-btn").click(function() {
				$(".dialog").css("height", "420px");
			});
			$("#changePwd-btn").click(function() {
				$(".dialog").css("height", "300px");
			});

			var return_result_flag = new Array();
			//修改密码表单验证——旧密码验证
			$("#user_cur_pwd").focusout(function() {
				var word_reg = /^[a-zA-Z]+$/; //不能全是字母
				var flag_reg = /^[_#@]+$/; //不能全是符号
				var num_reg = /.{6,12}/; //长度为6到12位
				if(!num_reg.test($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "密码长度为6到12位");
					$(this).addClass("invalid");
					return_result_flag[0] = 0;
				} else if(flag_reg.test($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "不能全是特殊字符");
					$(this).addClass("invalid");
					return_result_flag[0] = 0;
				} else if(word_reg.test($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "不能全是字母");
					$(this).addClass("invalid");
					return_result_flag[0] = 0;
				} else if(!isNaN($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "不能全是数字");
					$(this).addClass("invalid");
					return_result_flag[0] = 0;
				} else {
					$(this).removeClass("invalid");
					return_result_flag[0] = 1;
				}
			});
			//修改密码表单验证——新密码验证
			$("#user_new_pwd").focusout(function() {
				var word_reg = /^[a-zA-Z]+$/; //不能全是字母
				var flag_reg = /^[_#@]+$/; //不能全是符号
				var num_reg = /.{6,12}/; //长度为6到12位
				if(!num_reg.test($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "密码长度为6到12位");
					$(this).addClass("invalid");
					return_result_flag[1] = 0;
				} else if(flag_reg.test($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "不能全是特殊字符");
					$(this).addClass("invalid");
					return_result_flag[1] = 0;
				} else if(word_reg.test($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "不能全是字母");
					$(this).addClass("invalid");
					return_result_flag[1] = 0;
				} else if(!isNaN($(this).val())) {
					$(this).val("");
					$(this).attr("placeholder", "不能全是数字");
					$(this).addClass("invalid");
					return_result_flag[1] = 0;
				} else {
					$(this).removeClass("invalid");
					return_result_flag[1] = 1;
				}
			});
			//表单合法性验证函数
			function submits(arr) {
				//此处只可以使用arr.length，不可以使用arr.size
				//foreach中，i代表下标
				if(arr.length == 0 || arr == null){
					return false;
				}else{
					for(var i in arr) {
						if(arr[i] == 0) {
							return false;
						}
					}
					return true;
				}
			}

			//通过登录表单和注册表单触发验证事件
			$("#changeform").submit(function() {
				//submits(return_login_flag);
				alert(submits(return_result_flag))
				return(submits(return_result_flag));
			})
		});
	</script>

	<body>
		<!--弹窗-->
		<div class="modal-block" id="modal">
			<!--弹出体-->
			<div class="dialog center">
				<!--关闭标签-->
				<span class="glyphicon glyphicon-remove modal-close"></span>
				<!--切换部分-->
				<!--选项卡-->
				<ul class="nav nav-tabs">
					<li>
						<a href="#userinfo" data-toggle="tab" id="userinfo-btn">个人信息</a>
					</li>
					<li>
						<a href="#changePwd" data-toggle="tab" id="changePwd-btn">修改密码</a>
					</li>
				</ul>
				<!--选项卡面板-->
				<div class="tab-content">
					<div class="tab-pane active" id="userinfo">
						<div class="user-form">
							<!--用户logo-->
							<div class="user-logo">
								<span class="">
										<img src="img/user-info-logo.png"/>
									</span>
							</div>
							<!--用户Id-->
							<div class="user-info-default">
								<span>您的id：123456</span>
							</div>
							<!--用户昵称-->
							<div class="user-info-default">
								<span>您的昵称：天上的星星参北斗啊</span>
							</div>
							<!--用户邮箱-->
							<div class="user-info-default">
								<span>绑定邮箱：605181746@qq.com</span>
							</div>
							<!--用户手机号-->
							<div class="user-info-default">
								<span>绑定手机号：18435168890</span>
							</div>
						</div>
					</div>
					<div class="tab-pane" id="changePwd">
						<div class="user-form">
							<form action="#" method="post" id="changeform">
								<input type="text" class="form-control" id="user_cur_pwd" placeholder="请输入您当前的密码" name="user_cur_pwd">
								<input type="password" class="form-control" id="user_new_pwd" placeholder="请输入新密码" name="user_new_pwd">
								<button type="submit" class="btn btn-red btn-register" >确认提交</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--触发元素-->
		<!--<button data-toggle="modal" data-target = "dialog" class="btn btn-primary">单击弹出</button>-->
		<!--<button class="btn btn-primary" id="login">触发元素</button>-->
		<!-- <a id="user-info" style="cursor: pointer;color: black;">触发元素</a> -->
		
	</body>
</html>
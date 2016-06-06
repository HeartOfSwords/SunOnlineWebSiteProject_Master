$(function(){
				var userflag=false;   /*用户账号标志位  */
				var passflag=false;   /*用户密码标志位*/
				/* 当焦点集中时，清空输入框中的信息*/
				$("input#username[name='username'],input#password[name='password']").focus(function(){
					$(this).val("");
					$(this).parents(".Area").next("p").html("");
				});
				/*
				 inpType：输入框的类型，具体对象
				 tipbox：提示消息的容器
				 * */
				function vilidta(inpType,tipbox){
					var value= inpType.val();
					var tip= inpType.attr("name")=="username"?"账号":"密码";
					var reg=/^[A-Za-z0-9]{6,12}$/;
					var chinareg=/\u4e00-\u9fa5/;
					var message;
					if(value==""){
						message=tip+"不能为空！";
					}else if(value.length<6){
						message=tip+"长度不能少于6位！";
					}else if(!value.match(reg)){
						message=tip+"长度不能少于6位！";
					}else{
						if(inpType.attr("name")=="username"){
							userflag=true;
						}else{
							passflag=true;
						}
					}
					$(tipbox).html(message);
				}
				
				/* 账号和密码验证*/
				$("input#username[name='username'],input#password[name='password']").blur(function(){
					vilidta($(this),$(this).parents(".Area").next("p"));
				});
				/*提交表单 */
				$("form#login_form").submit(function(){
					if(userflag==true&&passflag==true){
						return true;
					}else{
						return false;
					}
				});
		});
		
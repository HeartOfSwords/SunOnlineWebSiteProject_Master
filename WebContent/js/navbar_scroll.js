$(function(){
	//设置导航条出现的高度
	var scroll_height = 380;
	//每当鼠标滚轮事件被触发，执行function方法
	$(document).mousewheel(function(event, driction, x, y){
		
		if($("body").scrollTop() >= scroll_height || $("html").scrollTop() >= scroll_height){
			
			$(".dynamic_header").fadeIn("slow",function(){
				$(".dynamic_header").show();
			});
		}else{
			$(".dynamic_header").fadeOut("fast",function(){
				$(".dynamic_header").hide();
			});
		}
		
	});
});
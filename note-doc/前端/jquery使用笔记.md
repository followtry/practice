## JQuery 使用笔记
### 1.jquery 设置当前元素样式和同级其他元素样式
	$(this).css('background','#FFFFFF');
	//设置当前元素的同级元素样式
	$(this).siblings().css('background','#F5F7FA');
### 2.删除元素
	$("elem").remove();
	$("elem").hide();
	$("elem").show();
	$("elem").empty();//子元素置为空
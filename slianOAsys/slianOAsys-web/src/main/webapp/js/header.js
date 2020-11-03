//头部
function header(){
	var header=document.getElementById('header');
	var header_1='<div class="header_1"> \
		 	  <div class="logo">\
		 	     <a href="#">\
		 	  	    <img class="tp" src="images/logo1.png">\
                    <span class="logo_1">管理平台</span>\
		 	  	 </a>\
                 <span class="right_1">\
                 	 <span class="yhm">用户名</span>\
                 	 <span><a href="#">帮助中心</a></span>\
                 	 <span><a href="#">退出</a></span>\
                 </span>\
		 	  </div>\
		 </div>\
		 <div class="header_2">\
		    <div class="header_2_1">\
			 	  <ul>\
			 	  	 <li><a class="bg" href="#">内容管理</a></li>\
			 	  	 <li><a href="#">通讯录管理</a></li>\
			 	  </ul>\
		 	</div>\
		 </div>';
	header.innerHTML=header_1;
}
header();
//头部
		  
		 

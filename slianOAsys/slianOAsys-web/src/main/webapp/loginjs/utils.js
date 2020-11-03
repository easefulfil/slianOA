var BASE_URL = "/slianOAsys-admin/";




function getContextPath(){ 
	var pathName = document.location.pathname; 
	var index = pathName.substr(1).indexOf("/"); 
	var result = pathName.substr(0,index+1); 
	return result; 
}

function serializeObject(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};


function isExistCellPhone(input) {

	var flag = $.util.requestAjaxData(BASE_URL
			+ '/customer/isExistCellPhone.do', {
		'cellPhone' : $(input).val()
	});

	if (flag) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>手机号码已注册，请直接登陆！</font></span>");
		$(input).focus();
		return true;
	}

	return false;

}

function isUnExistCellPhone(input) {

	var flag = $.util.requestAjaxData(BASE_URL
			+ '/customer/isExistCellPhone.do', {
		'cellPhone' : $(input).val()
	});

	if (!flag) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>手机号码不存，请注册或联系管理员！</font></span>");
		$(input).focus();
		return true;
	}

	return false;

}

function isExistAccount(input) {

	var flag = $.util.requestAjaxData(BASE_URL + '/auth/isExistAccount.do', {
		'account' : $(input).val()
	});

	if (flag) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>手机号码已注册，请直接登陆！</font></span>");
		$(input).focus();
		return true;
	}

	return false;

}

function isUnExistAccount(input) {

	var flag = $.util.requestAjaxData(BASE_URL + '/auth/isExistAccount.do', {
		'account' : $(input).val()
	});

	$(".alert_span").remove();
	if (!flag) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>账号不存在，请注册或联系管理员！</font></span>");
		$(input).focus();
		return true;
	}

	return false;

}

function checkCellPhoneIntput(input,isCheckNull) {

	$(".alert_span").remove();

//	if ($.string.isNullOrEmpty($(input).val())
//			|| !$.string.isMobile($(input).val())) {
	if ((isCheckNull && ($(input).val() == "" || !$.string
				.isMobile($(input).val())))
				|| (!isCheckNull && !$(input).val() == "" && !$.string.isMobile($(
						input).val()))) {

		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>手机号码输入错误！</font></span>");
		$(input).focus();
		return false;
	}

	return true;
}

function checkPhoneIntput(input, isCheckNull) {

	$(".alert_span").remove();

	// if($.string.isNullOrEmpty( $(input).val()) || !$.string.isTel(
	// $(input).val()) ){
	if ((isCheckNull && ($(input).val() == "" || !$.string
			.isTel($(input).val())))
			|| (!isCheckNull && !$(input).val() == "" && !$.string.isTel($(
					input).val()))) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>电话号码输入错误！</font></span>");
		$(input).focus();
		return false;
	}

	return true;
}

function checkConfirmPasswordInput(inputPassword, inputConfirmPassword) {

	$(".alert_span").remove();

	if ($(inputPassword).val() != $(inputConfirmPassword).val()) {
		$(inputConfirmPassword)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>二次密码输入不一致！</font></span>");
		// $(this).focus();
		return false;
	}

	return true;
}

function checkEmailInput(input, isCheckNull) {

	$(".alert_span").remove();

	if ((isCheckNull && ($(input).val() == "" || !$.string.isEmail($(input)
			.val())))
			|| (!isCheckNull && !$(input).val() == "" && !$.string.isEmail($(
					input).val()))) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>请正确的邮箱！</font></span>");
		$(input).focus();
		return false;
	}

	return true;

}

function isNullInput(inputs) {

	var flag = false;
	$(".alert_span").remove();
	
	$.each(inputs,function(i,input){
		if ($.string.isNullOrEmpty($(input).val())) {
			$(input)
					.parent()
					.after(
							"<span class='alert_span'><font color='red'>不能为空！</font></span>");
//			$(input).focus();
			flag = true;
			
//			return false;//break
		}		
		
	
	});


	return flag;

}

function checkPasswordInput(input) {

	$(".alert_span").remove();

	if ($(input).val() == "" || $(input).val().length < 6) {
		$(input)
				.parent()
				.after(
						"<span class='alert_span'><font color='red'>请输入6位及上密码！</font></span>");
		$(input).focus();
		return false;
	}
	return true;

}

//设置当前选定的input值
function setInputValue(input, val) {
	if ($.string.isNullOrEmpty(val))
		return;

	var htmlType = input.type;
	
	if (htmlType == "radio") {
	
		
		if($(input).val() == val)
			$(input).attr("checked", "checked");
//			$(this).prop('checked', true);
//		$(this).prop("checked") == true;
		
		return false;
	} 
	
	if (htmlType == "checkbox") {
		var vals = val.split(",");
		for (var i = 0; i < vals.length; i++) {

			if ($(input).val() == vals[i])
				$(input).attr("checked", true);
		}
		
		return false;
		
	}
	
//	if(htmlType == "select"){
//		alert($(input).children());
//		return;
//	
//	}
	
//	if (htmlType == "text" || htmlType == "email" || htmlType == "textarea"
//		|| htmlType == "select-one" || htmlType == "hidden"
//		|| htmlType == "button") {
	$(input).val(val);
}

//设置当前选定的input值
function clearInputValue(input) {
	
	var htmlType = input.type;
	
//	var htmlType = $(input).attr("type");
	
	if (htmlType == "radio") {
//			$(input).attr("checked", false);
		$(this).removeAttr("checked");
//		$(this).prop("checked") == false;
		return false;
	} 
	
	if (htmlType == "checkbox") {
		
		$(input).attr("checked", false);
	
		return false;
		
	}
	

	
//	if (htmlType == "text" || htmlType == "email" || htmlType == "textarea"
//		|| htmlType == "select-one" || htmlType == "hidden"
//		|| htmlType == "button") {
	$(input).val("");
}



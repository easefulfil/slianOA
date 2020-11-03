

/**
 * 设置默认的查询条件
 */
function setDefault(){
	
	var date =new Date();
	//当前月份的第一天  $.date.format($.date.addDays($.date.format(new Date(),'yyyy-MM')),'yyyy-MM-dd')
	date.setMonth(date.getMonth() - 1); 
	$('#startdate').datebox('setValue',$.date.format(date,'yyyy-MM-dd'));
	
	$('#enddate').datebox('setValue',$.date.format(new Date(),'yyyy-MM-dd'));
	
//	$('#topnum').combobox('setValue','10');
}

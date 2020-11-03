// dom 就绪后执行
$(document).ready(function(){
	
	showSystemSetting();
	
});

function showSystemSetting(){
	
	$.ajax({
		type:"post",
		url:getContextPath()+"/systemsetting/getSystemSetting.do",// getContextPath()+'/resources/getTreegrid.do'+'?id=10',//
		
		dataType:'json',
		success:function(result){
			//initOrgaInfo(roleId,node.id,treeData);
			setSystemSettingValue(result);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
	          return false;
		}
	});
	
}

function setSystemSettingValue(systemsettings){
	
	
	$.each(systemsettings,function(i,st){
		
		
		$("input[id="+st.stKey+"]").val(st.stValue);
		
	});
	
}

function clearForm(){
	$('#form1').form('clear');
}

function saveSystemSetting(jsonSt){
	$.ajax({
		type:"post",
		url:getContextPath()+"/systemsetting/save.do",// getContextPath()+'/resources/getTreegrid.do'+'?id=10',//
		data:{
			"jsonSt":jsonSt
		},
		dataType:'json',
		success:function(result){
			//initOrgaInfo(roleId,node.id,treeData);
			setSystemSettingValue(result);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
	          //通常情况下textStatus和errorThrown只有其中一个包含信息
	          this;   //调用本次ajax请求时传递的options参数
	          alert(textStatus + errorThrown);
	          return false;
		}
	});
}

function onClik(){  


        saveSystemSetting(JSON.stringify(sy.serializeObject($('#form1'))));
        
        
}  
function transTEU(){
	document.getElementById("teuStart").style.display="none";
	document.getElementById("teuEnd").style.display="none";
	document.getElementById("teuStop").style.display="none";
	$('#teuDialog').show();
	$('#teuDialog').dialog({
	    title:'转换实际出货量',
	    buttons:[{
	        text:'确认',
	        iconCls:'icon-ok',
	        handler:function(){
	        	$('#teuDialog').dialog('close');
	        	document.getElementById("teuStart").style.display="";
	        	$.ajax({
	        		url:getContextPath()+"/LogToAnalysis/LTA.do",
	        		success:function(result){
	        			document.getElementById("teuStart").style.display="none";
	        			document.getElementById("teuEnd").style.display="";
	        		},
	        		error:function(result){
	        			document.getElementById("teuStart").style.display="none";
	        			document.getElementById("teuStop").style.display="";
	        		}
	        	});
	        }	   

	    },{
	        text:'取消',
	        handler:function(){
	            $('#teuDialog').dialog('close');
	        }
	    }]
	});
	return;    			
}

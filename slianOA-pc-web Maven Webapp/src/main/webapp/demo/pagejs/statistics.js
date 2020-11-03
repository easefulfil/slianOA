/**
 * 
 */
$(function () {
  $('#container').highcharts({
    title: {
      text: 'Major Cities  Sales Quantity ',
      x: -20 //center
    },
    subtitle: {
      text: '',
      x: -20
    },
    xAxis: {
      //关键 ：参考官网的json格式拼接处正确的json
      categories: <?php  echo $get_time;?>
    },
    yAxis: {
      title: {
        text: ' Sales Quantity'
      },
      plotLines: [{
        value: 0,
        width: 1,
        color: '#808080'
      }]
    },
    tooltip: {
      valueSuffix: ''
    },
    legend: {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle',
      borderWidth: 0
    },
    series:<?php echo $get_data;?>
  });
});


var all_datas;
var date;
jQuery(document).ready(function(){


  $('#but').click(function(){ 
   //更新表格 
  $('#xxoo').datagrid('reload',{bt:$('#bt').datebox('getValue'),et:$('#et').datebox('getValue')});
 var c=1;
 $('#xxoo').datagrid({
  onLoadSuccess:function(){
//datagrid会重复加载...还没解决
    c++;
    //以下为获取表格数据拼接json
    if(c==2){

    var obj=eval('('+JSON.stringify($('#xxoo').datagrid('getData'))+')');

    var date=[];
    var all_datas=[];

    var all_data={};
    var all_data1={};
    var all_data2={};
    var all_data3={};
    var all_data4={};
    var all_data5={};
    var all_data6={};
    var all_data7={};
    var all_data8={};
    
    var all_names=new Array('Qingpu','Foxtown','Wuxi','Suzhou','Beijing','Shenyang','Xiamen','Chongqing','Chengdu');
    var all_names1=[];

      var datas=[];
      var datas1=[];
      var datas2=[];
      var datas3=[];
      var datas4=[];
      var datas5=[];
      var datas6=[];
      var datas7=[];
      var datas8=[];
      var city_names=[];

    for(var i=0;i<obj.rows.length;i++){
      
      if(obj.rows[i].outdate!='TOTAL'){
        date.push(obj.rows[i].outdate);	
  
         datas[i]=obj.rows[i].Qingpu;
         datas1[i]=obj.rows[i].Foxtown;
         datas2[i]=obj.rows[i].Wuxi;
         datas3[i]=obj.rows[i].Suzhou;
         datas4[i]=obj.rows[i].Beijing;
         datas5[i]=obj.rows[i].Shenyang;
         datas6[i]=obj.rows[i].Xiamen;
         datas7[i]=obj.rows[i].Chongqing;
         datas8[i]=obj.rows[i].Chengdu;
        }
    }
    all_data["name"]=all_names[0];
    all_data["data"]=datas;

    all_data1['name']=all_names[1];
    all_data1['data']=datas1;

    all_data2['name']=all_names[2];
    all_data2['data']=datas2;

    all_data3['name']=all_names[3];
    all_data3['data']=datas3;

    all_data4['name']=all_names[4];
    all_data4['data']=datas4;

    all_data5['name']=all_names[5];
    all_data5['data']=datas5;

    all_data6['name']=all_names[6];
    all_data6['data']=datas6;

    all_data7['name']=all_names[7];
    all_data7['data']=datas7;

    all_data8['name']=all_names[8];
    all_data8['data']=datas8;
    
      all_datas.push(all_data);
      all_datas.push(all_data1);
      all_datas.push(all_data2);
      all_datas.push(all_data3);
      all_datas.push(all_data4);
      all_datas.push(all_data5);
      all_datas.push(all_data6);
      all_datas.push(all_data7);
      all_datas.push(all_data8);

    $('#container').highcharts({
            title: {
                text: 'Major Cities  Sales Quantity ',
                x: -20 //center
            },
            subtitle: {
                text: '',
                x: -20
            },
            xAxis: {
                categories:JSON.parse(JSON.stringify(date))
            },
            yAxis: {
                title: {
                    text: " Sales Quantity"
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: ''
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series:JSON.parse(JSON.stringify(all_datas))
            
        });
      
    }else{
      c--;
      }
    }

   });

});
});

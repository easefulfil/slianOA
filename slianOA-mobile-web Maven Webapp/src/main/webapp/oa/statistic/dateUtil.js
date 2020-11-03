function lastMonthDate(){
    var Nowdate = new Date();
    var vYear = Nowdate.getFullYear();
    var vMon = Nowdate.getMonth() + 1;
    var vDay = Nowdate.getDate();
// 每个月的最后一天日期（为了使用月份便于查找，数组第一位设为0）
    var daysInMonth = new Array(0,31,28,31,30,31,30,31,31,30,31,30,31);
    if(vMon==1){
        vYear = Nowdate.getFullYear()-1;
        vMon = 12;
    }else{
        vMon = vMon -1;
    }

//    若是闰年，二月最后一天是29号
    if(vYear%4 == 0 && vYear%100 != 0){
        daysInMonth[2]= 29;
    }
    if(daysInMonth[vMon] < vDay){
        vDay = daysInMonth[vMon];
    }
    if(vDay<10){
        vDay="0"+vDay;
    }
    if(vMon<10){
        vMon="0"+vMon;
    }
    var date =vYear+"-"+ vMon +"-"+vDay;
    console.log(date)
    return date;
}
// a>b,true;a<=b，false
function compareTo(a,b){
	console.log("实际按："+a+" "+b);
	if(a!= null && b!=null){
		// 比较年份
		if(a.split("-")[0] > b.split("-")[0]){
			return true;
		}else{
			if(a.split("-")[0] < b.split("-")[0]){
				return false;
			}else{
				// 比较月份
				if(a.split("-")[1] > b.split("-")[1]){
					return true;
				}else if(a.split("-")[1] < b.split("-")[1]){
					return false;
				}else{
					//比较日
					if(a.split("-")[2] > b.split("-")[2]){
						return true;
					}else if(a.split("-")[2] < b.split("-")[2]){
						return false;
					}else{
						return false;
					}
					
				}
			}
		}
	}else{
		return false;
	}
}
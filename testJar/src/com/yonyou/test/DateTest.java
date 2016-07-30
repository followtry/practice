package com.yonyou.test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
//		computeTime("2015-12-10","2015-12-10");
//		Date date = new Date(115, 11, 24);
//		System.out.println(date.getTime()+","+date.toLocaleString());
	}
	
	/**
	 * 计算时间差值
	 */
	public static void computeTime(String startTime,String endTime){
		String[] sTime = startTime.split("-");
		String[] eTime = endTime.split("-");
		
		Date startDate = null;
		Date endDate = null;
		if (sTime.length == 3 && eTime.length  == 3) {
			Calendar date = Calendar.getInstance();
			
			//获取开始时间
			date.clear();
			date.set(Integer.valueOf(sTime[0]), Integer.valueOf(sTime[1]) - 1,Integer.valueOf(sTime[2]));
			startDate = date.getTime();
			
			//获取结束时间
			date.clear();
			date.set(Integer.valueOf(eTime[0]), Integer.valueOf(eTime[1]) - 1,Integer.valueOf(eTime[2]));
			endDate = date.getTime();
			
			//计算相差的小时数
			long hourDValue = (endDate.getTime()  - startDate.getTime()) /(1000 * 60 * 60);
			if (hourDValue <= 0) {//起止日期相同
				hourDValue = 24;
				System.out.println("当前时间差值为：" + hourDValue +"小时");
			}else if (hourDValue <= 72 ) {//时间差值小于三天
				System.out.println("当前时间差值为：" + hourDValue +"小时");
			}else if (hourDValue <= 2160) {//时间差值小于三个月
				hourDValue = hourDValue / 24;
				System.out.println("当前时间差值为：" + hourDValue +"天");
			}else if (hourDValue > 2160) {//时间差值大于三个月
				hourDValue = hourDValue / (24 * 30);
				System.out.println("当前时间差值为：" + hourDValue +"月");
			}else {
				System.out.println("计算出现错误");
			}
		}
		
	}
	
	/**
	 * 比较时间
	 */
	public static void computeDate(){
		Calendar cale = Calendar.getInstance();
		cale.setTime(new Date());
		int intervals = 7;
		int tmp = intervals  * -1;
		cale.add(Calendar.DAY_OF_MONTH, tmp);
		
		Calendar cale2 = Calendar.getInstance();
		cale2.setTime(new Date());
		int intervals2 = 3;
		int tmp2 = intervals2  * -1;
		cale2.add(Calendar.DAY_OF_MONTH, tmp2);
		
		long firstTime = cale.getTime().getTime();
		long curTime = cale2.getTime().getTime();
		System.out.println(cale.getTime());
		System.out.println(cale2.getTime());
		long day = (curTime  - firstTime)/(1000 * 60 * 60 *24);
		System.out.println("天数差值："+day);
	}

}

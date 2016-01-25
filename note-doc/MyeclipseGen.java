/**
 * @time  2014-8-29 上午11:52:14
 * @author new
 * @function 
 * 
 */
package com.neusoft.myeclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyeclipseGen {
	private static final String LL = "Decompiling this copyrighted software is a violation of both your license agreement and the Digital Millenium Copyright Act of 1998 (http://www.loc.gov/copyright/legislation/dmca.pdf). Under section 1204 of the DMCA, penalties range up to a $500,000 fine or up to five years imprisonment for a first offense. Think about it; pay for a license, avoid prosecution, and feel better about yourself.";
	
	public String getSerial(String userId, String licenseNum) {
		
	   java.util.Calendar cal = java.util.Calendar.getInstance();
	   cal.add(1, 3);
	   cal.add(6, -1);
	   
	   java.text.NumberFormat nf = new java.text.DecimalFormat("000");
	   
	   licenseNum = nf.format(Integer.valueOf(licenseNum));
	   System.out.println("licenseNum:"+licenseNum);
	   
	   String verTime = new StringBuilder("-").append(
	     new java.text.SimpleDateFormat("yyMMdd").format(cal.getTime()))
	     .append("0").toString();
	   												
	   System.out.println("verTime:"+verTime);
	   
	   String type = "YE3MP-";
	   String need = new StringBuilder(userId.substring(0, 1)).append(type)
	     .append("300").append(licenseNum).append(verTime).toString();
	   
	   System.out.println("need:"+need);
	   
	   String dx = new StringBuilder(need).append(LL).append(userId)
	     .toString();
	   
	   System.out.println("dx:"+dx);
	   int suf = this.decode(dx);
	   
	   System.out.println("suf:"+suf);
	   String code = new StringBuilder(need).append(String.valueOf(suf))
	     .toString();
	   
	   System.out.println("code:"+code);
	   return this.change(code);
	}
	
	private int decode(String s) {
	   int number;
	   char[] ac;
	   int j;
	   number = 0;
	   ac = s.toCharArray();
	   j = 0;
	   while (j < s.length()) {
		   number = (31 * number) + ac[j];
	    j++;
	   }
	   return Math.abs(number);
	}
	
	private String change(String s) {
	   byte[] abyte0;
	   char[] ac;
	   int i;
	   int length;
	   int j;
	   abyte0 = s.getBytes();
	   ac = new char[s.length()];
	   i = 0;
	   length = abyte0.length;
	   
	   /*注册码生成算法*/
	   while (i < length) {
		    j = abyte0[i];
		    if ((j >= 48) && (j <= 57)) {/*变化数字,数字后移5位,加上48变为ascii码标准值*/
		    	j = (((j - 48) + 5) % 10) + 48;
		    } else if ((j >= 65) && (j <= 90)) {/*变化大写,大写字母后移13位,取余后加97变为ascii码标准值*/
		    	j = (((j - 65) + 13) % 26) + 65;
		    } else if ((j >= 97) && (j <= 122)) {/*变化小写,小写字母后移13位,取余后加97变为ascii码标准值*/
		    	j = (((j - 97) + 13) % 26) + 97;
		    }
		    ac[i] = (char) j;/*将转换后的数添加到ac数组中,'-'的值不变*/
		    i++;
	   }
	   return String.valueOf(ac);
	}
	
	public MyeclipseGen() {
	   super();
	}
	
	public static void main(String[] args) {
	   try {
		    System.out.println("please input register name:");
		    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		    String userId = null;
		    userId = reader.readLine();
		    MyeclipseGen myeclipsegen = new MyeclipseGen();
		    String res = myeclipsegen.getSerial(userId, "5");
		    System.out.println("Serial:" + res);
		    reader.readLine();
	   } catch (IOException ex) {
		  ex.printStackTrace();
	   }
	}
}


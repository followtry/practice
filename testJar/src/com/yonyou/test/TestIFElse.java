package com.yonyou.test;

public class TestIFElse {

	public static void main(String[] args) {
		boolean userExists=false;
		boolean spaceExists= true;
		boolean isUserInSpace=false;
		String msg="null";
		if (!userExists || !spaceExists) {
			   msg = !userExists?"userId不存在":!spaceExists?"spaceId不存在":"";
			   isUserInSpace=true;
		}else if (isUserInSpace) {
			msg="用户存在于space中";
		}else{
			msg="用户和space都存在";
		}
		System.out.println(msg);
	}

}

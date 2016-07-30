package com.yonyou.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Test {
	private static byte[] src=new byte[100];
	private static byte[] buffer;
	private static byte[] dst;
	private static InputStream is;
	private static OutputStream os;

	public static void main(String[] args) throws Exception {
		String string="http://www.baidu.com?token=sdflejeklwew&page=1&wd=jdk";
		src=string.getBytes();
		Decoder decoder = Base64.getDecoder();
		decoder.decode(src);
		decoder.decode(buffer);
		decoder.decode("");
		decoder.decode(src, dst);
		decoder.wrap(is);
		
		Encoder encoder = Base64.getEncoder();
		encoder.encode(src);
		encoder.encode(buffer);
		encoder.encode(src, dst);
		encoder.encodeToString(src);
		encoder.wrap(os);
		
		Base64.getMimeDecoder();
		Base64.getMimeEncoder();
		
		int lineLength=0;
		byte[] lineSeparator=null;
		Base64.getMimeEncoder(lineLength, lineSeparator);
		
		Base64.getUrlDecoder();
		Base64.getUrlEncoder();
		
		Base64.Decoder.class.getName();
		Base64.Encoder.class.newInstance();
	}

}

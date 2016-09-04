package yonyou.esn.openapi.palmyy;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;



/**
 * 
 * @Description 消息管理工具  加解处理
 * @author jack.sj
 * @date Oct 29, 2013 10:44:42 PM
 */
public class MessageUtil {
	/**
	 *  解密
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static String DesEncrypt(InputStream is) throws Exception{
	  	GZIPInputStream gzipStream =  new GZIPInputStream(is);
		
			byte[] buffer = new byte[4096];
			int len = -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((len = gzipStream.read(buffer)) != -1)
			{
				baos.write(buffer, 0, len);
			}

			byte [] data=baos.toByteArray();
			//base64解码
			BASE64Decoder encoder = new BASE64Decoder();
			String d = new String(data,"UTF-8");
//			MobileApp.getApplication().setmToken(d);
			byte[]  e = encoder.decodeBuffer(d);
			//des解密
			byte[] c = DesEncrypt.getInstance().decode(e);
			String f = new String(c,"UTF-8");
			gzipStream.close();
	    	return f;
	}

	public static byte[] Encrypt(String strsource) throws Exception
	{
		return Encrypt(strsource.getBytes("UTF-8"));
	}
	
	public static byte[] Encrypt(byte [] results) throws Exception
	{
		//加密
		byte[] desbytes = DesEncrypt.getInstance().encode(results);
		//base64
		BASE64Encoder encode = new BASE64Encoder();
		String base64Str = encode.encode(desbytes);
		byte[] base64Bytes = base64Str.getBytes("UTF-8");

		ByteArrayOutputStream destByte = new ByteArrayOutputStream();
		GZIPOutputStream gzipStream =  new GZIPOutputStream(destByte);		
		gzipStream.write(base64Bytes);
		gzipStream.flush();
		gzipStream.close();
		
		byte[] dest = destByte.toByteArray();
	    return dest;
		
	}
}

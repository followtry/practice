package cn.followtry.custom.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码操作工具类
 * Created by followtry on 2017/4/13.
 */
public class CodecUtils {
	private static final Logger LOGGER=LoggerFactory.getLogger(CodecUtils.class);

	/**
	 * 对url进行编码
	 * @param source
	 * @return
	 */
	public static String encodeUrl(String source) {
		String encode=null;
		try {
			encode=URLEncoder.encode(source, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			LOGGER.error("encode url failure", e);
			throw new RuntimeException(e);
		}
		return encode;
	}

	/**
	 * 将url解码
	 * @param source
	 * @return
	 */
	public static String decodeUrl(String source) {
		String decode=null;
		try {
			decode=URLDecoder.decode(source, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			LOGGER.error("decode url failure", e);
			throw new RuntimeException(e);
		}
		return decode;
	}


}

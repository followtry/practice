package cn.followtry.custom.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流处理工具类
 * Created by followtry on 2017/4/13.
 */
public class StreamUtils {
	private static final Logger LOGGER=LoggerFactory.getLogger(StreamUtils.class);

	public static String getString(InputStream in) {
		StringBuilder sb=new StringBuilder();
		BufferedReader bReader=new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while ((line=bReader.readLine()) != null) {
				sb.append(line);
			}
		} catch(IOException e) {
			LOGGER.error("get String failure", e);
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
}

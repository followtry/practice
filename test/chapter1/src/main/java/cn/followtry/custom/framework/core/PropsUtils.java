package cn.followtry.custom.framework.core;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by followtry on 2017/4/12.
 */
public class PropsUtils {
	private static final Logger logger = LoggerFactory.getLogger(PropsUtils.class);

	private PropsUtils() {
	}

	public static Properties loadProps(String propsPath) {
		Properties props = new Properties();
		InputStream is = null;

		try {
			if(StringUtils.isEmpty(propsPath)) {
				throw new IllegalArgumentException();
			}

			String e = ".properties";
			if(propsPath.lastIndexOf(e) == -1) {
				propsPath = propsPath + e;
			}

			is = ClassUtils.getClassLoader().getResourceAsStream(propsPath);
			if(is != null) {
				props.load(is);
			}
		} catch (Exception var11) {
			logger.error("加载属性文件出错！", var11);
			throw new RuntimeException(var11);
		} finally {
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException var10) {
				logger.error("释放资源出错！", var10);
			}

		}

		return props;
	}

	public static Map<String, String> loadPropsToMap(String propsPath) {
		HashMap map = new HashMap();
		Properties props = loadProps(propsPath);
		Iterator i$ = props.stringPropertyNames().iterator();

		while(i$.hasNext()) {
			String key = (String)i$.next();
			map.put(key, props.getProperty(key));
		}

		return map;
	}

	public static String getString(Properties props, String key) {
		String value = "";
		if(props.containsKey(key)) {
			value = props.getProperty(key);
		}

		return value;
	}

	public static String getString(Properties props, String key, String defalutValue) {
		String value = defalutValue;
		if(props.containsKey(key)) {
			value = props.getProperty(key);
		}

		return value;
	}

	public static int getNumber(Properties props, String key) {
		int value = 0;
		if(props.containsKey(key)) {
			value = CastUtils.castInt(props.getProperty(key));
		}

		return value;
	}

	public static int getNumber(Properties props, String key, int defaultValue) {
		int value = defaultValue;
		if(props.containsKey(key)) {
			value = CastUtils.castInt(props.getProperty(key));
		}

		return value;
	}

	public static boolean getBoolean(Properties props, String key) {
		return getBoolean(props, key, false);
	}

	public static boolean getBoolean(Properties props, String key, boolean defalutValue) {
		boolean value = defalutValue;
		if(props.containsKey(key)) {
			value = CastUtils.castBoolean(props.getProperty(key));
		}

		return value;
	}

	public static Map<String, Object> getMap(Properties props, String prefix) {
		LinkedHashMap kvMap = new LinkedHashMap();
		Set keySet = props.stringPropertyNames();
		if(CollectionUtils.isNotEmpty(keySet)) {
			Iterator i$ = keySet.iterator();

			while(i$.hasNext()) {
				String key = (String)i$.next();
				if(key.startsWith(prefix)) {
					String value = props.getProperty(key);
					kvMap.put(key, value);
				}
			}
		}

		return kvMap;
	}
}

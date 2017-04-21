package cn.followtry.custom.framework.core;

import java.util.Properties;

/**
 * Created by followtry on 2017/4/12.
 */
public class ConfigHelper {

	private static final Properties CONFIG_OPTS=PropsUtils.loadProps(ConfigConstant.CONFIG_FILE);

	/**
	 * 获取jdbc驱动
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.JDBC_DRIVER);
	}

	/**
	 * 获取jdbc的用户名
	 * @return
	 */
	public static String getJdbcUsername() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.JDBC_USERNAME);
	}

	/**
	 * 获取jdbc的密码
	 * @return
	 */
	public static String getJdbcPwd() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.JDBC_PWD);
	}

	/**
	 * 获取jdbc的url
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.JDBC_URL);
	}
	/**
	 * 获取app的基础包名
	 * @return
	 */
	public static String getAppBasePackage() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.APP_BASE_PACKAGE);
	}

	/**
	 * 获取app的jsp路径
	 * @return
	 */
	public static String getAppJspPath() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
	}

	/**
	 * 获取app的asset路径
	 * @return
	 */
	public static String getAppAssetPath() {
		return PropsUtils.getString(CONFIG_OPTS, ConfigConstant.APP_ASSET_PATH,"/asset/");
	}


}

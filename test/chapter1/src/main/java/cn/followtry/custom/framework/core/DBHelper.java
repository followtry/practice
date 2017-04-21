package cn.followtry.custom.framework.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库操作助手类
 * Created by followtry on 2017/4/18.
 */
public class DBHelper {

	private static final Logger LOGGER= LoggerFactory.getLogger(DBHelper.class);

	public static Connection getConnection() {

		return null;
	}

	public static void beginTransaction(Connection conn) {
		if (conn != null) {
			try {
				conn.setAutoCommit(false);
			} catch(SQLException e) {
				LOGGER.error("begin transacion failure");
				throw new RuntimeException(e);
			}

		}
	}

	public static void commitTransaction(Connection conn) {

		if (conn != null) {
			try {
				conn.commit();
			} catch(SQLException e) {
				LOGGER.error("commit transacion failure");
				rollbackTransaction(conn);
				throw new RuntimeException(e);
			}finally {
				closeConnection(conn);
			}

		}

	}

	public static void rollbackTransaction(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch(SQLException e) {
				LOGGER.error("rollback transacion failure");
				throw new RuntimeException(e);
			}finally {
				closeConnection(conn);
			}

		}
	}

	private static void closeConnection(Connection conn){
		if (conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				LOGGER.error("close Database connection failure");
				throw new RuntimeException(e);
			}

		}
	}
}

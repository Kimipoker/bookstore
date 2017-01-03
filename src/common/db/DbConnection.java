package common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 * @author lenovo
 *
 */
public final class DbConnection {

	private String db_url = "jdbc:mysql://localhost:3306/exam?useUnicode=true&amp;characterEncoding=utf-8";

	private String db_user_account = "root";

	private String db_user_pwd = "123456";

	private static DbConnection dbConn;
    
	//加载数据库驱动类
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}

	private DbConnection() throws SQLException {

	}
    
	public synchronized Connection getConnection() throws SQLException {
			return DriverManager
					.getConnection(db_url, db_user_account, db_user_pwd);
	}

	public static synchronized DbConnection getInstance() throws SQLException {
		if (dbConn == null) {
			dbConn = new DbConnection();
		}
		return dbConn;

	}

}
package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/*2015.12.22
 * 所有的备份数据库信息,包括
 * 
 * */

public class BackupDatabase {
	
	//yisinian数据库
	 public static Connection getConnectionYisinian() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/yisinian","work","147258369");
			} catch (Exception e) {
				
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	
	//icheck模板数据库
	 public static Connection getConnectionIcheck() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/icheck","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	//icheck_hebgydxszysy哈尔滨工业大学深圳研究生院数据库
	 public static Connection getConnectionIcheck_hebgydxszysy() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/icheck_hebgydxszysy","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	//icheck_sziit深圳信息职业技术学院数据库
	 public static Connection getConnectionIcheck_sziit() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/icheck_sziit","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_gdzqszqxyt肇庆学院数据库
	 public static Connection getConnectionIcheck_gdzqszqxy() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/icheck_gdzqszqxy","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_gdssszyjsxy深圳职业技术学院数据库
	 public static Connection getConnectionIcheck_gdssszyjsxy() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/icheck_gdssszyjsxy","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	 
		//icheck_hlju黑龙江大学数据库
	 public static Connection getConnectionIcheck_hlju() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3307/icheck_hlju","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	 
		//icheck_sdqdsqddx青岛大学数据库
	 public static Connection getConnectionIcheck_sdqdsqddx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3307/icheck_sdqdsqddx","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_hlqqhesqqhedx齐齐哈尔大学数据库
	 public static Connection getConnectionIcheck_hlqqhesqqhedx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3307/icheck_hlqqhesqqhedx","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_hnjshnlgdx河南理工大学数据库
	 public static Connection getConnectionIcheck_hnjshnlgdx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3307/icheck_hnjshnlgdx","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_gyhebshebgcdx哈尔滨工程大学数据库
	 public static Connection getConnectionIcheck_gyhebshebgcdx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3307/icheck_gyhebshebgcdx","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	 
	
}

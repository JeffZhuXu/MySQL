package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/*2015.11.29
 * 所有的数据库信息,包括
 * （1）数据库连接地址和端口
 * （2）根用户名、密码
 * （3）该数据库所含有的学校，‘1’表示含有
 * 
 * */

public class Database {
	
	//icheck项目北京运营服务器
	public static final HashMap<String, String> IcheckBeijing = new HashMap<String, String>() {
	    {
	        put("url", "123.57.174.243:3306");  //数据库地址
	        put("user", "root");  //用户名
	        put("password", "wamqy1");  //密码
	        put("icheck_gyhebshebgcdx","1");//哈尔滨工程大学   置为1表示该学校在这个数据库当中
	        put("icheck_hnjshnlgdx","1");//河南理工大学
	        put("icheck_hlju","1");//黑龙江大学
	        put("icheck_sdqdsqddx","1");//青岛大学
	        put("icheck_hlqqhesqqhedx","1");//齐齐哈尔大学
	        
	    }
	};
	//icheck项目深圳运营服务器
	public static final HashMap<String, String> IcheckShenZhen = new HashMap<String, String>() {
	    {
	        put("url", "120.24.167.68:3306");  //数据库地址
	        put("user", "root");  //用户名
	        put("password", "wamqy1");  //密码
	        put("icheck_hebgydxszysy","1");//哈尔滨工业大学深圳研究生院
	        put("icheck_sziit","1");//深圳信息职业技术学院
	        put("icheck_gdzqszqxy","1");//肇庆学院
	        put("icheck_gdssszyjsxy","1");//深圳职业技术学院
	    }
	};
	//icheck项目北京备份服务器
	public static final HashMap<String, String> IcheckBeijingBackup = new HashMap<String, String>() {
	    {
	        put("url", "120.24.64.106:3308");  //数据库地址
	        put("user", "root");  //用户名
	        put("password", "wamqy1");  //密码
	    }
	};
	//icheck项目深圳备份服务器
	public static final HashMap<String, String> IcheckShenZhenBackup = new HashMap<String, String>() {
	    {
	        put("url", "120.24.64.106:3306");  //数据库地址
	        put("user", "root");  //用户名
	        put("password", "379016635");  //密码
	    }
	};
	
	//小秘助手项目深圳运营服务器
	public static final HashMap<String, String> XiaoMIShenZhen = new HashMap<String, String>() {
	    {
	        put("url", "120.24.64.106:3306");  //数据库地址
	        put("user", "root");  //用户名
	        put("password", "wamqy1");  //密码
	    }
	};
	
	//yisinian数据库
	 public static Connection getConnectionYisinian() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/yisinian","root","wamqy1");
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
						"jdbc:mysql://120.24.167.68:3306/icheck","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_open开放注册数据库
	 public static Connection getConnectionIcheck_open() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/open","root","wamqy1");
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
						"jdbc:mysql://120.24.167.68:3306/icheck_hebgydxszysy","root","wamqy1");
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
						"jdbc:mysql://120.24.167.68:3306/icheck_sziit","root","wamqy1");
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
						"jdbc:mysql://120.24.167.68:3306/icheck_gdzqszqxy","root","wamqy1");
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
						"jdbc:mysql://120.24.167.68:3306/icheck_gdssszyjsxy","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	 
		//icheck_open_zhenzhen深圳公开数据库
	 public static Connection getConnectionIcheck_open_shenzhen() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck_open_shenzhen","root","wamqy1");
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
						"jdbc:mysql://123.57.174.243:3306/icheck_hlju","root","wamqy1");
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
						"jdbc:mysql://123.57.174.243:3306/icheck_sdqdsqddx","root","wamqy1");
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
						"jdbc:mysql://123.57.174.243:3306/icheck_hlqqhesqqhedx","root","wamqy1");
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
						"jdbc:mysql://123.57.174.243:3306/icheck_hnjshnlgdx","root","wamqy1");
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
						"jdbc:mysql://123.57.174.243:3306/icheck_gyhebshebgcdx","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
		//icheck_gyhebshebgcdx哈尔滨工程大学数据库
	 public static Connection getConnectionIcheck_open_beijing() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_open_beijing","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//将连接返回
				return conn;
			}
	}
	
}

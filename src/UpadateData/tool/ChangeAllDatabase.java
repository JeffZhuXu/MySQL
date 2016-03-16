package UpadateData.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*2015.11.29
 * 朱旭
 * 针对所有数据库进行操作的集合类，主要包含以下几个功能
 * 
 * 修改数据库结构
 * （1）修改所有学校数据库结构，包括新建删除、添加表或者添加、删除表字段
 * （2）修改某一个学校的数据库结构，包括新建删除、添加表或者添加、删除表字段
 * 添加数据
 * （3）向某一个数据库中写入指定信息
 * （4）向所有数据库中写入指定信息
 * 查询数据
 * （5）向某一个数据库指定查询语句
 * （6）向所有数据库执行查询语句
 * 
 * 
 * */

public class ChangeAllDatabase {
	

	private static final String icheck = "icheck";//模板数据库
	private static final String icheck_open = "icheck_open";//icheck开放注册数据库
	private static final String icheck_gyhebshebgcdx = "icheck_gyhebshebgcdx";//哈尔滨工程大学
	private static final String icheck_hnjshnlgdx = "icheck_hnjshnlgdx"; //河南理工大学
	private static final String icheck_hlqqhesqqhedx = "icheck_hlqqhesqqhedx"; //齐齐哈尔大学
	private static final String icheck_hlju = "icheck_hlju"; //黑龙江大学
	private static final String icheck_sdqdsqddx = "icheck_sdqdsqddx"; //青岛大学
	private static final String icheck_hebgydxszysy = "icheck_hebgydxszysy"; //哈尔滨工业大学深圳研究生院
	private static final String icheck_sziit = "icheck_sziit"; //深圳信息职业技术学院
	private static final String icheck_gdzqszqxy = "icheck_gdzqszqxy"; //肇庆学院
	private static final String icheck_gdssszyjsxy = "icheck_gdssszyjsxy"; //深圳职业技术学院

	
	//修改模板数据库结构
	public static void changeStructure_icheck(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					icheck, 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码

			Statement stat9 = conn.createStatement();
			System.out.println("icheck修改成功");
			stat9.executeUpdate(sql);//执行sql语句
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改icheck开放注册数据库结构
	public static void changeStructure_icheck_open(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					icheck_open, 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码

			Statement stat9 = conn.createStatement();
			System.out.println("icheck_open修改成功");
			stat9.executeUpdate(sql);//执行sql语句
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	//修改 哈尔滨工程大学 的数据库结构
	public static void changeStructure_icheck_gyhebshebgcdx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //数据库地址
					"/"+
					icheck_gyhebshebgcdx, 
					Database.IcheckBeijing.get("user"),   //数据库用户名
					Database.IcheckBeijing.get("password"));  //数据库密码

			Statement stat1 = conn.createStatement();
			stat1.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_gyhebshebgcdx修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改 河南理工大学  的数据库结构
	public static void changeStructure_icheck_hnjshnlgdx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //数据库地址
					"/"+
					icheck_hnjshnlgdx, 
					Database.IcheckBeijing.get("user"),   //数据库用户名
					Database.IcheckBeijing.get("password"));  //数据库密码

			Statement stat2 = conn.createStatement();
			stat2.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_hnjshnlgdx修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//修改  齐齐哈尔大学  的数据库结构
	public static void changeStructure_icheck_hlqqhesqqhedx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //数据库地址
					"/"+
					icheck_hlqqhesqqhedx, 
					Database.IcheckBeijing.get("user"),   //数据库用户名
					Database.IcheckBeijing.get("password"));  //数据库密码

			Statement stat3 = conn.createStatement();
			stat3.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_hlqqhesqqhedx修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改  黑龙江大学  的数据库结构
	public static void changeStructure_icheck_hlju(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //数据库地址
					"/"+
					icheck_hlju, 
					Database.IcheckBeijing.get("user"),   //数据库用户名
					Database.IcheckBeijing.get("password"));  //数据库密码

			Statement stat4 = conn.createStatement();
			stat4.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_hlju修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//修改 青岛大学  的数据库结构
	public static void changeStructure_icheck_sdqdsqddx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //数据库地址
					"/"+
					icheck_sdqdsqddx, 
					Database.IcheckBeijing.get("user"),   //数据库用户名
					Database.IcheckBeijing.get("password"));  //数据库密码

			Statement stat5 = conn.createStatement();
			stat5.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_sdqdsqddx修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改 肇庆学院  的数据库结构
	public static void changeStructure_icheck_gdzqszqxy(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					icheck_gdzqszqxy, 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码

			Statement stat6 = conn.createStatement();
			stat6.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_gdzqszqxy修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改 深圳信息职业技术学院  的数据库结构
	public static void changeStructure_icheck_sziit(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					icheck_sziit, 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码

			Statement stat7 = conn.createStatement();
			stat7.executeUpdate(sql);//执行sql语句
			System.out.println("icheck_sziit修改成功");
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改深圳职业技术学院  的数据库结构
	public static void changeStructure_icheck_gdssszyjsxy(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					icheck_gdssszyjsxy, 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码

			Statement stat8 = conn.createStatement();
			System.out.println("icheck_gdssszyjsxy修改成功");
			stat8.executeUpdate(sql);//执行sql语句
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//修改 哈尔滨工业大学深圳研究生院  的数据库结构
	public static void changeStructure_icheck_hebgydxszysy(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					icheck_hebgydxszysy, 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码

			Statement stat9 = conn.createStatement();
			System.out.println("icheck_hebgydxszysy修改成功");
			stat9.executeUpdate(sql);//执行sql语句
			conn.close();//关闭连接
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	//修改所有学校数据库的结构
	public static void changeStructureAllDatabase(String sql){
		changeStructure_icheck(sql);
		changeStructure_icheck_gdssszyjsxy(sql);
		changeStructure_icheck_gdzqszqxy(sql);
		changeStructure_icheck_gyhebshebgcdx(sql);
		changeStructure_icheck_hebgydxszysy(sql);
		changeStructure_icheck_hlju(sql);
		changeStructure_icheck_hlqqhesqqhedx(sql);
		changeStructure_icheck_hnjshnlgdx(sql);
		changeStructure_icheck_sdqdsqddx(sql);
		changeStructure_icheck_sziit(sql);
		
	}

	//主函数
	public static void main(String[] args) {
//		changeStructureAllDatabase("" +
//				"ALTER TABLE `teacher` ADD COLUMN `school`  char(30) NOT NULL DEFAULT 0 COMMENT '老师所在学校' AFTER `telephone`;");
		changeStructureAllDatabase("" +
		"ALTER TABLE `average_class` ADD COLUMN `school`  char(30) NOT NULL DEFAULT 0 COMMENT '所在学校' AFTER `class_id`");

	} 
	
	
}
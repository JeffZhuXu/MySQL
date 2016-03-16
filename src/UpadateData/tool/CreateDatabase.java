package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*2015.8.28
 * 给定数据库名称，新建数据库，同时给数据库指定结构内容
 * 朱旭
 * 
 * */
public class CreateDatabase {
//	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//
//		
//		
//		Connection connection = null;
//		Statement statement = connection.createStatement();
//		try {
//		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//	      String url = "jdbc:mysql://120.24.167.68/aas";
//	      connection = DriverManager.getConnection(url, "root", "wamqy1");
//	      Statement stat = connection.createStatement();
//	      
//	      
//	      
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		
//	}
	
		
		
//	public static void main(String[] args) {
		
//		try {
//			Runtime r = Runtime.getRuntime();
//			String[] cmd = new String[5];
//			
//			cmd[0] = "cmd "; //命令行
//			cmd[1] = "/c "; //运行后关闭，
//			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
//			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
//			
//			cmd[4] = "mysql -h120.24.167.68 -uroot -pwamqy1 asd < C:\\icheck.sql";//exe程序及其需要的参数
//			String Naiveexe = "calc.exe";//windows自带计算器
//			String line;
//			String space=" ";
//			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
//			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
//			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
//			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
//			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			while((line=br.readLine()) != null){
//				System.out.println(line);
//				//p.waitFor();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	//新建数据库
	public static void main(String[] args) {
		//北京服务器和备份
		
//		createNewDatabaseBeiJing("icheck_sdqdsqddx");
//		createBackupDatabaseBeiJing("icheck_sdqdsqddx");
		
		//深圳服务器和备份
		
//		createNewDatabaseShenZhen("icheck_open");
		createBackupDatabaseShenZhen("icheck_open");
		
		
		//在已经建立数据库基础上，更新数据库脚本
//		updateDatabaseBeiJing("icheck_hlju");
//		updateBackupDatabaseBeiJing("icheck_hlju");
//		
//		updateDatabaseShenZhen("he");
//		updateBackupDatabaseShenZhen("icheck_hebgydxszysy");
		
	}
	

	public   static void createNewDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.167.68/icheck","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h120.24.167.68 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//北京服务器建数据库
	
	public   static void createNewDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://123.57.174.243/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h123.57.174.243 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	
	//备份服务器（北京）建数据库
	
	public   static void createBackupDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3307/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h120.24.7.44 -P 3307 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//备份服务器（深圳）建数据库
	
	public   static void createBackupDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3306/icheck_sziit","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h120.24.7.44 -P 3306 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	
	public   static void updateDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.167.68/icheck","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      //stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h120.24.167.68 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//北京服务器建数据库
	
	public   static void updateDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://123.57.174.243/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      //stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h123.57.174.243 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	
	//备份服务器（北京）建数据库
	
	public   static void updateBackupDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3307/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      //stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h120.24.7.44 -P 3307 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//备份服务器（深圳）建数据库
	
	public   static void updateBackupDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//连接数据库
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3306/icheck_sziit","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //新建数据库
	      //stat.executeUpdate("create database "+databasename);
	      
	      //调用mysql.exe文件初始化数据库格式，格式保存在c:/icheck.sql文件当中
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //命令行
			cmd[1] = "/c "; //运行后关闭，
			cmd[2] = "start "; //启动另一个窗口来运行指定的程序或命令(cmd 命令集里的)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //要运行的.exe程序的目录
			
			cmd[4] = "mysql -h120.24.7.44 -P 3306 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe程序及其需要的参数
			String Naiveexe = "calc.exe";//windows自带计算器
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); 此时输出到控制台
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));此时弹出dos窗口运行
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //直接运行计算器
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
}

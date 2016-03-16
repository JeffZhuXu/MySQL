package UpadateData.tool;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/*2015.12.7
 * 朱旭
 * 功能：删除微信绑定以及根据openID查找学生信息
 * 参数：openid
 * 函数：	（1）deleteStudentWechatBinding(String openID):删除学生微信绑定，无返回值
 * 	  	（2）deletetTeacherWechatBinding(String openID)：删除老师微信绑定，无返回值
 * 		（3）findStudentWechatBinding(String openID):查找学生信息
 * 			返回值：String 格式 JSONObject  
 * 			{"dbname":"icheck_sziit",				//数据库名称
 * 			"schoolNmaeString":"深圳信息职业技术学院",		//学校
 * 			"userid":"11",							//学生userID
 * 			"studentTeacherId":"11",				//学生学号
 * 			"userName":"11"}						//学生姓名
 *  	（4）findTeacherWechatBinding(String openID):查找老师信息
 * 			返回值：String 格式 JSONObject  
 * 			{"dbname":"icheck_sziit",				//数据库名称
 * 			"schoolNmaeString":"深圳信息职业技术学院",		//学校
 * 			"userid":"11",							//老师userID
 * 			"studentTeacherId":"11",				//老师工号
 * 			"userName":"11"}						//姓名
 * 
 * */
public class Wechat {
	//删除学生微信绑定
	public static void deletetStudentWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		Connection conn = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码
			Statement stat9 = conn.createStatement();
			//查询所在数据库
			ResultSet dbNameResultSet = stat9.executeQuery("SELECT w.db_name,w.openid from wechat_db w  where w.openid ='"+openidString+"' limit 1");
			//删除yisinian中微信绑定记录
			Statement stat10 = conn.createStatement();
			stat10.executeUpdate("delete from wechat_db where openid='"+openidString+"'");  //删除学生在yisinian中对应的数据库记录
			while(dbNameResultSet.next()){
				String dbname ="";
				dbname= dbNameResultSet.getString(1); //获取该openid所在数据库
				//conn.close();//关闭连接
				//如果该学生绑定的是深圳数据库
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("openid在深圳数据库");
					
					//重新连上深圳数据库
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //数据库用户名
							Database.IcheckShenZhen.get("password"));  //数据库密码
					conn1.createStatement().executeUpdate("delete from wechat where openid='"+openidString+"'");
					conn1.close();//关闭深圳连接
				//如果该学生绑定的是北京数据库
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("openid在北京数据库");

					//重新连上北京数据库
					Connection conn2 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //数据库用户名
							Database.IcheckBeijing.get("password"));  //数据库密码
					conn2.createStatement().executeUpdate("delete from wechat where openid='"+openidString+"'");
					conn2.close();//关闭北京连接
					
				}else{
					System.out.println("该openID未绑定数据库");
				}
			
				
			}
			
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
	//删除老师微信绑定
	public static void deletetTeacherWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		Connection conn = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码
			Statement stat11 = conn.createStatement();
			//查询所在数据库
			ResultSet dbNameResultSet = stat11.executeQuery("SELECT w.db_name,w.openid from wechat_db_teacher w  where w.openid ='"+openidString+"' limit 1");
			//删除yisinian中微信绑定记录
			Statement stat12 = conn.createStatement();
			stat12.executeUpdate("delete from wechat_db_teacher where openid='"+openidString+"'");  //删除学生在yisinian中对应的数据库记录
			while(dbNameResultSet.next()){
				String dbname ="";
				dbname= dbNameResultSet.getString(1); //获取该openid所在数据库
				//conn.close();//关闭连接
				//如果该老师绑定的是深圳数据库
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("openid在深圳数据库");
					//重新连上深圳数据库
					Connection conn3 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //数据库用户名
							Database.IcheckShenZhen.get("password"));  //数据库密码
					//删除老师绑定
					conn3.createStatement().executeUpdate("delete from wechat_teacher where openid='"+openidString+"'");
					conn3.close();//关闭深圳连接
				//如果该老师绑定的是北京数据库
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("openid在北京数据库");

					//重新连上北京数据库
					Connection conn4 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //数据库用户名
							Database.IcheckBeijing.get("password"));  //数据库密码
					conn4.createStatement().executeUpdate("delete from wechat_teacher where openid='"+openidString+"'");
					conn4.close();//关闭北京连接
					
				}else{
					System.out.println("该openID未绑定数据库");
				}
			
				
			}
			
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

	
	//查找学生微信绑定
	public static String findStudentWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		JSONObject  studebtJsonObject = new JSONObject(); //存放学生信息
		
		Connection conn = null;	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码
			Statement stat9 = conn.createStatement();
			//查询所在数据库
			ResultSet dbNameResultSet = stat9.executeQuery("SELECT a.db_name,s.school_name from wechat_db a NATURAL join schools s where a.openid='"+openidString+"' limit 1");
			
			
			
			while(dbNameResultSet.next()){
				String dbname ="";
				String schoolNmaeString = "";
				dbname= dbNameResultSet.getString(1); //获取该openid所在数据库
				schoolNmaeString = dbNameResultSet.getString(2);//获取学校名称
				studebtJsonObject.put("dbname",dbname);  //存入返回的学生信息中
				studebtJsonObject.put("schoolNmaeString",schoolNmaeString); //存入返回的学生信息中
				//conn.close();//关闭连接
				//如果该学生绑定的是深圳数据库
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("学生openid在深圳数据库");
					
					//重新连上深圳数据库
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //数据库用户名
							Database.IcheckShenZhen.get("password"));  //数据库密码
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat a LEFT OUTER JOIN user s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
					String userid=studentResultSet.getString(1); //学生userID
					String studentTeacherId =studentResultSet.getString(2);//学生学号
					String studentName=studentResultSet.getString(3);//学生姓名
			
					studebtJsonObject.put("userid",userid);  //存入返回的学生信息中
					studebtJsonObject.put("studentTeacherId",studentTeacherId); //存入返回的学生信息中
					studebtJsonObject.put("studentName",studentName); //存入返回的学生信息中
					break; //跳出循环
					}
					conn1.close();//关闭深圳连接
				//如果该学生绑定的是北京数据库
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("学生openid在北京数据库");

					//重新连上北京数据库
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //数据库用户名
							Database.IcheckBeijing.get("password"));  //数据库密码
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat a LEFT OUTER JOIN user s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
					String userid=studentResultSet.getString(1); //学生userID
					String studentTeacherId = studentResultSet.getString(2);//学生学号
					String studentName =studentResultSet.getString(3);//学生姓名
			
					studebtJsonObject.put("userid",userid);  //存入返回的学生信息中
					studebtJsonObject.put("studentTeacherId",studentTeacherId); //存入返回的学生信息中
					studebtJsonObject.put("studentName",studentName); //存入返回的学生信息中
					break; //跳出循环
					}
					conn1.close();//关闭北京连接
					
				}else{
					System.out.println("该openID未绑定数据库");
				}
			
				System.out.println(studebtJsonObject);
				
			}
			
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
		return studebtJsonObject.toString(); //返回查找到的信息
		
	}
	//查找老师微信绑定
	public static String findTeacherWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		JSONObject  teacherJsonObject = new JSONObject(); //存放老师信息
		
		Connection conn = null;	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //数据库地址
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //数据库用户名
					Database.IcheckShenZhen.get("password"));  //数据库密码
			Statement stat9 = conn.createStatement();
			//查询所在数据库
			ResultSet dbNameResultSet = stat9.executeQuery("SELECT a.db_name,s.school_name from wechat_db_teacher a NATURAL join schools s where a.openid='"+openidString+"' limit 1");
			
			
			
			while(dbNameResultSet.next()){
				String dbname ="";
				String schoolNmaeString = "";
				dbname= dbNameResultSet.getString(1); //获取该openid所在数据库
				schoolNmaeString = dbNameResultSet.getString(2);//获取学校名称
				teacherJsonObject.put("dbname",dbname);  //存入返回的学生信息中
				teacherJsonObject.put("schoolNmaeString",schoolNmaeString); //存入返回的学生信息中
				//conn.close();//关闭连接
				//如果该学生绑定的是深圳数据库
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("老师openid在深圳数据库");
					
					//重新连上深圳数据库
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //数据库用户名
							Database.IcheckShenZhen.get("password"));  //数据库密码
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat_teacher a LEFT OUTER JOIN teacher s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
					String userid=studentResultSet.getString(1); //老师userID
					String studentTeacherId =studentResultSet.getString(2);//老师工号
					String userName =studentResultSet.getString(3);//老师姓名
			
					teacherJsonObject.put("userid",userid);  //存入返回的老师信息中
					teacherJsonObject.put("studentTeacherId",studentTeacherId); //存入返回的老师信息中
					teacherJsonObject.put("userName",userName); //存入返回的老师信息中
					break; //跳出循环
					}
					conn1.close();//关闭深圳连接
				//如果该学生绑定的是北京数据库
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("老师openid在北京数据库");

					//重新连上北京数据库
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //数据库地址
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //数据库用户名
							Database.IcheckBeijing.get("password"));  //数据库密码
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat_teacher a LEFT OUTER JOIN teacher s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
						String userid=studentResultSet.getString(1); //老师userID
						String studentTeacherId =studentResultSet.getString(2);//老师工号
						String userName = studentResultSet.getString(3);//老师姓名
				
						teacherJsonObject.put("userid",userid);  //存入返回的老师信息中
						teacherJsonObject.put("studentTeacherId",studentTeacherId); //存入返回的老师信息中
						teacherJsonObject.put("userName",userName); //存入返回的老师信息中
					break; //跳出循环
					}
					conn1.close();//关闭北京连接
					
				}else{
					System.out.println("该openID未绑定数据库");
				}
			
				System.out.println(teacherJsonObject);
				
			}
			
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
		return teacherJsonObject.toString(); //返回查找到的信息
	}
		
	
	public static void main(String[] args) {
		String aString = "oW5nrt4-jlcY6xM3OMlkBVgEF8to";
		findStudentWechatBinding(aString);
		findTeacherWechatBinding(aString);
		
		
		
	}
}

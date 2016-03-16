package UpadateData.sziit;

//查看佘志远的反馈记录


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import encryption.Base64;

public class LookFeedback {
	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.167.68/icheck_gdssszyjsxy", "root",
					"wamqy1");

			//查询学生端反馈的内容
			Statement stat = conn.createStatement();
			ResultSet rst = stat
					.executeQuery(
							"select f.feedback_id,f.version_num,f.type,f.user_id,f.forms,f.content,f.img_path,f.up_time,"+
							"CONCAT('姓名：',u.real_name,' 电话：',u.telephone,' 院系：',u.college,' 专业：',u.major,' 年级：',"+
							"u.grade, ' 班级：' ,u.class,' 账户：',u.student_teacher_id,' 密码：',u.user_password)"+
							" from feedback f  natural join user u"+
							" where f.results='待解决' and f.type='学生端'");
			
			String feedbackid=""; //反馈id
			String version ="";		//版本号
			String type ="";		//账户类型
			String userid="";		//用户id
			String content="";		//正文
			String uptime ="";		//反馈提交时间
			String results ="";		//反馈处理结果
			String message="";		//反馈者个人信息
			System.out.println("深信院学生端反馈内容");
			while (rst.next()) {
				feedbackid = rst.getString(1);
				version=rst.getString(2);
				type=rst.getString(3);
				userid=rst.getString(4);
				content=rst.getString(6);
				content = content;
				uptime=rst.getString(8);
				message=rst.getString(9);
				System.out.println(
						"版本号："+version+"\t"+
						"账户类型："+type+"\t"+
						"用户id："+userid+"  \t"+ 
						"申请提交时间："+ uptime+ "\t"+
						"个人信息："+message+ "\t\t\t"+
						"反馈正文："+Base64.decode(content,"utf8"));
				
			}
			//老师反馈内容
			
			//查询学生端反馈的内容
			Statement stat1 = conn.createStatement();
			ResultSet rst1 = stat1
					.executeQuery(
							"select f.feedback_id,f.version_num,f.type,f.user_id,f.forms,f.content,f.img_path,f.up_time,"+
							"CONCAT('姓名：',u.real_name,' 电话：',u.telephone,' 院系：',u.college,' 专业：',u.major,' 年级：',"+
							"u.grade, ' 班级：' ,u.class,' 账户：',u.student_teacher_id,' 密码：',u.user_password)"+
							" from feedback f  natural join teacher u"+
							" where f.results='待解决' and f.type='老师端'");
			System.out.println("\n\n深信院老师端反馈内容");
			while (rst1.next()) {
				feedbackid = rst1.getString(1);
				version=rst1.getString(2);
				type=rst1.getString(3);
				userid=rst1.getString(4);
				content=rst1.getString(6);
				uptime=rst1.getString(8);
				message=rst1.getString(9);
				System.out.println(
						"版本号："+version+"\t"+
						"账户类型："+type+"\t"+
						"用户id："+userid+"\t"  + 
						"申请提交时间："+ uptime+ "\t"+
						"个人信息："+message+ "\t\t\t\t"+
						"反馈正文："+Base64.decode(content,"utf8"));
				
			}
			
			
			//关闭数据库连接
			conn.close();
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
}

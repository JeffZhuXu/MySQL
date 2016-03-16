package UpadateData.sdqdsqddx;

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
					"jdbc:mysql://123.57.174.243/icheck_sdqdsqddx", "root",
					"wamqy1");

			Statement stat = conn.createStatement();
			ResultSet rst = stat
					.executeQuery("select * from feedback");
			
			String feedbackid="";
			String version ="";
			String type ="";
			String userid="";
			String content="";
			String uptime ="";
			String results ="";
				
			while (rst.next()) {
				feedbackid = rst.getString(1);
				version=rst.getString(2);
				type=rst.getString(3);
				userid=rst.getString(4);
				content=rst.getString(6);
				uptime=rst.getString(8);
				System.out.println(feedbackid + "\t"+version+"\t"+type+"\t"+userid+"\t"  + Base64.decode(content,"utf8") + "\t"
						+ uptime);
				
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

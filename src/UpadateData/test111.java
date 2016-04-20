package UpadateData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UpadateData.tool.Database;

public class test111 {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnectionIcheck_yisinian();
		Connection openShenzhenConnection = Database.getConnectionIcheck_open_shenzhen();
		Connection openBeijingConnection = Database.getConnectionIcheck_open_beijing();
		Statement statement = connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select user_name,app,location from user where user_id>=3028399 and user_id<=3028601");
		while (resultSet.next()) {
			String user_nameString = resultSet.getString(1);
			String app = resultSet.getString(2);
			String locationString = resultSet.getString(3);
			String studentTeacherIdString="";
			if (locationString.equals("北京")&&app.equals("there")) {
				Statement statement2 = openBeijingConnection.createStatement();
				ResultSet resultSet2 =statement2.executeQuery("select student_teacher_id from teacher where real_name ='"+user_nameString+"'");
				while (resultSet2.next()) {
					studentTeacherIdString=resultSet2.getString(1);
					break;
				}
			}else if (locationString.equals("北京")&&app.equals("shere")){
				Statement statement2 = openShenzhenConnection.createStatement();
				ResultSet resultSet2 =statement2.executeQuery("select student_teacher_id from user where real_name ='"+user_nameString+"'");
				while (resultSet2.next()) {
					studentTeacherIdString=resultSet2.getString(1);
					break;
				}
			}else if (locationString.equals("深圳")&&app.equals("there")){
				Statement statement2 = openShenzhenConnection.createStatement();
				ResultSet resultSet2 =statement2.executeQuery("select student_teacher_id from teacher where real_name ='"+user_nameString+"'");
				while (resultSet2.next()) {
					studentTeacherIdString=resultSet2.getString(1);
					break;
				}
			}else if (locationString.equals("深圳")&&app.equals("shere")){
				Statement statement2 = openShenzhenConnection.createStatement();
				ResultSet resultSet2 =statement2.executeQuery("select student_teacher_id from user where real_name ='"+user_nameString+"'");
				while (resultSet2.next()) {
					studentTeacherIdString=resultSet2.getString(1);
					break;
				}
			}
			Statement statement3 = connection.createStatement();
			if (!studentTeacherIdString.equals("")) {
				statement3.execute("update user set user_name='"+studentTeacherIdString+"'"+" where user_name='"+user_nameString+"'" );
			}
			
			System.out.println("真实姓名："+user_nameString+" 用户名："+studentTeacherIdString+" 服务器地址："+locationString);
		}
		connection.close();
		openBeijingConnection.close();
		openShenzhenConnection.close();
	}
}

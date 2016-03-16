package UpadateData;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import UpadateData.tool.Database;

//2016.2.26
//肇庆学院2015-2016下学期课程student_course表的录入
public class icheck_zhaoqingxueyuan {
	public static void main(String[] args) throws SQLException {
		Connection connection=Database.getConnectionIcheck_open_shenzhen();
		Statement statement=connection.createStatement();
		JSONArray schoolsArray= new JSONArray();
		ResultSet resultSet=statement.executeQuery("SELECT course_id,course_name,check_record,student_attendence_record,attendance_rate from icheck_open_shenzhen.course where course_id >=21245");
		while (resultSet.next()) {
			
			String course_id=resultSet.getString(1);
			String courseName=resultSet.getString(2);
			String major=resultSet.getString(3);
			String grade=resultSet.getString(4);
			String classString = resultSet.getString(5);
			System.out.println( course_id+" "+courseName+" "+major+" "+grade+" "+classString+" ");
			Statement statement2=connection.createStatement();
			ResultSet resultSet2=statement2.executeQuery("select user_id,real_name from icheck_open_shenzhen.user where school='肇庆学院' and major='"+major+"' and grade='"+grade+"' and class in "+classString);
			while (resultSet2.next()) {
				String studentId=resultSet2.getString(1);
				String studentName=resultSet2.getString(2);
				System.out.println( studentId+" "+studentName);
				PreparedStatement preparedStatement = connection.prepareStatement(
				"insert into student_course(course_id,user_id)values(?,?)");
				preparedStatement.setString(1, course_id);
				preparedStatement.setString(2, studentId);
				preparedStatement.executeUpdate();
			}

		}
		
		connection.close();
	}
}

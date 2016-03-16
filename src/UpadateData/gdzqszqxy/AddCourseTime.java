package UpadateData.gdzqszqxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import UpadateData.tool.CourseTimeFromWeekDayTimes;
import UpadateData.tool.GetDayAndTime;
import UpadateData.tool.GetWeeks;
import UpadateData.constant.*;
import net.sf.json.*;

public class AddCourseTime {
	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.167.68/icheck_gdzqszqxy", "work",
					"147258369");

			Statement stat = conn.createStatement();


	

				
			String sql = "INSERT into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)" ;
			
			for(int i=1;i<=10;i++){
				for(int j=1;j<=2;j++){
					PreparedStatement prep = conn.prepareStatement(sql);
					prep.setString(1, 2+"");
					prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.GDZQSZQXY, SchoolStartTime.GDZQSZQXY, i, 5, j));
					prep.setString(3, i+"");
					prep.setString(4, 5+"");
					prep.setString(5, j+"");
					prep.executeUpdate();
				}
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

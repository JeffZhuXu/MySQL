package UpadateData.hlju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UpadateData.constant.DailyTimes;
import UpadateData.constant.SchoolStartTime;
import UpadateData.tool.CourseTimeFromWeekDayTimes;

public class StorageToSql {

		/**将新闻存入数据库
		 * @param 
		 * 2015.8.26
		 */
		public static void addToSql(
				String courseid,
				String week,
				String day,
				String times
				)  {

			 Connection conn = null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager
					.getConnection("jdbc:mysql://120.24.167.68:3306/icheck_hlju","root", "wamqy1");
					
					PreparedStatement prep = conn.prepareStatement(
							"insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)");
					prep.setString(1, courseid);
					prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.HLJU, SchoolStartTime.HLJU,Integer.parseInt(week),Integer.parseInt(day), Integer.parseInt(times)));
					prep.setString(3, week);
					prep.setString(4, day);
					prep.setString(5, times);

					prep.executeUpdate();

					//update course set course_hours = (select COUNT(*) from course_time where course_id = new.course_id) where course_id = new.course_id;
					//update course set course_hours = (select COUNT(*) from course_time where course_id = old.course_id) where course_id = old.course_id;
					
					//关闭数据库连接
					conn.close();
				}catch (Exception e) { 
					e.printStackTrace(); 
					
					}finally{ 
						if(conn!=null){ 
							try { conn.close(); 
							} catch (SQLException e) {
								e.printStackTrace();
								} 
							} 
						}

		 }
		
	
}

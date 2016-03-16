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


/*
 * 添加学生与课程之间的联系表
 * 
 * 
 * */
public class AddStudentCourseHLJU {
	public static void main(String[] args) {

		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/icheck_hlju","root", "wamqy1");
				
				
				Statement stat = conn.createStatement();
				ResultSet rst = stat.executeQuery("SELECT course_id,student_num from course LEFT JOIN message on message.course_num=course.course_number where course_id>=12666");
				while(rst.next()){
					String courseid=rst.getString("course_id");
					String userid=rst.getString("student_num");
					System.out.println("课程号：" + courseid);
					System.out.println("学号：" + userid);
					PreparedStatement prep = conn.prepareStatement(
					"insert into student_course(course_id,user_id)values(?,?)");
					prep.setString(1, courseid);
					prep.setString(2, userid);
					prep.executeUpdate();
					
				}
				

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

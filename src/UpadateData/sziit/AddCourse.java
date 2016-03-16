 package UpadateData.sziit;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UpadateData.tool.CourseTimeFromWeekDayTimes;

//从课程编号和老师编号的表格中，将需要的course信息填入course表中

public class AddCourse {
	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.64.106:3306/icheck_sziit1",
					"administrator", "yisinian123456");

			Statement stat = conn.createStatement();
			ResultSet rst = stat
					.executeQuery("select * from course_teacher_student LEFT JOIN teacher on  course_teacher_student.teacher_id = teacher.student_teacher_id");

			while (rst.next()) {
				String courseNumber = rst.getString("course_number");
				String courseName = rst.getString("course_name");
				String teacherNum = rst.getString("teacher_id");
				String userId = rst.getString("user_id");
				String introduction = rst.getString("introduction");
				
				System.out.println(courseNumber);
				System.out.println(courseName);
				System.out.println(teacherNum);
				System.out.println(userId);
				System.out.println(introduction);
				
				String sql = "insert into course(course_number,course_name,user_id,course_introduction)VALUES(?,?,?,?)";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1, courseNumber); 
				prep.setString(2, courseName);
				prep.setString(3, userId);
				prep.setString(4, introduction);  //星期几
				prep.executeUpdate();
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

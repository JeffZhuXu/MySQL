package UpadateData.sziit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UpadateData.constant.DailyTimes;
import UpadateData.constant.SchoolStartTime;
import UpadateData.tool.CourseTimeFromWeekDayTimes;

/**
 * 给sziit每个班级添加一个班级账户
 * @author zhuxu
 * @time 2015.8.21 
 *
 */

public class AddClassCourse {
	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.167.68/icheck_sziit", "root",
					"wamqy1");

			//给班级建立班级账户，class_id,作为user_id
			Statement stat1 = conn.createStatement();
			ResultSet rst1 = stat1.executeQuery("SELECT  * from average_class");
			int i=999999;//作为班级的账户名
			while(rst1.next()){
				String college=rst1.getString("college");
				String major=rst1.getString("major");
				String grade=rst1.getString("grade");
				String classes=rst1.getString("class_id");
				String classnum=rst1.getString("class");

				
				
				String sql = "insert into teacher(user_id,user_type,student_teacher_id,real_name)values(?,?,?,?)";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1,classes);
				prep.setString(2, "班级"); //这个人添加了请假条
				prep.setString(3, String.valueOf(i));
				prep.setString(4,  college + " "+ grade +"级 " + major+" " + classnum + "班" );
				prep.executeUpdate();
				i=i+1;
			}
			
			
			//给每个班级天界课程
			Statement stat = conn.createStatement();
			ResultSet rst = stat
					.executeQuery("SELECT  * from average_class NATURAL join user LEFT JOIN student_course on user.user_id=student_course.user_id  where student_course.course_id<3007 GROUP BY course_id");

			while (rst.next()) {
					String college=rst.getString("college");
					String major=rst.getString("major");
					String grade=rst.getString("grade");
					String classes=rst.getString("class_id");
					String classnum=rst.getString("class");
					String courseid=rst.getString("course_id");
					String sql1 = "insert into class_course(user_id,course_id)values(?,?)";
					
					PreparedStatement prep1 = conn.prepareStatement(sql1);
					prep1.setString(1,classes);
					prep1.setString(2, courseid); //这个人添加了请假条
					prep1.executeUpdate();
					System.out.println(classnum);
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

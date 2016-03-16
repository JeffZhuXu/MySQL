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
 * ��sziitÿ���༶���һ���༶�˻�
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

			//���༶�����༶�˻���class_id,��Ϊuser_id
			Statement stat1 = conn.createStatement();
			ResultSet rst1 = stat1.executeQuery("SELECT  * from average_class");
			int i=999999;//��Ϊ�༶���˻���
			while(rst1.next()){
				String college=rst1.getString("college");
				String major=rst1.getString("major");
				String grade=rst1.getString("grade");
				String classes=rst1.getString("class_id");
				String classnum=rst1.getString("class");

				
				
				String sql = "insert into teacher(user_id,user_type,student_teacher_id,real_name)values(?,?,?,?)";
				PreparedStatement prep = conn.prepareStatement(sql);
				prep.setString(1,classes);
				prep.setString(2, "�༶"); //���������������
				prep.setString(3, String.valueOf(i));
				prep.setString(4,  college + " "+ grade +"�� " + major+" " + classnum + "��" );
				prep.executeUpdate();
				i=i+1;
			}
			
			
			//��ÿ���༶���γ�
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
					prep1.setString(2, courseid); //���������������
					prep1.executeUpdate();
					System.out.println(classnum);
		}

			//�ر����ݿ�����
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

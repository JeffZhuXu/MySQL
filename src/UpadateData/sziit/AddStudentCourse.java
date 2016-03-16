package UpadateData.sziit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.json.*;
public class AddStudentCourse {

	 public static void main(String[] args)  {

		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.64.106:3306/icheck_sziit1","administrator", "yisinian123456");
				
					Statement stat = conn.createStatement();
					//�ҵ�course_id,�Լ���Ӧ��ѧ�����꼶��Ժϵ��רҵ�Ͱ༶����������ѧ��
					ResultSet rst = stat.executeQuery("select course_id,grade,college,major,class from course,course_teacher_student where course.course_number=course_teacher_student.course_number and course.course_introduction = course_teacher_student.introduction");
					
					while(rst.next()){

						String courseid= rst.getString("course_id");
						String grade= rst.getString("grade");
						String college= rst.getString("college");
						String major= rst.getString("major");
						String classnum= rst.getString("class");
						
						System.out.println(courseid);
						System.out.println(grade);
						System.out.println(college);
						System.out.println(major);
						System.out.println(classnum);
						
						Statement stat1 = conn.createStatement();
						
						//�����ҵ���������Ϣ�������ѧ��
						ResultSet rst2 = stat1.executeQuery("select user_id from user WHERE " +
								"grade ='"+grade+"' and " +
								"college='"+college+"' and " +
								"major='"+major+"' and " +
								"class='"+classnum+"'");
						
						while(rst2.next()){
							String userid = rst2.getString("user_id");
							
							System.out.println(userid);
							//��ѧ���Ϳγ̵Ķ�Ӧ��ϵ���뵽student_course����
							PreparedStatement prep = conn.prepareStatement("insert into student_course(course_id,user_id)VALUES(?,?)");
							prep.setString(1, courseid);
							prep.setString(2, userid);
							prep.executeUpdate();
							
							
						}
						
					}
					
				
				//�ر����ݿ�����
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

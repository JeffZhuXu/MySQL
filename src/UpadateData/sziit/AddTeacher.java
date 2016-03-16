package UpadateData.sziit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import UpadateData.constant.DailyTimes;
import UpadateData.constant.SchoolStartTime;
import UpadateData.tool.CnToSpell1;
import UpadateData.tool.CourseTimeFromWeekDayTimes;



import net.sf.json.JSONObject;

 class DoSomething implements Runnable { 
    private String name; 

    public DoSomething(String name) { 
        this.name = name; 
    } 

    public void run() { 
        for (int i = 0; i < 5; i++) { 
            for (long k = 0; k < 100000000; k++) ; 
            System.out.println(name + ": " + i); 
        } 
    } 
}


public class AddTeacher {

	/**从user表中分离老师用户
	 * @param 朱旭
	 * 2015.5.24
	 */

	public static void main(String[] args)  {

		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/icheck_hlju","root", "wamqy1");
				
				
				String sql = "INSERT into course_time(course_id,course_hours,course_time)values(?,?,?)";
				String sql1 = "INSERT into course_check(course_id,course_time)values(?,?)";
				String sql2 = "INSERT into course_statistic(course_id,course_time)values(?,?)";
					
				for(int i=209;i<218;i++){
					
					for(int j=1;j<51;j++){
						
					PreparedStatement prep = conn.prepareStatement(sql);
					prep.setString(1, String.valueOf(i));
					prep.setString(2, j+"");
					prep.setString(3, "20150904850");
					prep.executeUpdate();
					

					PreparedStatement prep1 = conn.prepareStatement(sql1);
					prep1.setString(1, String.valueOf(i));
					prep1.setString(2, j+"");
					prep1.executeUpdate();
					
					PreparedStatement prep2 = conn.prepareStatement(sql2);
					prep2.setString(1, String.valueOf(i));
					prep2.setString(2, j+"");
					prep2.executeUpdate();
					
					}
				}
				
//				String sql = "INSERT into student_check(user_id,course_time,course_id)VALUES(?,?,?)";
//				PreparedStatement prep = conn.prepareStatement(sql);
//				while (rst.next()){
//					String userid= rst.getString("user_id");
//					for(int i=2;i<6;i++){
//						prep.setString(1, userid);
//						prep.setString(2, i+"");
//						prep.setString(3, 3805+"");
//						prep.executeUpdate();
//					}
//				}
				
				
				
				
				
				
				
//				while (rst.next()){
//					
//					 
//					
//					String courseid= rst.getString("course_id");
//					System.out.println(courseid);
//					
//
//					
//					Statement stat1 = conn.createStatement();
//					stat1.executeUpdate("update course_check set first = '1' where course_id = " + courseid);
//					
//					
//				}
				
//		//添加请假条		
//				ResultSet rst = stat.executeQuery("select user_id,course_id from student_course where course_id>6226");
//				String sql = "INSERT into leave_record(course_id,user_id,course_hours,leave_time_interval,add_time,reason_introduction)VALUES(?,?,?,?,?,?)";
//				PreparedStatement prep = conn.prepareStatement(sql);
//				while (rst.next()){
//					
//					String courseid= rst.getString("course_id");
//					String userid= rst.getString("user_id");
//					System.out.println(courseid);
//					prep.setString(1,courseid);
//					prep.setString(2, userid); //这个人添加了请假条
//					prep.setString(3, 1+"");
//					prep.setString(4, "201509040000-201509100000");
//					prep.setString(5, "2015-07-30-12-41-43");
//					prep.setString(6, "5ZOI5ZOI8J+YhPCfmITwn5iE");
//					prep.executeUpdate();
//					
//				}
				//添加请假条
				
				
				//每个学生找一个老师
//				ResultSet rst = stat.executeQuery("select user_id from user where user_id<4522");
//				while (rst.next()){
//					String userid = rst.getString("user_id");
//			
//					Statement stat1 = conn.createStatement();
//					ResultSet rst1 = stat1.executeQuery(
//							"select user.student_teacher_id,user.user_password,user.real_name,course.course_name,teacher.student_teacher_id,teacher.user_password from teacher NATURAL join course,user LEFT JOIN student_course on user.user_id=student_course.user_id where student_course.course_id=course.course_id and user.user_id= "+userid+ " LIMIT 0,1");
//					
//					while(rst1.next()){
//						String a = rst1.getString("user.student_teacher_id");
//						String b = rst1.getString("user.user_password");
//						String c = rst1.getString("user.real_name");
//						String d = rst1.getString("course.course_name");
//						String e = rst1.getString("teacher.student_teacher_id");
//						String f = rst1.getString("teacher.user_password");
//						
//						System.out.println(a +" "+b +" " + c + " " + d + " " +e + " " + f);
//					}
//
//						
//					
//				}
				
				
				
				//添加学生
//				ResultSet rst = stat.executeQuery("select course_id from course WHERE course_id >6226");
//				
//				while (rst.next()){
//				
//					String courseid= rst.getString("course_id");
//					System.out.println(courseid);
//					String sql = "INSERT into student_course(course_id,user_id)VALUES(?,?)";
//					PreparedStatement prep = conn.prepareStatement(sql);
//					for(int i =4653;i<4712;i=i+2 ){
//						prep.setString(1, courseid);
//						prep.setString(2, i+"");
//						prep.executeUpdate();
//						
//					}
//					
//				}
//				
				
				
				//添加course_time课时信息
//				ResultSet rst = stat.executeQuery("select course_id from course where course_id >6226");
//				
//				while (rst.next()){
//					
//				String courseid= rst.getString("course_id");
//				System.out.println(courseid);
//				
//				String sql = "INSERT into course_time(course_id,course_time,week,day,times)VALUES(?,?,?,?,?)";
//				PreparedStatement prep = conn.prepareStatement(sql);
//				for(int i=1;i<6;i++){
//					prep.setString(1, courseid);
//					prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.SZIIT,
//							SchoolStartTime.SZIIT, '1', '1', i));
//					prep.setString(3, "1");
//					prep.setString(4, "1");
//					prep.setString(5, "" + i);
//					prep.executeUpdate();
//					
//				}
//				} 
//	
				
				//添加课程代码
				
//				String sql = "INSERT into course(course_name,user_id)VALUES(?,?)";
//				PreparedStatement prep = conn.prepareStatement(sql);
//				
//				
//				int k=3811;
//				for(int i = 1;i<31;i++){
//					
//					for(int j=1;j<3;j++){
//					
//					prep.setString(1, "ios测试课程"+i+" "+j);
//					prep.setString(2, k+"");
//					prep.executeUpdate();
//					
//					
//				}
//					k=k+2;
//					
//				}
				
				//添加老师
				
//				String sql = "INSERT into teacher(student_teacher_id,real_name)VALUES(?,?)";
//				PreparedStatement prep = conn.prepareStatement(sql);
//				
//				for(int i = 1;i<31;i++){
//					
//					prep.setString(1, "ios"+i);
//					prep.setString(2, "ios测试老师"+i);
//					prep.executeUpdate();
//					
//				}
				
				//添加学生
				
//				String sql = "INSERT into user(student_teacher_id,real_name)VALUES(?,?)";
//				PreparedStatement prep = conn.prepareStatement(sql);
//				
//				for(int i = 1;i<31;i++){
//					
//					prep.setString(1, "ios"+i);
//					prep.setString(2, "ios测试学生"+i);
//					prep.executeUpdate();
//					
//				}
				
				
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

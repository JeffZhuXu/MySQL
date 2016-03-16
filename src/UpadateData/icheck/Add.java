package UpadateData.icheck;

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


public class Add {

	//通用数据库脚本

	public static void main(String[] args)  {

		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/icheck","root", "wamqy1");
				
				//添加了我是学生课程一起
//				String sql = "INSERT into user(user_id,student_teacher_id,real_name)values(?,?,?)";
//				String sql1 = "INSERT into teacher(user_id,student_teacher_id,real_name)values(?,?,?)";
//				String sql2 = "INSERT into course(course_id,course_name,user_id)values(?,?,?)";
//					
//				for(int i=21;i<=30;i++){
//					
//					
//						
//					PreparedStatement prep = conn.prepareStatement(sql);
//					prep.setString(1, i+"");
//					prep.setString(2, "t"+i);
//					prep.setString(3, "t"+i);
//					prep.executeUpdate();
//					
//
//					PreparedStatement prep1 = conn.prepareStatement(sql1);
//					prep1.setString(1, i+"");
//					prep1.setString(2, "t"+i);
//					prep1.setString(3, "t"+i);
//					prep1.executeUpdate();
//					
//					PreparedStatement prep2 = conn.prepareStatement(sql2);
//					prep2.setString(1, i+"");
//					prep2.setString(2, "t"+i);
//					prep2.setString(3, ""+i);
//					prep2.executeUpdate();
//					
//					
//				}

				//添加课时信息
//				String sql = "INSERT into course_time(course_id,course_hours,week,day,times,course_time)values(?,?,?,?,?,?)";
//				for(int i=1;i<=30;i++){
//					for(int j=1;j<=10;j++){
//						
//						PreparedStatement prep = conn.prepareStatement(sql);
//						prep.setString(1, i+"");
//						prep.setString(2, ""+j);
//						prep.setString(3, "1");
//						prep.setString(4, "1");
//						prep.setString(5, ""+j);
//						prep.setString(6, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.SZIIT, SchoolStartTime.SZIIT, 1,1, j));
//						prep.executeUpdate();
//					}
//				}
				
				//添加课时信息
//				String sql = "INSERT into course_time(course_id,course_hours,week,day,times,course_time)values(?,?,?,?,?,?)";
//				for(int i=1;i<=30;i++){
//					for(int j=1;j<=10;j++){
//						
//						PreparedStatement prep = conn.prepareStatement(sql);
//						prep.setString(1, i+"");
//						prep.setString(2, ""+j);
//						prep.setString(3, "1");
//						prep.setString(4, "1");
//						prep.setString(5, ""+j);
//						prep.setString(6, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.SZIIT, SchoolStartTime.SZIIT, 1,1, j));
//						prep.executeUpdate();
//					}
//				}
				
				
				
				//添加学生
				
				String sql = "INSERT into student_course(course_id,user_id)values(?,?)";
				for(int i=1;i<=30;i++){
//					
						
						PreparedStatement prep = conn.prepareStatement(sql);
						prep.setString(1, i+"");
						prep.setString(2, ""+i);
						prep.executeUpdate();
					
				}
				
				
				
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

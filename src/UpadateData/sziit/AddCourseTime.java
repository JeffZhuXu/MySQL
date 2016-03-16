package UpadateData.sziit;

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

/*course_id	course_num	course_name	identify_code 	weeks	days
	2495	1701017		财务报表分析			1			1,10	11,12

 * 根据上面这种数据列表形式向数据库course_time课程时间表当中添加记录，每一个课时是一条记录
 * 
 * 
 * */


public class AddCourseTime {

	 public static void main(String[] args)  {

		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.64.106:3306/icheck_sziit1","root", "379016635");
				
				Statement stat = conn.createStatement();
				ResultSet rst = stat.executeQuery("select  * from course_time_original");
				String[] daliyTimes=DailyTimes.SZIIT; //sziit每天的课程时间安排
				String startTimes = SchoolStartTime.SZIIT; //sziit的学期开始日期
				while(rst.next()){
					
					String courseId = rst.getString("course_id");  //获取课程ID
					String identifyCode = rst.getString("identify_code"); //获取记录识别码，1表示连续周上课，2表示隔两周上课，3表示单周上课
					List<String> week = GetWeeks.getStartAndEndWeek(rst.getString("week"));
					List<String> dayAndTimes = GetDayAndTime.getDayAndTime(rst.getString("day"));
					System.out.println(courseId);
					System.out.println(identifyCode);
					System.out.println(week);
					System.out.println(dayAndTimes);
					
					//当识别码为1的时候，表示这门课是连续周上课的，中间没有间断
					if(identifyCode.equals("1")){
						
						//从周的开始周次到终止周次，i表示周次
						for(int i=Integer.parseInt(week.get(0));i<Integer.parseInt(week.get(1))+1;i++){
							
							//在这个周里，一共有这么多节课，例如[12,13,56,57]四节课，j表示某一节课
							for(int j=0;j<dayAndTimes.size();j++ ){
								//获取这节课信息 ，例如31表示周三的第一节课
								String datTime = dayAndTimes.get(j);
								
								String day = datTime.substring(0,1);
								String times =datTime.substring(1,2);
								
								String sql = "insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)";
								PreparedStatement prep = conn.prepareStatement(sql);
								prep.setString(1, courseId); //课程id
								prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(daliyTimes,startTimes,i, Integer.parseInt(day), Integer.parseInt(times)));	//根据周星期和当天课次计算出这节课的上课时间
								prep.setString(3, String.valueOf(i)); 
								prep.setString(4, day);  //星期几
								prep.setString(5, times); //当天的第几节课
								prep.executeUpdate();
								
							}
						}
						
					}
					//当识别码是2的时候，表示每隔一周上一节，单周或者是双周
					else if(identifyCode.equals("2")){					
																										
					for(int i=Integer.parseInt(week.get(0));i<Integer.parseInt(week.get(1))+1;i=i+2){  //因为是隔周上课，所以此处+2递增
							
							//在这个周里，一共有这么多节课，例如[12,13,56,57]四节课，j表示某一节课
							for(int j=0;j<dayAndTimes.size();j++ ){
								//获取这节课信息 ，例如31表示周三的第一节课
								String datTime = dayAndTimes.get(j);
								String day = datTime.substring(0,1);
								String times =datTime.substring(1,2);
								
								String sql = "insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)";
								PreparedStatement prep = conn.prepareStatement(sql);
								prep.setString(1, courseId); //课程id
								prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(daliyTimes,startTimes,i, Integer.parseInt(day), Integer.parseInt(times)));	//根据周星期和当天课次计算出这节课的上课时间
								prep.setString(3, String.valueOf(i)); 
								prep.setString(4, day);  //星期几
								prep.setString(5, times); //当天的第几节课
								prep.executeUpdate();
							}
						}
					}
					//识别码是3表示的是单周上课，周的信息为 1,5,6,7,8,15，无序排列的时候，和之前周次递增是不一样的
					else if(identifyCode.equals("3")){	
						//week列表的长度就表示一共有几周
						for(int i=0;i<week.size();i++){
							//在这个周里，一共有这么多节课，例如[12,13,56,57]四节课，j表示某一节课
							for(int j=0;j<dayAndTimes.size();j++ ){
								//获取这节课信息 ，例如31表示周三的第一节课
								String datTime = dayAndTimes.get(j);
								String day = datTime.substring(0,1);
								String times =datTime.substring(1,2);
								
								String sql = "insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)";
								PreparedStatement prep = conn.prepareStatement(sql);
								prep.setString(1, courseId); //课程id
								prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(daliyTimes,startTimes,Integer.parseInt(week.get(i)), Integer.parseInt(day), Integer.parseInt(times)));	//根据周星期和当天课次计算出这节课的上课时间
								prep.setString(3, week.get(i)); //周次
								prep.setString(4, day);  //星期几
								prep.setString(5, times); //当天的第几节课
								prep.executeUpdate();
							}
						}
						
					}
					else{
						System.out.println("输入课程识周信息识别码有误");
					}
					
					
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

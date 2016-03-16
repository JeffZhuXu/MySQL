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
	2495	1701017		���񱨱����			1			1,10	11,12

 * �����������������б���ʽ�����ݿ�course_time�γ�ʱ�������Ӽ�¼��ÿһ����ʱ��һ����¼
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
				String[] daliyTimes=DailyTimes.SZIIT; //sziitÿ��Ŀγ�ʱ�䰲��
				String startTimes = SchoolStartTime.SZIIT; //sziit��ѧ�ڿ�ʼ����
				while(rst.next()){
					
					String courseId = rst.getString("course_id");  //��ȡ�γ�ID
					String identifyCode = rst.getString("identify_code"); //��ȡ��¼ʶ���룬1��ʾ�������ϿΣ�2��ʾ�������ϿΣ�3��ʾ�����Ͽ�
					List<String> week = GetWeeks.getStartAndEndWeek(rst.getString("week"));
					List<String> dayAndTimes = GetDayAndTime.getDayAndTime(rst.getString("day"));
					System.out.println(courseId);
					System.out.println(identifyCode);
					System.out.println(week);
					System.out.println(dayAndTimes);
					
					//��ʶ����Ϊ1��ʱ�򣬱�ʾ���ſ����������Ͽεģ��м�û�м��
					if(identifyCode.equals("1")){
						
						//���ܵĿ�ʼ�ܴε���ֹ�ܴΣ�i��ʾ�ܴ�
						for(int i=Integer.parseInt(week.get(0));i<Integer.parseInt(week.get(1))+1;i++){
							
							//��������һ������ô��ڿΣ�����[12,13,56,57]�ĽڿΣ�j��ʾĳһ�ڿ�
							for(int j=0;j<dayAndTimes.size();j++ ){
								//��ȡ��ڿ���Ϣ ������31��ʾ�����ĵ�һ�ڿ�
								String datTime = dayAndTimes.get(j);
								
								String day = datTime.substring(0,1);
								String times =datTime.substring(1,2);
								
								String sql = "insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)";
								PreparedStatement prep = conn.prepareStatement(sql);
								prep.setString(1, courseId); //�γ�id
								prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(daliyTimes,startTimes,i, Integer.parseInt(day), Integer.parseInt(times)));	//���������ں͵���δμ������ڿε��Ͽ�ʱ��
								prep.setString(3, String.valueOf(i)); 
								prep.setString(4, day);  //���ڼ�
								prep.setString(5, times); //����ĵڼ��ڿ�
								prep.executeUpdate();
								
							}
						}
						
					}
					//��ʶ������2��ʱ�򣬱�ʾÿ��һ����һ�ڣ����ܻ�����˫��
					else if(identifyCode.equals("2")){					
																										
					for(int i=Integer.parseInt(week.get(0));i<Integer.parseInt(week.get(1))+1;i=i+2){  //��Ϊ�Ǹ����ϿΣ����Դ˴�+2����
							
							//��������һ������ô��ڿΣ�����[12,13,56,57]�ĽڿΣ�j��ʾĳһ�ڿ�
							for(int j=0;j<dayAndTimes.size();j++ ){
								//��ȡ��ڿ���Ϣ ������31��ʾ�����ĵ�һ�ڿ�
								String datTime = dayAndTimes.get(j);
								String day = datTime.substring(0,1);
								String times =datTime.substring(1,2);
								
								String sql = "insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)";
								PreparedStatement prep = conn.prepareStatement(sql);
								prep.setString(1, courseId); //�γ�id
								prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(daliyTimes,startTimes,i, Integer.parseInt(day), Integer.parseInt(times)));	//���������ں͵���δμ������ڿε��Ͽ�ʱ��
								prep.setString(3, String.valueOf(i)); 
								prep.setString(4, day);  //���ڼ�
								prep.setString(5, times); //����ĵڼ��ڿ�
								prep.executeUpdate();
							}
						}
					}
					//ʶ������3��ʾ���ǵ����ϿΣ��ܵ���ϢΪ 1,5,6,7,8,15���������е�ʱ�򣬺�֮ǰ�ܴε����ǲ�һ����
					else if(identifyCode.equals("3")){	
						//week�б�ĳ��Ⱦͱ�ʾһ���м���
						for(int i=0;i<week.size();i++){
							//��������һ������ô��ڿΣ�����[12,13,56,57]�ĽڿΣ�j��ʾĳһ�ڿ�
							for(int j=0;j<dayAndTimes.size();j++ ){
								//��ȡ��ڿ���Ϣ ������31��ʾ�����ĵ�һ�ڿ�
								String datTime = dayAndTimes.get(j);
								String day = datTime.substring(0,1);
								String times =datTime.substring(1,2);
								
								String sql = "insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)";
								PreparedStatement prep = conn.prepareStatement(sql);
								prep.setString(1, courseId); //�γ�id
								prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(daliyTimes,startTimes,Integer.parseInt(week.get(i)), Integer.parseInt(day), Integer.parseInt(times)));	//���������ں͵���δμ������ڿε��Ͽ�ʱ��
								prep.setString(3, week.get(i)); //�ܴ�
								prep.setString(4, day);  //���ڼ�
								prep.setString(5, times); //����ĵڼ��ڿ�
								prep.executeUpdate();
							}
						}
						
					}
					else{
						System.out.println("����γ�ʶ����Ϣʶ��������");
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

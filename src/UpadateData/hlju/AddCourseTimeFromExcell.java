package UpadateData.hlju;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import UpadateData.constant.DailyTimes;
import UpadateData.constant.SchoolStartTime;
import UpadateData.tool.CourseTimeFromWeekDayTimes;
/*
 * 2015.8.26
 * zhuxu
 * ��excel����У���ڴ����ݿ������course_time��Ϣ
 * 
 * */
public class AddCourseTimeFromExcell {
	public static void main(String[] args) {
		
		 Connection conn = null;
			
				
		
		
	     try   {
	    	 Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/icheck_hlju","root", "wamqy1");
				
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	            Workbook book  =  Workbook.getWorkbook(new File("d:\\course2.xls"));
	             //  ��õ�һ�����������
	            Sheet sheet  =  book.getSheet(0);
	             //  �õ���һ�е�һ�еĵ�Ԫ��
	            int row=sheet.getRows();
	            int column=sheet.getColumns();
	            System.out.println("������ "+row);
	            System.out.println("������ " + column);
	            
	            for(int i=1;i<row;i++){
	            	
	    	            Cell cell1  =  sheet.getCell(0,i);
	    	            Cell cell2  =  sheet.getCell(3,i);
	    	            String courseid  =  cell1.getContents(); //�γ�id
	    	            String time  =  cell2.getContents();	//�γ��Ͽ�ʱ��
	    	            System.out.println("�γ�id:"+courseid); 
	    	            System.out.println("�γ��Ͽ�ʱ��:"+time); 
	    	            
	    	            

	    	    		String[] b=time.split(","); 
	    	    		int j = 0;
	    	    		for ( j = 0; j < b.length; j++){ 
	    	    	          System.out.println(b[j]); 
	    	    	     if(b[j].indexOf("��")>-1){
	    	    	    	 System.out.println("����");
	    	    	    	 String startweek=selectNumber(b[j]).get(0);  //��ʼ��
	    	    	    	 String endweek=selectNumber(b[j]).get(1);		//������
	    	    	    	 String day =UpadateData.constant.Number.XINGQITOSHUZI.get(b[j].charAt(b[j].indexOf("��")+1)+"");		//���ڼ�
	    	    	    	 String starttime=selectNumber(b[j]).get(2);	//���쿪ʼ����
	    	    	    	 String endtime=selectNumber(b[j]).get(3);		//�����������
	    	    	    	 System.out.println("��ʼ�ܣ�" + startweek);
	    	    	    	 System.out.println("�����ܣ�" + endweek );
	    	    	    	 System.out.println("��ʼ�ڣ�" + starttime);
	    	    	    	 System.out.println("�����ڣ�" + endtime);
	    	    	    	 //ѭ�������
	    	    	    	 for(int q=Integer.parseInt(startweek);q<Integer.parseInt(endweek)+1;q=q+2){
	    	    	    		 //����ڴ�
	    	    	    		 for(int w=Integer.parseInt(starttime);w<Integer.parseInt(endtime)+1;w++){
	    	    	    			 PreparedStatement prep = conn.prepareStatement(
	    	    	 				"insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)");
	    	    						prep.setString(1, courseid);
	    	    						prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.HLJU, SchoolStartTime.HLJU,q,Integer.parseInt(day), w));
	    	    						prep.setString(3, q+"");
	    	    						prep.setString(4, day);
	    	    						prep.setString(5, w+"");
	    	    						prep.executeUpdate();
	    	    	    		 }
	    	    	    		 
	    	    	    	 }
	    	    	    	 
	    	    	     }else if(b[j].indexOf("˫")>-1){
	    	    	    	 System.out.println("˫��");
	    	    	    	 String startweek=selectNumber(b[j]).get(0);  //��ʼ��
	    	    	    	 String endweek=selectNumber(b[j]).get(1);		//������
	    	    	    	 String day =UpadateData.constant.Number.XINGQITOSHUZI.get(b[j].charAt(b[j].indexOf("��")+1)+"");			//���ڼ�
	    	    	    	 String starttime=selectNumber(b[j]).get(2);	//���쿪ʼ����
	    	    	    	 String endtime=selectNumber(b[j]).get(3);		//�����������
	    	    	    	 System.out.println("��ʼ�ܣ�" + startweek);
	    	    	    	 System.out.println("�����ܣ�" + endweek );
	    	    	    	 System.out.println("��ʼ�ڣ�" + starttime);
	    	    	    	 System.out.println("�����ڣ�" + endtime);
	    	    	    	 
	    	    	    	 //ѭ�������
	    	    	    	 for(int q=Integer.parseInt(startweek);q<Integer.parseInt(endweek)+1;q=q+2){
	    	    	    		 //����ڴ�
	    	    	    		 PreparedStatement prep = conn.prepareStatement(
	    	    					"insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)");
	    	    	    		 for(int w=Integer.parseInt(starttime);w<Integer.parseInt(endtime)+1;w++){
	    	    	    				prep.setString(1, courseid);
	    	    						prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.HLJU, SchoolStartTime.HLJU,q,Integer.parseInt(day), w));
	    	    						prep.setString(3, q+"");
	    	    						prep.setString(4, day);
	    	    						prep.setString(5, w+"");
	    	    						prep.executeUpdate();
	    	    	    		 }
	    	    	    		 
	    	    	    	 }
	    	    	    	 
	    	    	     }else{
	    	    	    	 System.out.println("������");
	    	    	    	 String startweek=selectNumber(b[j]).get(0);  //��ʼ��
	    	    	    	 String endweek=selectNumber(b[j]).get(1);		//������
	    	    	    	 String day =UpadateData.constant.Number.XINGQITOSHUZI.get(b[j].charAt(b[j].indexOf("��")+1)+"");			//���ڼ�
	    	    	    	 String starttime=selectNumber(b[j]).get(2);	//���쿪ʼ����
	    	    	    	 String endtime=selectNumber(b[j]).get(3);		//�����������
	    	    	    	 System.out.println("��ʼ�ܣ�" + startweek);
	    	    	    	 System.out.println("�����ܣ�" + endweek );
	    	    	    	 System.out.println("��ʼ�ڣ�" + starttime);
	    	    	    	 System.out.println("�����ڣ�" + endtime);
	    	    	    	 //ѭ�������
	    	    	    	 for(int q=Integer.parseInt(startweek);q<Integer.parseInt(endweek)+1;q++){
	    	    	    		 //����ڴ�
	    	    	    		 for(int w=Integer.parseInt(starttime);w<Integer.parseInt(endtime)+1;w++){
	    	    	    			 PreparedStatement prep = conn.prepareStatement(
	    	    	 				"insert into course_time(course_id,course_time,week,day,times)values(?,?,?,?,?)");
	    	    	    				prep.setString(1, courseid);
	    	    						prep.setString(2, CourseTimeFromWeekDayTimes.getCourseTimeAsString(DailyTimes.HLJU, SchoolStartTime.HLJU,q,Integer.parseInt(day), w));
	    	    						prep.setString(3, q+"");
	    	    						prep.setString(4, day);
	    	    						prep.setString(5, w+"");
	    	    						prep.executeUpdate();
	    	    	    		 }
	    	    	    		 
	    	    	    	 }
	    	    	    	 
	    	    	     }
	    	    		}

	    	            
	    	            
	    	            
	    	            
	    	            
	    	            
	    	            
	    	            
	    	            
	    	            
	            	}
	            
	            
	            //�ر�book
	            book.close();
	        }   catch  (Exception e)  {
	            System.out.println(e);
	        }
	
		
		//String a="1-18��(��) ������ 3-4��,1-18��(��) ������ 5-6��,2-18��(˫) ������ 3-4��";
		
	}
	
	//���ַ�������ֵ
	public static List<String> selectNumber(String txt){
		

		List<String> number =new ArrayList<String>();
		Matcher matcher = Pattern.compile("\\d+").matcher(txt);
		while(matcher.find()){


			number.add(matcher.group());

		}
		return number;
	}
	
	
	
	
   
}

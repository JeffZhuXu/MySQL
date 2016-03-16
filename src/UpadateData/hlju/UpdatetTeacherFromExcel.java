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
 * 2015.9.6
 * zhuxu
 * ��excel����У���ڴ����ݿ��и��¿γ̶�Ӧ����ʦ��Ϣ������
 * 
 * */
public class UpdatetTeacherFromExcel {
	public static void main(String[] args) {
		
		 Connection conn = null;
			
				
		
		
	     try   {
	    	 Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/icheck_hlju","root", "wamqy1");
				
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	            Workbook book  =  Workbook.getWorkbook(new File("d:\\��ʦ�Ϳγ̶�Ӧ��.xls"));
	             //  ��õ�һ�����������
	            Sheet sheet  =  book.getSheet(0);
	             //  �õ���һ�е�һ�еĵ�Ԫ��
	            int row=sheet.getRows();
	            int column=sheet.getColumns();
	            System.out.println("������ "+row);
	            System.out.println("������ " + column);
	            
	            for(int i=944;i<row;i++){
	            	Cell cell1  =  sheet.getCell(2,i);
	            	Cell cell2  =  sheet.getCell(19,i);
	            	Cell cell3  =  sheet.getCell(23,i);
	            	
	            	System.out.println("�γ̴���:"+cell1.getContents());
	            	System.out.println("��ʦ����:"+cell2.getContents());
	            	System.out.println("��ʦ����Ժϵ:"+cell3.getContents());
	            	
	            	Statement stat = conn.createStatement();
	            	stat.executeUpdate("UPDATE course c set user_id=(SELECT user_id from teacher where real_name='"+cell2.getContents()+"' and college='"+cell3.getContents()+"' limit 0,1) where c.course_number='"+cell1.getContents()+"'");
	            	
	            	
	            	
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

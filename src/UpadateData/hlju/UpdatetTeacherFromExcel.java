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
 * 从excel表格中，向黑大数据库中更新课程对应的老师信息，重名
 * 
 * */
public class UpdatetTeacherFromExcel {
	public static void main(String[] args) {
		
		 Connection conn = null;
			
				
		
		
	     try   {
	    	 Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/icheck_hlju","root", "wamqy1");
				
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 
	            Workbook book  =  Workbook.getWorkbook(new File("d:\\老师和课程对应表.xls"));
	             //  获得第一个工作表对象
	            Sheet sheet  =  book.getSheet(0);
	             //  得到第一列第一行的单元格
	            int row=sheet.getRows();
	            int column=sheet.getColumns();
	            System.out.println("行数： "+row);
	            System.out.println("列数： " + column);
	            
	            for(int i=944;i<row;i++){
	            	Cell cell1  =  sheet.getCell(2,i);
	            	Cell cell2  =  sheet.getCell(19,i);
	            	Cell cell3  =  sheet.getCell(23,i);
	            	
	            	System.out.println("课程代码:"+cell1.getContents());
	            	System.out.println("老师姓名:"+cell2.getContents());
	            	System.out.println("老师所在院系:"+cell3.getContents());
	            	
	            	Statement stat = conn.createStatement();
	            	stat.executeUpdate("UPDATE course c set user_id=(SELECT user_id from teacher where real_name='"+cell2.getContents()+"' and college='"+cell3.getContents()+"' limit 0,1) where c.course_number='"+cell1.getContents()+"'");
	            	
	            	
	            	
	            }

   
	            	
	            
	            
	            //关闭book
	            book.close();
	        }   catch  (Exception e)  {
	            System.out.println(e);
	        }
	
		
		//String a="1-18周(单) 星期三 3-4节,1-18周(单) 星期四 5-6节,2-18周(双) 星期三 3-4节";
		
	}
	
	//找字符串中数值
	public static List<String> selectNumber(String txt){
		

		List<String> number =new ArrayList<String>();
		Matcher matcher = Pattern.compile("\\d+").matcher(txt);
		while(matcher.find()){


			number.add(matcher.group());

		}
		return number;
	}
	
	
	
	
   
}

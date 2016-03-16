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
 * 从excel表格中，向黑大数据库中添加course_time信息
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
	             //  获得第一个工作表对象
	            Sheet sheet  =  book.getSheet(0);
	             //  得到第一列第一行的单元格
	            int row=sheet.getRows();
	            int column=sheet.getColumns();
	            System.out.println("行数： "+row);
	            System.out.println("列数： " + column);
	            
	            for(int i=1;i<row;i++){
	            	
	    	            Cell cell1  =  sheet.getCell(0,i);
	    	            Cell cell2  =  sheet.getCell(3,i);
	    	            String courseid  =  cell1.getContents(); //课程id
	    	            String time  =  cell2.getContents();	//课程上课时间
	    	            System.out.println("课程id:"+courseid); 
	    	            System.out.println("课程上课时间:"+time); 
	    	            
	    	            

	    	    		String[] b=time.split(","); 
	    	    		int j = 0;
	    	    		for ( j = 0; j < b.length; j++){ 
	    	    	          System.out.println(b[j]); 
	    	    	     if(b[j].indexOf("单")>-1){
	    	    	    	 System.out.println("单周");
	    	    	    	 String startweek=selectNumber(b[j]).get(0);  //开始周
	    	    	    	 String endweek=selectNumber(b[j]).get(1);		//结束周
	    	    	    	 String day =UpadateData.constant.Number.XINGQITOSHUZI.get(b[j].charAt(b[j].indexOf("期")+1)+"");		//星期几
	    	    	    	 String starttime=selectNumber(b[j]).get(2);	//当天开始节数
	    	    	    	 String endtime=selectNumber(b[j]).get(3);		//当天结束节数
	    	    	    	 System.out.println("开始周：" + startweek);
	    	    	    	 System.out.println("节数周：" + endweek );
	    	    	    	 System.out.println("开始节：" + starttime);
	    	    	    	 System.out.println("结束节：" + endtime);
	    	    	    	 //循环添加周
	    	    	    	 for(int q=Integer.parseInt(startweek);q<Integer.parseInt(endweek)+1;q=q+2){
	    	    	    		 //当天节次
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
	    	    	    	 
	    	    	     }else if(b[j].indexOf("双")>-1){
	    	    	    	 System.out.println("双周");
	    	    	    	 String startweek=selectNumber(b[j]).get(0);  //开始周
	    	    	    	 String endweek=selectNumber(b[j]).get(1);		//结束周
	    	    	    	 String day =UpadateData.constant.Number.XINGQITOSHUZI.get(b[j].charAt(b[j].indexOf("期")+1)+"");			//星期几
	    	    	    	 String starttime=selectNumber(b[j]).get(2);	//当天开始节数
	    	    	    	 String endtime=selectNumber(b[j]).get(3);		//当天结束节数
	    	    	    	 System.out.println("开始周：" + startweek);
	    	    	    	 System.out.println("节数周：" + endweek );
	    	    	    	 System.out.println("开始节：" + starttime);
	    	    	    	 System.out.println("结束节：" + endtime);
	    	    	    	 
	    	    	    	 //循环添加周
	    	    	    	 for(int q=Integer.parseInt(startweek);q<Integer.parseInt(endweek)+1;q=q+2){
	    	    	    		 //当天节次
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
	    	    	    	 System.out.println("连续周");
	    	    	    	 String startweek=selectNumber(b[j]).get(0);  //开始周
	    	    	    	 String endweek=selectNumber(b[j]).get(1);		//结束周
	    	    	    	 String day =UpadateData.constant.Number.XINGQITOSHUZI.get(b[j].charAt(b[j].indexOf("期")+1)+"");			//星期几
	    	    	    	 String starttime=selectNumber(b[j]).get(2);	//当天开始节数
	    	    	    	 String endtime=selectNumber(b[j]).get(3);		//当天结束节数
	    	    	    	 System.out.println("开始周：" + startweek);
	    	    	    	 System.out.println("节数周：" + endweek );
	    	    	    	 System.out.println("开始节：" + starttime);
	    	    	    	 System.out.println("结束节：" + endtime);
	    	    	    	 //循环添加周
	    	    	    	 for(int q=Integer.parseInt(startweek);q<Integer.parseInt(endweek)+1;q++){
	    	    	    		 //当天节次
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

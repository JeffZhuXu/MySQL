package UpadateData.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//通过给定上课的周次，星期几和当天的第几节课，依据校历计算出具体每一节课的上课时间

public class CourseTimeFromWeekDayTimes {
	public static String getCourseTimeAsString(String[] DailyTimes,String SchoolStartTime,int week,int day,int times) throws ParseException{
		//每天十节课对应的开始时间
		String[] courseStartTime =DailyTimes;
		//学期开始日期
        String termStartTime = SchoolStartTime;  
        DateFormat format = new SimpleDateFormat("yyyyMMdd");  

            Date d = format.parse(termStartTime);  
            Calendar c = Calendar.getInstance();  
            c.setTime(d);  
           
            c.add(c.DATE, +((week-1)*7)+day-1);  //计算第几周第几次课的日期
            Date temp_date = c.getTime(); 
            //在日期后面添加上具体的上课点数，形成完整的
            String finalCourseStartTime = format.format(temp_date).toString()+courseStartTime[times-1];
            return finalCourseStartTime;
		
		
		
	}	
}

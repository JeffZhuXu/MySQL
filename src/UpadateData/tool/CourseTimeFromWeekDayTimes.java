package UpadateData.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//ͨ�������Ͽε��ܴΣ����ڼ��͵���ĵڼ��ڿΣ�����У�����������ÿһ�ڿε��Ͽ�ʱ��

public class CourseTimeFromWeekDayTimes {
	public static String getCourseTimeAsString(String[] DailyTimes,String SchoolStartTime,int week,int day,int times) throws ParseException{
		//ÿ��ʮ�ڿζ�Ӧ�Ŀ�ʼʱ��
		String[] courseStartTime =DailyTimes;
		//ѧ�ڿ�ʼ����
        String termStartTime = SchoolStartTime;  
        DateFormat format = new SimpleDateFormat("yyyyMMdd");  

            Date d = format.parse(termStartTime);  
            Calendar c = Calendar.getInstance();  
            c.setTime(d);  
           
            c.add(c.DATE, +((week-1)*7)+day-1);  //����ڼ��ܵڼ��οε�����
            Date temp_date = c.getTime(); 
            //�����ں�������Ͼ�����Ͽε������γ�������
            String finalCourseStartTime = format.format(temp_date).toString()+courseStartTime[times-1];
            return finalCourseStartTime;
		
		
		
	}	
}

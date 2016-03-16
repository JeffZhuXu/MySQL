package UpadateData.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*获取上课星期数和当天的节次，从 “11,12，56,57”，字符串中取出一周内上课的具体课次
 * 上面的表示改门课一周内的上课时间是 周一的1.2两节，周五的6.7两节
 * 
 * 
 * 
 * 
 * 
 * 朱旭 2015.7.17
*/


public class GetDayAndTime {
	public static List<String> getDayAndTime(String Info){
		
		

	    List<String> dayAndTime = new ArrayList<String>();
	    
		Matcher matcher = Pattern.compile("\\d+").matcher(Info);
		while(matcher.find()){


			dayAndTime.add(matcher.group().toString());

		}
		return dayAndTime;
	//将保存的上课的开始周次和结束周次返回
	
}
}

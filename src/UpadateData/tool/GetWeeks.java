package UpadateData.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//获取上课周次，从 “11,12”字符串中取出开始周次11和截止周次12
//朱旭 2015.7.17



public class GetWeeks {
	public static List<String> getStartAndEndWeek(String weekInfo){
		
			

		    List<String> startAndEndWeek = new ArrayList<String>();
		    
			Matcher matcher = Pattern.compile("\\d+").matcher(weekInfo);
			while(matcher.find()){


				startAndEndWeek.add(matcher.group().toString());

			}
			return startAndEndWeek;
		//将保存的上课的开始周次和结束周次返回
		
	}
	

	
}

package UpadateData.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//��ȡ�Ͽ��ܴΣ��� ��11,12���ַ�����ȡ����ʼ�ܴ�11�ͽ�ֹ�ܴ�12
//���� 2015.7.17



public class GetWeeks {
	public static List<String> getStartAndEndWeek(String weekInfo){
		
			

		    List<String> startAndEndWeek = new ArrayList<String>();
		    
			Matcher matcher = Pattern.compile("\\d+").matcher(weekInfo);
			while(matcher.find()){


				startAndEndWeek.add(matcher.group().toString());

			}
			return startAndEndWeek;
		//��������ϿεĿ�ʼ�ܴκͽ����ܴη���
		
	}
	

	
}

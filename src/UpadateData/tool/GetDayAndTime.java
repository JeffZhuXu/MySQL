package UpadateData.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*��ȡ�Ͽ��������͵���ĽڴΣ��� ��11,12��56,57�����ַ�����ȡ��һ�����Ͽεľ���δ�
 * ����ı�ʾ���ſ�һ���ڵ��Ͽ�ʱ���� ��һ��1.2���ڣ������6.7����
 * 
 * 
 * 
 * 
 * 
 * ���� 2015.7.17
*/


public class GetDayAndTime {
	public static List<String> getDayAndTime(String Info){
		
		

	    List<String> dayAndTime = new ArrayList<String>();
	    
		Matcher matcher = Pattern.compile("\\d+").matcher(Info);
		while(matcher.find()){


			dayAndTime.add(matcher.group().toString());

		}
		return dayAndTime;
	//��������ϿεĿ�ʼ�ܴκͽ����ܴη���
	
}
}

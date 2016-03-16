package UpadateData.constant;

import java.util.HashMap;
import java.util.Map;


//大小写数字转换
//2015.5.28
public class Number {
	//小写转大写
	public static final HashMap<String, String> XIAOTODA = new HashMap<String, String>(){
		{
		put("0","零");
		put("1","一");
		put("2","二");
		put("3","三");
		put("4","四");
		put("5","五");
		put("6","六");
		put("7","七");
		put("8","八");
		put("9","九");
		}
	};

	
	//大写转小写
	public static final HashMap<String, String> DAXTOXIAO = new HashMap<String, String>(){
		{
		put("零","0");
		put("一","1");
		put("二","2");
		put("三","3");
		put("四","4");
		put("五","5");
		put("六","6");
		put("七","7");
		put("八","8");
		put("九","9");
		}
	};
	
	//星期转换
	public static final HashMap<String, String> XINGQITOSHUZI = new HashMap<String, String>(){
		{
		
		put("一","1");
		put("二","2");
		put("三","3");
		put("四","4");
		put("五","5");
		put("六","6");
		put("日","7");

		}
	};
	
}

package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//��ȡѧУ�б�����json���鵱��



public class GetAllSchoolsInJson {

	public static void main(String[] args) {
		 Connection conn = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager
				.getConnection("jdbc:mysql://120.24.167.68:3306/yisinian","root", "wamqy1");
				
				Statement stat = conn.createStatement();
				ResultSet rst = stat.executeQuery("select distinct department from schools");
				JsonArray provinces = new JsonArray();  //����json
				
				JsonArray country = new JsonArray();  //ʡ��json
				while (rst.next()){
					String province=rst.getString(1);
					System.out.println( "ʡ��"+province);
					
					JsonObject provincejson = new JsonObject();  //ʡ��json
					JsonArray cities = new JsonArray();  //ʡ��json
					provincejson.addProperty("province", province);
					Statement stat1 = conn.createStatement();
					ResultSet rst1 = stat1.executeQuery("select distinct location from schools where department='"+province+"'");
					while (rst1.next()){
						String city=rst1.getString(1);
						System.out.println("�У�"+city);
						JsonObject cityjson = new JsonObject(); //�е�json
						cityjson.addProperty("city", city);
						Statement stat2 = conn.createStatement();
						ResultSet rst2 = stat2.executeQuery("select distinct school_name from schools where location='"+city+"'");
						JsonArray schools = new JsonArray(); 
						while(rst2.next()){
							String school=rst2.getString(1);
							System.out.println("ѧУ��"+school);
							JsonObject school1=new JsonObject();
							school1.addProperty("school", school);
							schools.add(school1);
						}
						cityjson.add("schoolList", schools);
						
						//System.out.println(cityjson);
						cities.add(cityjson);
					}
					
					provincejson.add("cityList", cities);
					//country.add(provincejson);
					System.out.println(provincejson);
					country.add(provincejson);
				}
				System.out.println(country);
					
	  }   catch  (Exception e)  {
        System.out.println(e);
    }

}
			
	

	
}

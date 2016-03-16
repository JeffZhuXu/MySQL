package UpadateData.tool;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/*2015.12.7
 * ����
 * ���ܣ�ɾ��΢�Ű��Լ�����openID����ѧ����Ϣ
 * ������openid
 * ������	��1��deleteStudentWechatBinding(String openID):ɾ��ѧ��΢�Ű󶨣��޷���ֵ
 * 	  	��2��deletetTeacherWechatBinding(String openID)��ɾ����ʦ΢�Ű󶨣��޷���ֵ
 * 		��3��findStudentWechatBinding(String openID):����ѧ����Ϣ
 * 			����ֵ��String ��ʽ JSONObject  
 * 			{"dbname":"icheck_sziit",				//���ݿ�����
 * 			"schoolNmaeString":"������Ϣְҵ����ѧԺ",		//ѧУ
 * 			"userid":"11",							//ѧ��userID
 * 			"studentTeacherId":"11",				//ѧ��ѧ��
 * 			"userName":"11"}						//ѧ������
 *  	��4��findTeacherWechatBinding(String openID):������ʦ��Ϣ
 * 			����ֵ��String ��ʽ JSONObject  
 * 			{"dbname":"icheck_sziit",				//���ݿ�����
 * 			"schoolNmaeString":"������Ϣְҵ����ѧԺ",		//ѧУ
 * 			"userid":"11",							//��ʦuserID
 * 			"studentTeacherId":"11",				//��ʦ����
 * 			"userName":"11"}						//����
 * 
 * */
public class Wechat {
	//ɾ��ѧ��΢�Ű�
	public static void deletetStudentWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		Connection conn = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����
			Statement stat9 = conn.createStatement();
			//��ѯ�������ݿ�
			ResultSet dbNameResultSet = stat9.executeQuery("SELECT w.db_name,w.openid from wechat_db w  where w.openid ='"+openidString+"' limit 1");
			//ɾ��yisinian��΢�Ű󶨼�¼
			Statement stat10 = conn.createStatement();
			stat10.executeUpdate("delete from wechat_db where openid='"+openidString+"'");  //ɾ��ѧ����yisinian�ж�Ӧ�����ݿ��¼
			while(dbNameResultSet.next()){
				String dbname ="";
				dbname= dbNameResultSet.getString(1); //��ȡ��openid�������ݿ�
				//conn.close();//�ر�����
				//�����ѧ���󶨵����������ݿ�
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("openid���������ݿ�");
					
					//���������������ݿ�
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //���ݿ��û���
							Database.IcheckShenZhen.get("password"));  //���ݿ�����
					conn1.createStatement().executeUpdate("delete from wechat where openid='"+openidString+"'");
					conn1.close();//�ر���������
				//�����ѧ���󶨵��Ǳ������ݿ�
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("openid�ڱ������ݿ�");

					//�������ϱ������ݿ�
					Connection conn2 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //���ݿ��û���
							Database.IcheckBeijing.get("password"));  //���ݿ�����
					conn2.createStatement().executeUpdate("delete from wechat where openid='"+openidString+"'");
					conn2.close();//�رձ�������
					
				}else{
					System.out.println("��openIDδ�����ݿ�");
				}
			
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//ɾ����ʦ΢�Ű�
	public static void deletetTeacherWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		Connection conn = null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����
			Statement stat11 = conn.createStatement();
			//��ѯ�������ݿ�
			ResultSet dbNameResultSet = stat11.executeQuery("SELECT w.db_name,w.openid from wechat_db_teacher w  where w.openid ='"+openidString+"' limit 1");
			//ɾ��yisinian��΢�Ű󶨼�¼
			Statement stat12 = conn.createStatement();
			stat12.executeUpdate("delete from wechat_db_teacher where openid='"+openidString+"'");  //ɾ��ѧ����yisinian�ж�Ӧ�����ݿ��¼
			while(dbNameResultSet.next()){
				String dbname ="";
				dbname= dbNameResultSet.getString(1); //��ȡ��openid�������ݿ�
				//conn.close();//�ر�����
				//�������ʦ�󶨵����������ݿ�
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("openid���������ݿ�");
					//���������������ݿ�
					Connection conn3 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //���ݿ��û���
							Database.IcheckShenZhen.get("password"));  //���ݿ�����
					//ɾ����ʦ��
					conn3.createStatement().executeUpdate("delete from wechat_teacher where openid='"+openidString+"'");
					conn3.close();//�ر���������
				//�������ʦ�󶨵��Ǳ������ݿ�
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("openid�ڱ������ݿ�");

					//�������ϱ������ݿ�
					Connection conn4 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //���ݿ��û���
							Database.IcheckBeijing.get("password"));  //���ݿ�����
					conn4.createStatement().executeUpdate("delete from wechat_teacher where openid='"+openidString+"'");
					conn4.close();//�رձ�������
					
				}else{
					System.out.println("��openIDδ�����ݿ�");
				}
			
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
	//����ѧ��΢�Ű�
	public static String findStudentWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		JSONObject  studebtJsonObject = new JSONObject(); //���ѧ����Ϣ
		
		Connection conn = null;	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����
			Statement stat9 = conn.createStatement();
			//��ѯ�������ݿ�
			ResultSet dbNameResultSet = stat9.executeQuery("SELECT a.db_name,s.school_name from wechat_db a NATURAL join schools s where a.openid='"+openidString+"' limit 1");
			
			
			
			while(dbNameResultSet.next()){
				String dbname ="";
				String schoolNmaeString = "";
				dbname= dbNameResultSet.getString(1); //��ȡ��openid�������ݿ�
				schoolNmaeString = dbNameResultSet.getString(2);//��ȡѧУ����
				studebtJsonObject.put("dbname",dbname);  //���뷵�ص�ѧ����Ϣ��
				studebtJsonObject.put("schoolNmaeString",schoolNmaeString); //���뷵�ص�ѧ����Ϣ��
				//conn.close();//�ر�����
				//�����ѧ���󶨵����������ݿ�
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("ѧ��openid���������ݿ�");
					
					//���������������ݿ�
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //���ݿ��û���
							Database.IcheckShenZhen.get("password"));  //���ݿ�����
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat a LEFT OUTER JOIN user s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
					String userid=studentResultSet.getString(1); //ѧ��userID
					String studentTeacherId =studentResultSet.getString(2);//ѧ��ѧ��
					String studentName=studentResultSet.getString(3);//ѧ������
			
					studebtJsonObject.put("userid",userid);  //���뷵�ص�ѧ����Ϣ��
					studebtJsonObject.put("studentTeacherId",studentTeacherId); //���뷵�ص�ѧ����Ϣ��
					studebtJsonObject.put("studentName",studentName); //���뷵�ص�ѧ����Ϣ��
					break; //����ѭ��
					}
					conn1.close();//�ر���������
				//�����ѧ���󶨵��Ǳ������ݿ�
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("ѧ��openid�ڱ������ݿ�");

					//�������ϱ������ݿ�
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //���ݿ��û���
							Database.IcheckBeijing.get("password"));  //���ݿ�����
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat a LEFT OUTER JOIN user s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
					String userid=studentResultSet.getString(1); //ѧ��userID
					String studentTeacherId = studentResultSet.getString(2);//ѧ��ѧ��
					String studentName =studentResultSet.getString(3);//ѧ������
			
					studebtJsonObject.put("userid",userid);  //���뷵�ص�ѧ����Ϣ��
					studebtJsonObject.put("studentTeacherId",studentTeacherId); //���뷵�ص�ѧ����Ϣ��
					studebtJsonObject.put("studentName",studentName); //���뷵�ص�ѧ����Ϣ��
					break; //����ѭ��
					}
					conn1.close();//�رձ�������
					
				}else{
					System.out.println("��openIDδ�����ݿ�");
				}
			
				System.out.println(studebtJsonObject);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studebtJsonObject.toString(); //���ز��ҵ�����Ϣ
		
	}
	//������ʦ΢�Ű�
	public static String findTeacherWechatBinding(String openID){
		String openidString ="";
		openidString = openID;
		JSONObject  teacherJsonObject = new JSONObject(); //�����ʦ��Ϣ
		
		Connection conn = null;	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					"yisinian", 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����
			Statement stat9 = conn.createStatement();
			//��ѯ�������ݿ�
			ResultSet dbNameResultSet = stat9.executeQuery("SELECT a.db_name,s.school_name from wechat_db_teacher a NATURAL join schools s where a.openid='"+openidString+"' limit 1");
			
			
			
			while(dbNameResultSet.next()){
				String dbname ="";
				String schoolNmaeString = "";
				dbname= dbNameResultSet.getString(1); //��ȡ��openid�������ݿ�
				schoolNmaeString = dbNameResultSet.getString(2);//��ȡѧУ����
				teacherJsonObject.put("dbname",dbname);  //���뷵�ص�ѧ����Ϣ��
				teacherJsonObject.put("schoolNmaeString",schoolNmaeString); //���뷵�ص�ѧ����Ϣ��
				//conn.close();//�ر�����
				//�����ѧ���󶨵����������ݿ�
				if(Database.IcheckShenZhen.get(dbname)=="1"){
					System.out.println("��ʦopenid���������ݿ�");
					
					//���������������ݿ�
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckShenZhen.get("user"),   //���ݿ��û���
							Database.IcheckShenZhen.get("password"));  //���ݿ�����
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat_teacher a LEFT OUTER JOIN teacher s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
					String userid=studentResultSet.getString(1); //��ʦuserID
					String studentTeacherId =studentResultSet.getString(2);//��ʦ����
					String userName =studentResultSet.getString(3);//��ʦ����
			
					teacherJsonObject.put("userid",userid);  //���뷵�ص���ʦ��Ϣ��
					teacherJsonObject.put("studentTeacherId",studentTeacherId); //���뷵�ص���ʦ��Ϣ��
					teacherJsonObject.put("userName",userName); //���뷵�ص���ʦ��Ϣ��
					break; //����ѭ��
					}
					conn1.close();//�ر���������
				//�����ѧ���󶨵��Ǳ������ݿ�
				}else if(Database.IcheckBeijing.get(dbname)=="1"){
					
					System.out.println("��ʦopenid�ڱ������ݿ�");

					//�������ϱ������ݿ�
					Connection conn1 = DriverManager.getConnection(
							"jdbc:mysql://"+
							Database.IcheckBeijing.get("url")+   //���ݿ��ַ
							"/"+
							dbname, 
							Database.IcheckBeijing.get("user"),   //���ݿ��û���
							Database.IcheckBeijing.get("password"));  //���ݿ�����
					ResultSet studentResultSet = conn1.createStatement().executeQuery("SELECT a.user_id,s.student_teacher_id,s.real_name from wechat_teacher a LEFT OUTER JOIN teacher s on a.user_id = s.user_id where a.openid='"+openidString+"' limit 1");
					while(studentResultSet.next()){
						String userid=studentResultSet.getString(1); //��ʦuserID
						String studentTeacherId =studentResultSet.getString(2);//��ʦ����
						String userName = studentResultSet.getString(3);//��ʦ����
				
						teacherJsonObject.put("userid",userid);  //���뷵�ص���ʦ��Ϣ��
						teacherJsonObject.put("studentTeacherId",studentTeacherId); //���뷵�ص���ʦ��Ϣ��
						teacherJsonObject.put("userName",userName); //���뷵�ص���ʦ��Ϣ��
					break; //����ѭ��
					}
					conn1.close();//�رձ�������
					
				}else{
					System.out.println("��openIDδ�����ݿ�");
				}
			
				System.out.println(teacherJsonObject);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return teacherJsonObject.toString(); //���ز��ҵ�����Ϣ
	}
		
	
	public static void main(String[] args) {
		String aString = "oW5nrt4-jlcY6xM3OMlkBVgEF8to";
		findStudentWechatBinding(aString);
		findTeacherWechatBinding(aString);
		
		
		
	}
}

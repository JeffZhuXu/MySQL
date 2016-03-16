package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/*2015.11.29
 * ���е����ݿ���Ϣ,����
 * ��1�����ݿ����ӵ�ַ�Ͷ˿�
 * ��2�����û���������
 * ��3�������ݿ������е�ѧУ����1����ʾ����
 * 
 * */

public class Database {
	
	//icheck��Ŀ������Ӫ������
	public static final HashMap<String, String> IcheckBeijing = new HashMap<String, String>() {
	    {
	        put("url", "123.57.174.243:3306");  //���ݿ��ַ
	        put("user", "root");  //�û���
	        put("password", "wamqy1");  //����
	        put("icheck_gyhebshebgcdx","1");//���������̴�ѧ   ��Ϊ1��ʾ��ѧУ��������ݿ⵱��
	        put("icheck_hnjshnlgdx","1");//��������ѧ
	        put("icheck_hlju","1");//��������ѧ
	        put("icheck_sdqdsqddx","1");//�ൺ��ѧ
	        put("icheck_hlqqhesqqhedx","1");//���������ѧ
	        
	    }
	};
	//icheck��Ŀ������Ӫ������
	public static final HashMap<String, String> IcheckShenZhen = new HashMap<String, String>() {
	    {
	        put("url", "120.24.167.68:3306");  //���ݿ��ַ
	        put("user", "root");  //�û���
	        put("password", "wamqy1");  //����
	        put("icheck_hebgydxszysy","1");//��������ҵ��ѧ�����о���Ժ
	        put("icheck_sziit","1");//������Ϣְҵ����ѧԺ
	        put("icheck_gdzqszqxy","1");//����ѧԺ
	        put("icheck_gdssszyjsxy","1");//����ְҵ����ѧԺ
	    }
	};
	//icheck��Ŀ�������ݷ�����
	public static final HashMap<String, String> IcheckBeijingBackup = new HashMap<String, String>() {
	    {
	        put("url", "120.24.64.106:3308");  //���ݿ��ַ
	        put("user", "root");  //�û���
	        put("password", "wamqy1");  //����
	    }
	};
	//icheck��Ŀ���ڱ��ݷ�����
	public static final HashMap<String, String> IcheckShenZhenBackup = new HashMap<String, String>() {
	    {
	        put("url", "120.24.64.106:3306");  //���ݿ��ַ
	        put("user", "root");  //�û���
	        put("password", "379016635");  //����
	    }
	};
	
	//С��������Ŀ������Ӫ������
	public static final HashMap<String, String> XiaoMIShenZhen = new HashMap<String, String>() {
	    {
	        put("url", "120.24.64.106:3306");  //���ݿ��ַ
	        put("user", "root");  //�û���
	        put("password", "wamqy1");  //����
	    }
	};
	
	//yisinian���ݿ�
	 public static Connection getConnectionYisinian() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/yisinian","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	
	//icheckģ�����ݿ�
	 public static Connection getConnectionIcheck() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_open����ע�����ݿ�
	 public static Connection getConnectionIcheck_open() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/open","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	 
	//icheck_hebgydxszysy��������ҵ��ѧ�����о���Ժ���ݿ�
	 public static Connection getConnectionIcheck_hebgydxszysy() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck_hebgydxszysy","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	//icheck_sziit������Ϣְҵ����ѧԺ���ݿ�
	 public static Connection getConnectionIcheck_sziit() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck_sziit","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_gdzqszqxyt����ѧԺ���ݿ�
	 public static Connection getConnectionIcheck_gdzqszqxy() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck_gdzqszqxy","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_gdssszyjsxy����ְҵ����ѧԺ���ݿ�
	 public static Connection getConnectionIcheck_gdssszyjsxy() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck_gdssszyjsxy","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	 
		//icheck_open_zhenzhen���ڹ������ݿ�
	 public static Connection getConnectionIcheck_open_shenzhen() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.167.68:3306/icheck_open_shenzhen","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_hlju��������ѧ���ݿ�
	 public static Connection getConnectionIcheck_hlju() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_hlju","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	 
		//icheck_sdqdsqddx�ൺ��ѧ���ݿ�
	 public static Connection getConnectionIcheck_sdqdsqddx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_sdqdsqddx","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_hlqqhesqqhedx���������ѧ���ݿ�
	 public static Connection getConnectionIcheck_hlqqhesqqhedx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_hlqqhesqqhedx","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_hnjshnlgdx��������ѧ���ݿ�
	 public static Connection getConnectionIcheck_hnjshnlgdx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_hnjshnlgdx","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_gyhebshebgcdx���������̴�ѧ���ݿ�
	 public static Connection getConnectionIcheck_gyhebshebgcdx() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_gyhebshebgcdx","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
		//icheck_gyhebshebgcdx���������̴�ѧ���ݿ�
	 public static Connection getConnectionIcheck_open_beijing() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://123.57.174.243:3306/icheck_open_beijing","root","wamqy1");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	
}

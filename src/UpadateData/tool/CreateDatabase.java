package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/*2015.8.28
 * �������ݿ����ƣ��½����ݿ⣬ͬʱ�����ݿ�ָ���ṹ����
 * ����
 * 
 * */
public class CreateDatabase {
//	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//
//		
//		
//		Connection connection = null;
//		Statement statement = connection.createStatement();
//		try {
//		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//	      String url = "jdbc:mysql://120.24.167.68/aas";
//	      connection = DriverManager.getConnection(url, "root", "wamqy1");
//	      Statement stat = connection.createStatement();
//	      
//	      
//	      
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		
//	}
	
		
		
//	public static void main(String[] args) {
		
//		try {
//			Runtime r = Runtime.getRuntime();
//			String[] cmd = new String[5];
//			
//			cmd[0] = "cmd "; //������
//			cmd[1] = "/c "; //���к�رգ�
//			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
//			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
//			
//			cmd[4] = "mysql -h120.24.167.68 -uroot -pwamqy1 asd < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
//			String Naiveexe = "calc.exe";//windows�Դ�������
//			String line;
//			String space=" ";
//			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
//			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
//			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
//			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
//			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			while((line=br.readLine()) != null){
//				System.out.println(line);
//				//p.waitFor();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	//�½����ݿ�
	public static void main(String[] args) {
		//�����������ͱ���
		
//		createNewDatabaseBeiJing("icheck_sdqdsqddx");
//		createBackupDatabaseBeiJing("icheck_sdqdsqddx");
		
		//���ڷ������ͱ���
		
//		createNewDatabaseShenZhen("icheck_open");
		createBackupDatabaseShenZhen("icheck_open");
		
		
		//���Ѿ��������ݿ�����ϣ��������ݿ�ű�
//		updateDatabaseBeiJing("icheck_hlju");
//		updateBackupDatabaseBeiJing("icheck_hlju");
//		
//		updateDatabaseShenZhen("he");
//		updateBackupDatabaseShenZhen("icheck_hebgydxszysy");
		
	}
	

	public   static void createNewDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.167.68/icheck","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h120.24.167.68 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//���������������ݿ�
	
	public   static void createNewDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://123.57.174.243/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h123.57.174.243 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	
	//���ݷ������������������ݿ�
	
	public   static void createBackupDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3307/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h120.24.7.44 -P 3307 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//���ݷ����������ڣ������ݿ�
	
	public   static void createBackupDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3306/icheck_sziit","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h120.24.7.44 -P 3306 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	
	public   static void updateDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.167.68/icheck","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      //stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h120.24.167.68 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//���������������ݿ�
	
	public   static void updateDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://123.57.174.243/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      //stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h123.57.174.243 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	
	//���ݷ������������������ݿ�
	
	public   static void updateBackupDatabaseBeiJing(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3307/icheck_hlju","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      //stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h120.24.7.44 -P 3307 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
	//���ݷ����������ڣ������ݿ�
	
	public   static void updateBackupDatabaseShenZhen(String databasename){
		
		Connection connection = null;
		
		try {
		
			//�������ݿ�
	      Class.forName("com.mysql.jdbc.Driver");
	      connection = DriverManager
			.getConnection("jdbc:mysql://120.24.7.44:3306/icheck_sziit","root", "wamqy1");
	      Statement stat = connection.createStatement();
	     //�½����ݿ�
	      //stat.executeUpdate("create database "+databasename);
	      
	      //����mysql.exe�ļ���ʼ�����ݿ��ʽ����ʽ������c:/icheck.sql�ļ�����
	      Runtime r = Runtime.getRuntime();
			String[] cmd = new String[5];
			
			cmd[0] = "cmd "; //������
			cmd[1] = "/c "; //���к�رգ�
			cmd[2] = "start "; //������һ������������ָ���ĳ��������(cmd ������)
			cmd[3] = "C:\\Program Files (x86)\\MySQL\\MySQL Server 5.5\\bin"; //Ҫ���е�.exe�����Ŀ¼
			
			cmd[4] = "mysql -h120.24.7.44 -P 3306 -uroot -pwamqy1 "+databasename+" < C:\\icheck.sql";//exe��������Ҫ�Ĳ���
			String Naiveexe = "calc.exe";//windows�Դ�������
			String line;
			String space=" ";
			//Process p = Runtime.getRuntime().exec("cmd /c svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows")); ��ʱ���������̨
			//Process p = Runtime.getRuntime().exec("cmd /c start svm-train.exe -c 32 -g 0.0078125 -v 5 trainset",null,new File("C:\\libsvm\\windows"));��ʱ����dos��������
			Process p = Runtime.getRuntime().exec((cmd[0]+cmd[1]+cmd[4]),null,new File(cmd[3]));
			//Process p = Runtime.getRuntime().exec("calc.exe"); //ֱ�����м�����
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=br.readLine()) != null){
				System.out.println(line);
				//p.waitFor();
			}
	      
	      
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}	
}
	
}

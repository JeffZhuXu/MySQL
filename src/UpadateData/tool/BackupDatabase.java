package UpadateData.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/*2015.12.22
 * ���еı������ݿ���Ϣ,����
 * 
 * */

public class BackupDatabase {
	
	//yisinian���ݿ�
	 public static Connection getConnectionYisinian() {
			Connection conn = null;	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://120.24.7.44:3306/yisinian","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3306/icheck","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3306/icheck_hebgydxszysy","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3306/icheck_sziit","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3306/icheck_gdzqszqxy","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3306/icheck_gdssszyjsxy","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3307/icheck_hlju","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3307/icheck_sdqdsqddx","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3307/icheck_hlqqhesqqhedx","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3307/icheck_hnjshnlgdx","work","147258369");
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
						"jdbc:mysql://120.24.7.44:3307/icheck_gyhebshebgcdx","work","147258369");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//�����ӷ���
				return conn;
			}
	}
	 
	
}

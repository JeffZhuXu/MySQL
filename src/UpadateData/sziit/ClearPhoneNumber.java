package UpadateData.sziit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//�����ֻ��Žű� 2015.8.27
public class ClearPhoneNumber {
	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.167.68/asd", "root",
					"wamqy1");

			Statement stat = conn.createStatement();
			
			stat.executeUpdate("create database ccc");
			stat.executeUpdate("source c:\\icheck.sql");
			
			ResultSet rst = stat.executeQuery("select * from aaa");

			while (rst.next()){
				System.out.println(rst.getString(2));
				}
//			String studentPhoneNumber=""; //ѧ�����ֻ�β�� ����λ
//			String teacherPhoneNumber="";	//��ʦ���ֻ�β�ź���λ
//			stat.executeUpdate("update user set telephone = '0000000000' ,first_log=0,jpush_id='0' where telephone like '%"+studentPhoneNumber+"'");//����ѧ��
//			stat.executeUpdate("update teacher set telephone = '0000000000' ,first_log=0,jpush_id='0' where telephone like '%"+teacherPhoneNumber+"'");//������ʦ
//			
			//�ر����ݿ�����
			conn.close();
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
}

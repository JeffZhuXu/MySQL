/**
 * 
 */
package UpadateData.tool;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

import net.sf.json.JSONObject;

/**
 * @author Atlas
 *����ʱ����ټ�¼״̬�ĳɹ�ʱ
 */
public class ProcessLeaveRecord {
	public static void main(String[] args) {


		//��ȡ��������ڣ���ʽΪ20150629
		Date d1 = new Date();
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyyMMdd");
		String date = format.format(d1);
		
		System.out.println(date);
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.64.106:3306/icheck_sziit", "root",
					"379016635");

			Statement stat = conn.createStatement();
			ResultSet rst = stat
					.executeQuery("select leave_record_id,course_time from leave_record LEFT JOIN course_time using(course_id,course_hours) where results = 'δ����'");

			while (rst.next()) {

				int leaverecordid = rst.getInt("leave_record_id");
				String coursetime = rst.getString("course_time"); //�Ͽε�ʱ���ʽΪ201606290850��ȡǰ��λ20160629�͵�������ڽ��бȶԣ�С�ڵĻ��ͱ�ʾ���볬ʱ
				String coursetime1 = coursetime.substring(0, 8);
				System.out.println("���ID: " + leaverecordid + " ���ʱ�䣺" + coursetime1);
				//������ٵ���һ�ڿε��������С�ڵ�������ڣ���ô��Ϊ�������Ѿ���ʱ��Ŷ�������ݿ��Ӧ��¼��״̬�ɡ�δ������Ϊ����ʱ��
				if((Integer.parseInt(coursetime1))<(Integer.parseInt(date))){
					Statement stat1 = conn.createStatement();
					stat1.executeUpdate("update leave_record set results = '��ʱ' where leave_record_id = " + leaverecordid);

				}

			}

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

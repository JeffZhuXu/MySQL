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
 *将过时的请假记录状态改成过时
 */
public class ProcessLeaveRecord {
	public static void main(String[] args) {


		//获取当天的日期，格式为20150629
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
					.executeQuery("select leave_record_id,course_time from leave_record LEFT JOIN course_time using(course_id,course_hours) where results = '未处理'");

			while (rst.next()) {

				int leaverecordid = rst.getInt("leave_record_id");
				String coursetime = rst.getString("course_time"); //上课的时间格式为201606290850，取前八位20160629和当天的日期进行比对，小于的话就表示申请超时
				String coursetime1 = coursetime.substring(0, 8);
				System.out.println("请假ID: " + leaverecordid + " 请假时间：" + coursetime1);
				//申请请假的那一节课的日期如果小于当天的日期，那么认为该申请已经过时了哦，将数据库对应记录的状态由‘未处理’改为‘过时’
				if((Integer.parseInt(coursetime1))<(Integer.parseInt(date))){
					Statement stat1 = conn.createStatement();
					stat1.executeUpdate("update leave_record set results = '过时' where leave_record_id = " + leaverecordid);

				}

			}

			//关闭数据库连接
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

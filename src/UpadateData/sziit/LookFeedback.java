package UpadateData.sziit;

//�鿴��־Զ�ķ�����¼


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import encryption.Base64;

public class LookFeedback {
	public static void main(String[] args) {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://120.24.167.68/icheck_gdssszyjsxy", "root",
					"wamqy1");

			//��ѯѧ���˷���������
			Statement stat = conn.createStatement();
			ResultSet rst = stat
					.executeQuery(
							"select f.feedback_id,f.version_num,f.type,f.user_id,f.forms,f.content,f.img_path,f.up_time,"+
							"CONCAT('������',u.real_name,' �绰��',u.telephone,' Ժϵ��',u.college,' רҵ��',u.major,' �꼶��',"+
							"u.grade, ' �༶��' ,u.class,' �˻���',u.student_teacher_id,' ���룺',u.user_password)"+
							" from feedback f  natural join user u"+
							" where f.results='�����' and f.type='ѧ����'");
			
			String feedbackid=""; //����id
			String version ="";		//�汾��
			String type ="";		//�˻�����
			String userid="";		//�û�id
			String content="";		//����
			String uptime ="";		//�����ύʱ��
			String results ="";		//����������
			String message="";		//�����߸�����Ϣ
			System.out.println("����Ժѧ���˷�������");
			while (rst.next()) {
				feedbackid = rst.getString(1);
				version=rst.getString(2);
				type=rst.getString(3);
				userid=rst.getString(4);
				content=rst.getString(6);
				content = content;
				uptime=rst.getString(8);
				message=rst.getString(9);
				System.out.println(
						"�汾�ţ�"+version+"\t"+
						"�˻����ͣ�"+type+"\t"+
						"�û�id��"+userid+"  \t"+ 
						"�����ύʱ�䣺"+ uptime+ "\t"+
						"������Ϣ��"+message+ "\t\t\t"+
						"�������ģ�"+Base64.decode(content,"utf8"));
				
			}
			//��ʦ��������
			
			//��ѯѧ���˷���������
			Statement stat1 = conn.createStatement();
			ResultSet rst1 = stat1
					.executeQuery(
							"select f.feedback_id,f.version_num,f.type,f.user_id,f.forms,f.content,f.img_path,f.up_time,"+
							"CONCAT('������',u.real_name,' �绰��',u.telephone,' Ժϵ��',u.college,' רҵ��',u.major,' �꼶��',"+
							"u.grade, ' �༶��' ,u.class,' �˻���',u.student_teacher_id,' ���룺',u.user_password)"+
							" from feedback f  natural join teacher u"+
							" where f.results='�����' and f.type='��ʦ��'");
			System.out.println("\n\n����Ժ��ʦ�˷�������");
			while (rst1.next()) {
				feedbackid = rst1.getString(1);
				version=rst1.getString(2);
				type=rst1.getString(3);
				userid=rst1.getString(4);
				content=rst1.getString(6);
				uptime=rst1.getString(8);
				message=rst1.getString(9);
				System.out.println(
						"�汾�ţ�"+version+"\t"+
						"�˻����ͣ�"+type+"\t"+
						"�û�id��"+userid+"\t"  + 
						"�����ύʱ�䣺"+ uptime+ "\t"+
						"������Ϣ��"+message+ "\t\t\t\t"+
						"�������ģ�"+Base64.decode(content,"utf8"));
				
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

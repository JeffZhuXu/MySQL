package UpadateData;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import UpadateData.tool.Database;

//2016.4.23
//�人���﹤��ѧԺ���ѧ���Ϳγ̶�Ӧ��ϵ
public class icheck_huhanshengwu {
	public static void main(String[] args) throws BiffException, SQLException, IOException {
		addTeacherCourseStudentCourse();
	}
	
	//�Ӹ���Ա�ĵ��ж�ȡ����Ա��Ϣ������������Ա�Ѿ���ϵͳ���У��򲻼��룬������ڣ����¼���
	public static void addStudentCourse() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/�γ���༶��Ӧ��Ϣ��.xls"));
          //  ��õ�һ�����������
         Sheet sheet  =  book.getSheet(0);
          //  �õ���һ�е�һ�еĵ�Ԫ��
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("������ "+row);
         System.out.println("������ " + column);
         
         for(int i=1;i<row;i++){
         	
 	            Cell cell0  =  sheet.getCell(0,i);
 	            Cell cell1  =  sheet.getCell(4,i);
 	            Cell cell2  =  sheet.getCell(5,i);
 	            Cell cell3  =  sheet.getCell(6,i);
 	            Cell cell4  =  sheet.getCell(7,i);
 	          
 	            String courseId=cell0.getContents();
 	            String school=cell1.getContents();
 	            String grade=cell2.getContents();
 	            String major=cell3.getContents();
 	            String classA=cell4.getContents();


 	            System.out.println("�γ�id�� "+courseId+" ѧУ��"+school+" �꼶��"+ grade+" רҵ��"+major+" �༶��"+classA);
 	            String[] classeStrings= classA.split(" ");
 	            for (int j = 0; j < classeStrings.length; j++) {
 	            	 Statement statement=connection.createStatement();
 	            	 statement.execute("" +
 	            	 		"insert into student_course(course_id,user_id) " +
 	            	 		"(SELECT "+courseId+",user_id from user u  where u.school='"+school+"' AND u.grade='"+grade+"' AND u.major='"+major+"' AND u.class='"+classeStrings[j]+"')");
				}
         }
		
		connection.close();
	}
	//����Ա��ɰ༶�˻���������Ա��ӿγ�
	public static void addTeacherCourse() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		
 	          for (int i = 5017900; i < 5017910; i++) {
				Statement statement = connection.createStatement();
				//�ҵ�ÿ�����һ��ѧ��
				ResultSet resultSet=statement.executeQuery("" +
						"select user_id from counselor natural join user where teacher_id="+i+" group by college,major,class,grade");
				while (resultSet.next()) {
					String userId=resultSet.getString(1);
					
					//�ҵ����ѧ�������еĿ�
					Statement statement1 = connection.createStatement();
					ResultSet resultSet1=statement.executeQuery("" +
							"select course_id from student_course where user_id="+userId);
					while (resultSet1.next()) {
						//����ʦ��ӿγ�
						String courseIdString=resultSet1.getString(1);
						PreparedStatement preparedStatement = connection.prepareStatement("" +
								"insert into student_course(course_id,user_id)values(?,?)");
						preparedStatement.setString(1, courseIdString);
						preparedStatement.setString(2, i+"");
						preparedStatement.executeUpdate();
						
					}
				}
 	          }
 	            	 
         
		
		connection.close();
	}
	//����Ա�����������ѧ��
	public static void addTeacherCourseStudentCourse() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
			int courseId = 34228;
 	          for (int i = 5017900; i < 5017910; i++) {
				Statement statement = connection.createStatement();
				//�ҵ�ÿ�����һ��ѧ��
				ResultSet resultSet=statement.executeQuery("" +
						"select user_id from counselor natural join user where teacher_id="+i);
				while (resultSet.next()) {
					String userId=resultSet.getString(1);
						//��ѧ���ӿ�
					Statement statement1 = connection.createStatement();
					ResultSet resultSet2=statement1.executeQuery("select user_id from student_course where course_id="+courseId+" and user_id="+userId);
					if (!(resultSet2.next())) {
						System.out.println("���ѧ��");
						PreparedStatement preparedStatement = connection.prepareStatement("" +
						"insert into student_course(course_id,user_id)values(?,?)");
						preparedStatement.setString(1, courseId+"");
						preparedStatement.setString(2, userId+"");
						preparedStatement.executeUpdate();
						
					}

				}
				courseId++;
 	          }
		connection.close();
	}
}

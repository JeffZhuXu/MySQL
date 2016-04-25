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
//武汉生物工程学院添加学生和课程对应关系
public class icheck_huhanshengwu {
	public static void main(String[] args) throws BiffException, SQLException, IOException {
		addTeacherCourseStudentCourse();
	}
	
	//从辅导员文档中读取辅导员信息，如果这个辅导员已经在系统当中，则不加入，如果不在，则新加入
	public static void addStudentCourse() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/课程与班级对应信息表.xls"));
          //  获得第一个工作表对象
         Sheet sheet  =  book.getSheet(0);
          //  得到第一列第一行的单元格
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("行数： "+row);
         System.out.println("列数： " + column);
         
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


 	            System.out.println("课程id： "+courseId+" 学校："+school+" 年级："+ grade+" 专业："+major+" 班级："+classA);
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
	//辅导员变成班级账户，给辅导员添加课程
	public static void addTeacherCourse() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		
 	          for (int i = 5017900; i < 5017910; i++) {
				Statement statement = connection.createStatement();
				//找到每个班的一个学生
				ResultSet resultSet=statement.executeQuery("" +
						"select user_id from counselor natural join user where teacher_id="+i+" group by college,major,class,grade");
				while (resultSet.next()) {
					String userId=resultSet.getString(1);
					
					//找到这个学生的所有的课
					Statement statement1 = connection.createStatement();
					ResultSet resultSet1=statement.executeQuery("" +
							"select course_id from student_course where user_id="+userId);
					while (resultSet1.next()) {
						//给老师添加课程
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
	//辅导员的晚定名课添加学生
	public static void addTeacherCourseStudentCourse() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
			int courseId = 34228;
 	          for (int i = 5017900; i < 5017910; i++) {
				Statement statement = connection.createStatement();
				//找到每个班的一个学生
				ResultSet resultSet=statement.executeQuery("" +
						"select user_id from counselor natural join user where teacher_id="+i);
				while (resultSet.next()) {
					String userId=resultSet.getString(1);
						//给学生加课
					Statement statement1 = connection.createStatement();
					ResultSet resultSet2=statement1.executeQuery("select user_id from student_course where course_id="+courseId+" and user_id="+userId);
					if (!(resultSet2.next())) {
						System.out.println("添加学生");
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

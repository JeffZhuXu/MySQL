package UpadateData.tool;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import UpadateData.tool.Database;

//2016.3.7
//黑大添加辅导员信息和辅导员所在班级信息
public class icheck_hlju_counselor {
	public static void main(String[] args) throws BiffException, SQLException, IOException {
		
		
		//添加辅导员
//		addCounsellor();
		//addCounsellorClass();
		//deleteExtraClass();
		readExcelFile();
		
	}
	
	//从辅导员文档中读取辅导员信息，如果这个辅导员已经在系统当中，则不加入，如果不在，则新加入
	public static void addCounsellor() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/黑大辅导员.xls"));
          //  获得第一个工作表对象
         Sheet sheet  =  book.getSheet(0);
          //  得到第一列第一行的单元格
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("行数： "+row);
         System.out.println("列数： " + column);
         
         for(int i=1;i<row;i++){
         	
 	            Cell cell0  =  sheet.getCell(9,i);
 	            Cell cell1  =  sheet.getCell(10,i);
 	            String teacherId=cell0.getContents();
 	            String teacherNameString=cell1.getContents();
 	            String userType="辅导员";
 	            System.out.println("老师id： "+teacherId+" 辅导员姓名："+teacherNameString);
 	            Statement statement=connection.createStatement();
 	            ResultSet resultSet=statement.executeQuery("select * from teacher where student_teacher_id = '"+teacherId+"'");
 	            if(resultSet.next()){
 	            	//System.out.println("老师存在");
 	            }else{
 	            	System.out.println("老师不存在");
 	            	PreparedStatement preparedStatement=connection.prepareStatement(
 	            			"insert into teacher(student_teacher_id,real_name,user_type)values(?,?,?)");
 	            	preparedStatement.setString(1, teacherId);
 	            	preparedStatement.setString(2, teacherNameString);
 	            	preparedStatement.setString(3, userType);
 	            	preparedStatement.executeUpdate();
 	            }
         }
		
		connection.close();
	}
	
	//从文档中找到辅导员所带的班级信息，添加到辅导员班级信息表当中
	public static void addCounsellorClass() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/黑大班级.xls"));
          //  获得第一个工作表对象
         Sheet sheet  =  book.getSheet(0);
          //  得到第一列第一行的单元格
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("行数： "+row);
         System.out.println("列数： " + column);
         
         for(int i=1;i<row;i++){
         	
 	            Cell cell0  =  sheet.getCell(7,i);
 	            Cell cell1  =  sheet.getCell(8,i);
 	            Cell cell2  =  sheet.getCell(1,i);
 	            Cell cell3  =  sheet.getCell(3,i);
 	            Cell cell4  =  sheet.getCell(4,i);
 	            Cell cell5  =  sheet.getCell(5,i);
 	            String teacherId=cell0.getContents();
 	            String teacherNameString=cell1.getContents();
 	            String userId="";
 	            String studentId=cell2.getContents();
 	            String college=cell3.getContents();
 	            String grade=cell4.getContents();
 	            String major=cell5.getContents();
 	            String classString=	"";
 	            
 	            Statement statement=connection.createStatement();
 	            ResultSet resultSet=statement.executeQuery("select user_id from teacher where student_teacher_id = '"+teacherId+"'");
 	            if(resultSet.next()){
 	            	userId=resultSet.getString(1);
 	            	  
 	            	 Statement statement1=connection.createStatement();
 	            	 //找学生所在班级
 	            	 ResultSet resultSet1=statement1.executeQuery("select class from user where student_teacher_id = '"+studentId+"'");
 	            	 if(resultSet1.next()){
 	            		classString=resultSet1.getString(1);
 	            		System.out.println("老师id： "+teacherId+" 辅导员姓名："+teacherNameString+" 辅导员user_id："+userId+
 	 	            			  "学生学号："+studentId+" 院系："+college+" 年级："+grade+" 专业："+major+" 班级："+classString);
 	            		PreparedStatement preparedStatement = connection.prepareStatement(
 	            				"insert into counselor(teacher_id,college,major,class,grade)values(?,?,?,?,?)");
 	            		preparedStatement.setString(1, userId);
 	            		preparedStatement.setString(2, college);
 	            		preparedStatement.setString(3, major);
 	            		preparedStatement.setString(4, classString);
 	            		preparedStatement.setString(5, grade);
 	            		preparedStatement.executeUpdate();
 	            	 }
 	          	   
 	            }else{
 	            	System.out.println("老师不存在");
 	            }
         }
		
		connection.close();
	}
	
	//删除多余的辅导员对应课程
	public static void deleteExtraClass() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/aaa.xls"));
          //  获得第一个工作表对象
         Sheet sheet  =  book.getSheet(0);
          //  得到第一列第一行的单元格
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("行数： "+row);
         System.out.println("列数： " + column);
         
         for(int i=1;i<row;i++){
         	
 	            Cell cell0  =  sheet.getCell(1,i);
 	           String counIdString=cell0.getContents();
 	           System.out.println("id:"+counIdString);
 	           Statement statement = connection.createStatement();
 	           statement.execute("delete from counselor where counselor_id='"+counIdString+"'");
         }
		
		connection.close();
	}
	//从文档中找到辅导员所带的班级信息，添加到辅导员班级信息表当中
	public static void readExcelFile() throws SQLException, BiffException, IOException {
		
		Workbook book  =  Workbook.getWorkbook(new File("E:/CSV测试文件.csv"));
          //  获得第一个工作表对象
         Sheet sheet  =  book.getSheet(0);
          //  得到第一列第一行的单元格
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("行数： "+row);
         System.out.println("列数： " + column);
         for(int i=1;i<row;i++){
//         	
// 	            Cell cell0  =  sheet.getCell(7,i);
// 	            Cell cell1  =  sheet.getCell(8,i);
// 	            Cell cell2  =  sheet.getCell(1,i);
// 	            Cell cell3  =  sheet.getCell(3,i);
// 	            Cell cell4  =  sheet.getCell(4,i);
// 	            Cell cell5  =  sheet.getCell(5,i);     
         }
	}
}

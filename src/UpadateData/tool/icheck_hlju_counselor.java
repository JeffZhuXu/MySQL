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
//�ڴ���Ӹ���Ա��Ϣ�͸���Ա���ڰ༶��Ϣ
public class icheck_hlju_counselor {
	public static void main(String[] args) throws BiffException, SQLException, IOException {
		
		
		//��Ӹ���Ա
//		addCounsellor();
		//addCounsellorClass();
		//deleteExtraClass();
		readExcelFile();
		
	}
	
	//�Ӹ���Ա�ĵ��ж�ȡ����Ա��Ϣ������������Ա�Ѿ���ϵͳ���У��򲻼��룬������ڣ����¼���
	public static void addCounsellor() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/�ڴ󸨵�Ա.xls"));
          //  ��õ�һ�����������
         Sheet sheet  =  book.getSheet(0);
          //  �õ���һ�е�һ�еĵ�Ԫ��
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("������ "+row);
         System.out.println("������ " + column);
         
         for(int i=1;i<row;i++){
         	
 	            Cell cell0  =  sheet.getCell(9,i);
 	            Cell cell1  =  sheet.getCell(10,i);
 	            String teacherId=cell0.getContents();
 	            String teacherNameString=cell1.getContents();
 	            String userType="����Ա";
 	            System.out.println("��ʦid�� "+teacherId+" ����Ա������"+teacherNameString);
 	            Statement statement=connection.createStatement();
 	            ResultSet resultSet=statement.executeQuery("select * from teacher where student_teacher_id = '"+teacherId+"'");
 	            if(resultSet.next()){
 	            	//System.out.println("��ʦ����");
 	            }else{
 	            	System.out.println("��ʦ������");
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
	
	//���ĵ����ҵ�����Ա�����İ༶��Ϣ����ӵ�����Ա�༶��Ϣ����
	public static void addCounsellorClass() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/�ڴ�༶.xls"));
          //  ��õ�һ�����������
         Sheet sheet  =  book.getSheet(0);
          //  �õ���һ�е�һ�еĵ�Ԫ��
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("������ "+row);
         System.out.println("������ " + column);
         
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
 	            	 //��ѧ�����ڰ༶
 	            	 ResultSet resultSet1=statement1.executeQuery("select class from user where student_teacher_id = '"+studentId+"'");
 	            	 if(resultSet1.next()){
 	            		classString=resultSet1.getString(1);
 	            		System.out.println("��ʦid�� "+teacherId+" ����Ա������"+teacherNameString+" ����Աuser_id��"+userId+
 	 	            			  "ѧ��ѧ�ţ�"+studentId+" Ժϵ��"+college+" �꼶��"+grade+" רҵ��"+major+" �༶��"+classString);
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
 	            	System.out.println("��ʦ������");
 	            }
         }
		
		connection.close();
	}
	
	//ɾ������ĸ���Ա��Ӧ�γ�
	public static void deleteExtraClass() throws SQLException, BiffException, IOException {
		Connection connection=Database.getConnectionIcheck_open_beijing();
		Workbook book  =  Workbook.getWorkbook(new File("E:/aaa.xls"));
          //  ��õ�һ�����������
         Sheet sheet  =  book.getSheet(0);
          //  �õ���һ�е�һ�еĵ�Ԫ��
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("������ "+row);
         System.out.println("������ " + column);
         
         for(int i=1;i<row;i++){
         	
 	            Cell cell0  =  sheet.getCell(1,i);
 	           String counIdString=cell0.getContents();
 	           System.out.println("id:"+counIdString);
 	           Statement statement = connection.createStatement();
 	           statement.execute("delete from counselor where counselor_id='"+counIdString+"'");
         }
		
		connection.close();
	}
	//���ĵ����ҵ�����Ա�����İ༶��Ϣ����ӵ�����Ա�༶��Ϣ����
	public static void readExcelFile() throws SQLException, BiffException, IOException {
		
		Workbook book  =  Workbook.getWorkbook(new File("E:/CSV�����ļ�.csv"));
          //  ��õ�һ�����������
         Sheet sheet  =  book.getSheet(0);
          //  �õ���һ�е�һ�еĵ�Ԫ��
         int row=sheet.getRows();
         int column=sheet.getColumns();
         System.out.println("������ "+row);
         System.out.println("������ " + column);
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

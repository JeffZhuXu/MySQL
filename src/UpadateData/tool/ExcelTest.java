package UpadateData.tool;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelTest {
	public static void main(String[] args) throws BiffException, IOException, SQLException {

		readExcel();

		}

	//��ȡexcel
	public static void  readExcel() throws BiffException, IOException, SQLException{
		Connection conn = null;
		conn=Database.getConnectionIcheck_open_beijing();
	            Workbook book  =  Workbook.getWorkbook(new File("E:/studen1.xls"));
	             //  ��õ�һ�����������
	            Sheet sheet  =  book.getSheet(0);
	             //  �õ���һ�е�һ�еĵ�Ԫ��
	            int row=sheet.getRows();
	            int column=sheet.getColumns();
	            System.out.println("������ "+row);
	            System.out.println("������ " + column);
	            
	            for(int i=1;i<row;i++){
	            	
	    	            Cell cell0  =  sheet.getCell(0,i);
	    	            Cell cell1  =  sheet.getCell(1,i);
	    	            String courseIdString=cell0.getContents();
	    	            String userIdString=cell1.getContents();
	    	            String userId="";
	    	            Statement statement = conn.createStatement();
	    	            ResultSet resultSet=statement.executeQuery("select user_id from user where student_teacher_id = '"+userIdString+"'");
	    	            while(resultSet.next()){
	    	            	userId=resultSet.getString(1);
	    	            	break;
	    	            }

	    	            System.out.println("course_id:"+courseIdString);
	    	            System.out.println("user_name:"+userIdString);
	    	            System.out.println("user_id:"+userId);
	    	            PreparedStatement preparedStatement = conn.prepareStatement(
	            		"insert into student_course(course_id,user_id)values(?,?)");
	    	            preparedStatement.setString(1, courseIdString);
	    	            preparedStatement.setString(2, userId);
	    	            preparedStatement.execute();
	    	         
	            }
	            
		conn.close();
	}
	//дexcel�ļ�
	public  static void writeExcel(){
		 try   {
             //  ���ļ�
            WritableWorkbook book  =  Workbook.createWorkbook( new  File( "d:/8.xls" ));
             //  ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
            WritableSheet sheet  =  book.createSheet( " ��һҳ " ,  0 );
             //  ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
             //  �Լ���Ԫ������Ϊtest
            Label label  =   new  Label( 0 ,  0 ,  " test " );
 
             //  ������õĵ�Ԫ����ӵ���������
            sheet.addCell(label);
 
             /**/ /*
             * ����һ���������ֵĵ�Ԫ�� ����ʹ��Number��������·�����������﷨���� ��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123
              */
            jxl.write.Number number  =   new  jxl.write.Number( 1 ,  0 ,  555.12541 );
            sheet.addCell(number);
 
             //  д�����ݲ��ر��ļ�
            book.write();
            book.close();
 
        }   catch  (Exception e)  {
            System.out.println(e);
        }
	}
	
	public static void updateExcel(){
        try   {
            //  Excel����ļ�
           Workbook wb  =  Workbook.getWorkbook( new  File("d:/3.xls"));
            //  ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
           WritableWorkbook book  =  Workbook.createWorkbook( new  File("d:/3.xls"),
                   wb);
            //  ���һ��������
           WritableSheet sheet  =  book.createSheet( " �ڶ�ҳ " ,  1 );
           sheet.addCell( new  Label( 0 ,  0 ,  " �ڶ�ҳ�Ĳ������� " ));
           book.write();
           book.close();
       }   catch  (Exception e)  {
           System.out.println(e);
       }
   }
	//���±�
	public static void updateExcelInfo(){
        try   {
            //  Excel����ļ�
           Workbook wb  =  Workbook.getWorkbook( new  File("d:/14������ѧ����Ϣ��.xls"));
            //  ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
           WritableWorkbook book  =  Workbook.createWorkbook( new  File("d:/14������ѧ����Ϣ��.xls"),
                   wb);

          Sheet sheet1  =  wb.getSheet(0);
           //  �õ���һ�е�һ�еĵ�Ԫ��
          int row=sheet1.getRows();
          int column=sheet1.getColumns();
          System.out.println("������ "+row);
          System.out.println("������ " + column);
          
//          for(int i=0;i<row;i++){
//          	for(int j=0;j<column;j++){
//  	            Cell cell1  =  sheet.getCell(j,i);
//  	            String result  =  cell1.getContents();
//  	            System.out.println(result);
//          	}
//          }
          
           
           WritableSheet sheet  =  book.getSheet(0);
           //sheet.addCell( new  Label( 0 ,  0 ,  " �滻�Ĳ������� " ));
         for(int i=1;i<row;i++){
	            Cell cell1  =  sheet.getCell(3,i);
	            String result  =  cell1.getContents();
	            
        	 sheet.addCell( new  Label( 3 ,  i ,  selectBanji(result) ));
     	
     }
           book.write();
           book.close();
       }   catch  (Exception e)  {
           System.out.println(e);
       }
   }
	
	
public static String selectBanji(String txt){
		
		
		String number ="";
		String banji="";
		Matcher matcher = Pattern.compile("��").matcher(txt);
		while(matcher.find()){

			
			number = txt.substring(txt.indexOf("��")-2, txt.indexOf("��"));
			banji=selectNumber(number);


		}
		if(!banji.equals("")){
			return banji;
		}
		return "1";
	}
	
	public static String selectNumber(String txt){
		

		String number ="";
		Matcher matcher = Pattern.compile("\\d+").matcher(txt);
		while(matcher.find()){


			number = number +  matcher.group().toString();

		}
		return number;
	}
}

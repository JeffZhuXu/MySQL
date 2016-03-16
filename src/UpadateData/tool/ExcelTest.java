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

	//读取excel
	public static void  readExcel() throws BiffException, IOException, SQLException{
		Connection conn = null;
		conn=Database.getConnectionIcheck_open_beijing();
	            Workbook book  =  Workbook.getWorkbook(new File("E:/studen1.xls"));
	             //  获得第一个工作表对象
	            Sheet sheet  =  book.getSheet(0);
	             //  得到第一列第一行的单元格
	            int row=sheet.getRows();
	            int column=sheet.getColumns();
	            System.out.println("行数： "+row);
	            System.out.println("列数： " + column);
	            
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
	//写excel文件
	public  static void writeExcel(){
		 try   {
             //  打开文件
            WritableWorkbook book  =  Workbook.createWorkbook( new  File( "d:/8.xls" ));
             //  生成名为“第一页”的工作表，参数0表示这是第一页
            WritableSheet sheet  =  book.createSheet( " 第一页 " ,  0 );
             //  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
             //  以及单元格内容为test
            Label label  =   new  Label( 0 ,  0 ,  " test " );
 
             //  将定义好的单元格添加到工作表中
            sheet.addCell(label);
 
             /**/ /*
             * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
              */
            jxl.write.Number number  =   new  jxl.write.Number( 1 ,  0 ,  555.12541 );
            sheet.addCell(number);
 
             //  写入数据并关闭文件
            book.write();
            book.close();
 
        }   catch  (Exception e)  {
            System.out.println(e);
        }
	}
	
	public static void updateExcel(){
        try   {
            //  Excel获得文件
           Workbook wb  =  Workbook.getWorkbook( new  File("d:/3.xls"));
            //  打开一个文件的副本，并且指定数据写回到原文件
           WritableWorkbook book  =  Workbook.createWorkbook( new  File("d:/3.xls"),
                   wb);
            //  添加一个工作表
           WritableSheet sheet  =  book.createSheet( " 第二页 " ,  1 );
           sheet.addCell( new  Label( 0 ,  0 ,  " 第二页的测试数据 " ));
           book.write();
           book.close();
       }   catch  (Exception e)  {
           System.out.println(e);
       }
   }
	//更新表
	public static void updateExcelInfo(){
        try   {
            //  Excel获得文件
           Workbook wb  =  Workbook.getWorkbook( new  File("d:/14级所有学生信息表.xls"));
            //  打开一个文件的副本，并且指定数据写回到原文件
           WritableWorkbook book  =  Workbook.createWorkbook( new  File("d:/14级所有学生信息表.xls"),
                   wb);

          Sheet sheet1  =  wb.getSheet(0);
           //  得到第一列第一行的单元格
          int row=sheet1.getRows();
          int column=sheet1.getColumns();
          System.out.println("行数： "+row);
          System.out.println("列数： " + column);
          
//          for(int i=0;i<row;i++){
//          	for(int j=0;j<column;j++){
//  	            Cell cell1  =  sheet.getCell(j,i);
//  	            String result  =  cell1.getContents();
//  	            System.out.println(result);
//          	}
//          }
          
           
           WritableSheet sheet  =  book.getSheet(0);
           //sheet.addCell( new  Label( 0 ,  0 ,  " 替换的测试数据 " ));
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
		Matcher matcher = Pattern.compile("班").matcher(txt);
		while(matcher.find()){

			
			number = txt.substring(txt.indexOf("班")-2, txt.indexOf("班"));
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

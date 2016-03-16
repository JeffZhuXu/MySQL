package UpadateData;

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


//测试多线程

public class ThreadTest {

	public static int i=0;


		 public static void main(String[] args)  {
			 
			 Long starttime = System.currentTimeMillis();
			 
			 ExecutorService executor = Executors.newFixedThreadPool(4);  

			 
			
						
							
			Runnable run = new Runnable() {
			@Override
			public void run() {

										
			System.out.println("启动线程");
					                   
			}
					                
			};
							
							
			executor.execute(run);
						
			executor.shutdown();
				
		 }
	

//	public static void main(String[] args)  {
//
//		
//		 Long starttime = System.currentTimeMillis();
//		 
//		 Connection conn = null;
//			try{
//				Class.forName("com.mysql.jdbc.Driver");
//				conn = DriverManager
//				.getConnection("jdbc:mysql://localhost:3306/icheck_sziit","root", "wamqy1");
//				
//				Statement stat = conn.createStatement();
//				
//				
//				String sql ="insert into aaa(name)values(?)";
//				for(int i=2000;i<3000;i++){
//					PreparedStatement prep = conn.prepareStatement(sql);
//					prep.setString(1, ""+i);
//					prep.executeUpdate();
//				}
//				
//				
//				
//				
//				
//				//关闭数据库连接
//				conn.close();
//			}catch (Exception e) { 
//				e.printStackTrace(); 
//				
//				}finally{ 
//					if(conn!=null){ 
//						try { conn.close(); 
//						} catch (SQLException e) {
//							e.printStackTrace();
//							} 
//						} 
//					}
//				Long endtime = System.currentTimeMillis();
//				System.out.println("运行时间：" + (endtime-starttime));
//	 }
}

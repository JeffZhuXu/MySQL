package sqlbackup;

import java.io.File;
import java.util.ArrayList;

public class DeleteBackup {

	//用于保存该目录下面一共有几个文件夹	
	static int num = 0;
	//用于存放所有的文件夹
	static ArrayList folderlist = new ArrayList();
	/**用于定时删除备份数据库文件夹
	 * @param 
	 * 2015.5.26
	 * 朱旭
	 */
	//主函数
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("d:\\db_backup3307");
		recurAllFolders(f);
		System.out.println(num);
		System.out.println(folderlist);
		deleteFolders(folderlist);		
	}
	
	//该方法用于找出所有的文件夹，统计文件夹个数，同时保存所有的文件夹到文件数组当中
	public static void recurAllFolders(File f){
		//当这个目录存在的时候
		if(f.exists()){
			for(File file:f.listFiles()){
				if(file.isDirectory()){
					num = num+1;
					folderlist.add(file.getAbsolutePath());
				}
			
			}
		}
	}
	
	//用于删除多余的文件夹，只保留最新的7个文件夹
	public static void deleteFolders(ArrayList list) {
		
		//备份数据保存一周，每天备份一次，保存记录大于7条的时候，才删除多余的条数
		if(num>7){
		
		
		for(int i =0;i<num-7;i++){
			
			deleteFile(list.get(i).toString());	
		}
		}
	}
	
	//删除文件夹及文件夹下文件
	public static void deleteFile(String path) {  
	    File file = new File(path);  
	    if (file.isDirectory()) {  
	        File[] ff = file.listFiles();  
	        for (int i = 0; i < ff.length; i++) {  
	            deleteFile(ff[i].getPath());  
	        }  
	    }  
	    file.delete();  
	}  
	
}

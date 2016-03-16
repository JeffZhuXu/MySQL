package sqlbackup;

import java.io.File;
import java.util.ArrayList;

public class DeleteBackup {

	//���ڱ����Ŀ¼����һ���м����ļ���	
	static int num = 0;
	//���ڴ�����е��ļ���
	static ArrayList folderlist = new ArrayList();
	/**���ڶ�ʱɾ���������ݿ��ļ���
	 * @param 
	 * 2015.5.26
	 * ����
	 */
	//������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("d:\\db_backup3307");
		recurAllFolders(f);
		System.out.println(num);
		System.out.println(folderlist);
		deleteFolders(folderlist);		
	}
	
	//�÷��������ҳ����е��ļ��У�ͳ���ļ��и�����ͬʱ�������е��ļ��е��ļ����鵱��
	public static void recurAllFolders(File f){
		//�����Ŀ¼���ڵ�ʱ��
		if(f.exists()){
			for(File file:f.listFiles()){
				if(file.isDirectory()){
					num = num+1;
					folderlist.add(file.getAbsolutePath());
				}
			
			}
		}
	}
	
	//����ɾ��������ļ��У�ֻ�������µ�7���ļ���
	public static void deleteFolders(ArrayList list) {
		
		//�������ݱ���һ�ܣ�ÿ�챸��һ�Σ������¼����7����ʱ�򣬲�ɾ�����������
		if(num>7){
		
		
		for(int i =0;i<num-7;i++){
			
			deleteFile(list.get(i).toString());	
		}
		}
	}
	
	//ɾ���ļ��м��ļ������ļ�
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

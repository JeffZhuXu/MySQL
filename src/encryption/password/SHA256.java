package encryption.password;

import java.security.MessageDigest;  
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.awt.Component;  //开始提示
import javax.swing.JOptionPane; //界面
 
class SHACoder {  

    public static String encodeSHA512(byte[] data) throws Exception {  
        // 初始化MessageDigest,SHA即SHA-1的简称  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        // 执行摘要方法  
        byte[] digest = md.digest(data);  
        return new HexBinaryAdapter().marshal(digest);  
    }  
}  

public class SHA256 {  


	public static String enCryption(String a ) {
		String miwen = null;
		try{
    	String testString=a; 
    	 miwen = SHACoder.encodeSHA512(a.getBytes());
    	
		}catch(Exception e){
			e.printStackTrace();
		}
		return miwen;
    }
    
}
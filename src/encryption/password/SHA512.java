package encryption.password;

import java.security.MessageDigest;  
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.awt.Component;  //��ʼ��ʾ
import javax.swing.JOptionPane; //����
 
class SHACoder1 {  

    public static String encodeSHA512(byte[] data) throws Exception {  
        // ��ʼ��MessageDigest,SHA��SHA-1�ļ��  
        MessageDigest md = MessageDigest.getInstance("SHA-512");  
        // ִ��ժҪ����  
        byte[] digest = md.digest(data);  
        return new HexBinaryAdapter().marshal(digest);  
    }  
}  

public class SHA512 {  


	public static String enCryption(String a ) {
		String miwen = null;
		try{
    	String testString=a; 
    	 miwen = SHACoder1.encodeSHA512(a.getBytes());
    	
		}catch(Exception e){
			e.printStackTrace();
		}
		return miwen;
    }
    
}
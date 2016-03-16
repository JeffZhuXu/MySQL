package encryption.password;

import java.util.Random;



public class test1 {
	public static void main(String[] args) throws Exception {
		String  a = "01234567890123456789";
		System.out.println("源码："+ a );
		System.out.println("SHA256密文： " + SHA256.enCryption(a));
		System.out.println("SHA512密文： " + SHA512.enCryption(a));
		System.out.println("MD5密文： " + MD5Util.md5Encode(a));
		System.out.println("SHA1密文： " + SHAUtil.shaEncode(a));
//		70516dda1d564e9133d7753bc111b9e5
//		4538c03323b19b266bfe82a1e61a1b2e
//		GenRndForUKey();
	}
	
	

	 public static String  GenRndForUKey(){
		String strRnd = "";
		String x="123456789poiuytrewqasdfghjklmnbvcxzQWERTYUIPLKJHGFDSAZXCVBNM";
	  for(int i = 0;i < 20; i++) {
		 
	     strRnd = strRnd + x.charAt((int)(1+Math.random()*100000000)%x.length());
	  }
	  System.out.println(strRnd);
	  return strRnd;
	}


}

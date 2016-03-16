package encryption.password;

import java.security.MessageDigest;

/** 
 * ����SHAA����
 * @author Xingxing,Xie
 * @datetime 2014-6-1 
 */
public class SHAUtil {
    /*** 
     * SHA���� ����40λSHA��
     * @param �������ַ���
     * @return ����40λSHA��
     */
    public static String shaEncode(String inStr) throws Exception {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) { 
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * ����������
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("0");
        System.out.println("ԭʼ��" + str);
        System.out.println("SHA��" + shaEncode(str));
    }
}
package sqlbackup;

import java.io.File;


public class PrintHelloWord {

	/**���ڲ���bat�������ļ�ִ�ж��java ��ִ��.jar�ű�
	 * @param ����
	 * 2015.6.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Word!!\n");
		System.out.println("Test!!\n");
		File file = new File("D:\\workspace\\autojar\\"+"HelloWord");
		file.mkdirs();
	}

}

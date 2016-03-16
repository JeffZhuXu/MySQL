package sqlbackup;

import java.io.File;


public class PrintHelloWord {

	/**用于测试bat批处理文件执行多个java 可执行.jar脚本
	 * @param 朱旭
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

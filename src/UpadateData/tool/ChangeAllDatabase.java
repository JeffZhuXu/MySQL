package UpadateData.tool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*2015.11.29
 * ����
 * ����������ݿ���в����ļ����࣬��Ҫ�������¼�������
 * 
 * �޸����ݿ�ṹ
 * ��1���޸�����ѧУ���ݿ�ṹ�������½�ɾ������ӱ������ӡ�ɾ�����ֶ�
 * ��2���޸�ĳһ��ѧУ�����ݿ�ṹ�������½�ɾ������ӱ������ӡ�ɾ�����ֶ�
 * �������
 * ��3����ĳһ�����ݿ���д��ָ����Ϣ
 * ��4�����������ݿ���д��ָ����Ϣ
 * ��ѯ����
 * ��5����ĳһ�����ݿ�ָ����ѯ���
 * ��6�����������ݿ�ִ�в�ѯ���
 * 
 * 
 * */

public class ChangeAllDatabase {
	

	private static final String icheck = "icheck";//ģ�����ݿ�
	private static final String icheck_open = "icheck_open";//icheck����ע�����ݿ�
	private static final String icheck_gyhebshebgcdx = "icheck_gyhebshebgcdx";//���������̴�ѧ
	private static final String icheck_hnjshnlgdx = "icheck_hnjshnlgdx"; //��������ѧ
	private static final String icheck_hlqqhesqqhedx = "icheck_hlqqhesqqhedx"; //���������ѧ
	private static final String icheck_hlju = "icheck_hlju"; //��������ѧ
	private static final String icheck_sdqdsqddx = "icheck_sdqdsqddx"; //�ൺ��ѧ
	private static final String icheck_hebgydxszysy = "icheck_hebgydxszysy"; //��������ҵ��ѧ�����о���Ժ
	private static final String icheck_sziit = "icheck_sziit"; //������Ϣְҵ����ѧԺ
	private static final String icheck_gdzqszqxy = "icheck_gdzqszqxy"; //����ѧԺ
	private static final String icheck_gdssszyjsxy = "icheck_gdssszyjsxy"; //����ְҵ����ѧԺ

	
	//�޸�ģ�����ݿ�ṹ
	public static void changeStructure_icheck(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					icheck, 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����

			Statement stat9 = conn.createStatement();
			System.out.println("icheck�޸ĳɹ�");
			stat9.executeUpdate(sql);//ִ��sql���
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸�icheck����ע�����ݿ�ṹ
	public static void changeStructure_icheck_open(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					icheck_open, 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����

			Statement stat9 = conn.createStatement();
			System.out.println("icheck_open�޸ĳɹ�");
			stat9.executeUpdate(sql);//ִ��sql���
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	//�޸� ���������̴�ѧ �����ݿ�ṹ
	public static void changeStructure_icheck_gyhebshebgcdx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //���ݿ��ַ
					"/"+
					icheck_gyhebshebgcdx, 
					Database.IcheckBeijing.get("user"),   //���ݿ��û���
					Database.IcheckBeijing.get("password"));  //���ݿ�����

			Statement stat1 = conn.createStatement();
			stat1.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_gyhebshebgcdx�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸� ��������ѧ  �����ݿ�ṹ
	public static void changeStructure_icheck_hnjshnlgdx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //���ݿ��ַ
					"/"+
					icheck_hnjshnlgdx, 
					Database.IcheckBeijing.get("user"),   //���ݿ��û���
					Database.IcheckBeijing.get("password"));  //���ݿ�����

			Statement stat2 = conn.createStatement();
			stat2.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_hnjshnlgdx�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//�޸�  ���������ѧ  �����ݿ�ṹ
	public static void changeStructure_icheck_hlqqhesqqhedx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //���ݿ��ַ
					"/"+
					icheck_hlqqhesqqhedx, 
					Database.IcheckBeijing.get("user"),   //���ݿ��û���
					Database.IcheckBeijing.get("password"));  //���ݿ�����

			Statement stat3 = conn.createStatement();
			stat3.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_hlqqhesqqhedx�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸�  ��������ѧ  �����ݿ�ṹ
	public static void changeStructure_icheck_hlju(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //���ݿ��ַ
					"/"+
					icheck_hlju, 
					Database.IcheckBeijing.get("user"),   //���ݿ��û���
					Database.IcheckBeijing.get("password"));  //���ݿ�����

			Statement stat4 = conn.createStatement();
			stat4.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_hlju�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//�޸� �ൺ��ѧ  �����ݿ�ṹ
	public static void changeStructure_icheck_sdqdsqddx(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckBeijing.get("url")+   //���ݿ��ַ
					"/"+
					icheck_sdqdsqddx, 
					Database.IcheckBeijing.get("user"),   //���ݿ��û���
					Database.IcheckBeijing.get("password"));  //���ݿ�����

			Statement stat5 = conn.createStatement();
			stat5.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_sdqdsqddx�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸� ����ѧԺ  �����ݿ�ṹ
	public static void changeStructure_icheck_gdzqszqxy(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					icheck_gdzqszqxy, 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����

			Statement stat6 = conn.createStatement();
			stat6.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_gdzqszqxy�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸� ������Ϣְҵ����ѧԺ  �����ݿ�ṹ
	public static void changeStructure_icheck_sziit(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					icheck_sziit, 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����

			Statement stat7 = conn.createStatement();
			stat7.executeUpdate(sql);//ִ��sql���
			System.out.println("icheck_sziit�޸ĳɹ�");
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸�����ְҵ����ѧԺ  �����ݿ�ṹ
	public static void changeStructure_icheck_gdssszyjsxy(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					icheck_gdssszyjsxy, 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����

			Statement stat8 = conn.createStatement();
			System.out.println("icheck_gdssszyjsxy�޸ĳɹ�");
			stat8.executeUpdate(sql);//ִ��sql���
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	//�޸� ��������ҵ��ѧ�����о���Ժ  �����ݿ�ṹ
	public static void changeStructure_icheck_hebgydxszysy(String sql){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://"+
					Database.IcheckShenZhen.get("url")+   //���ݿ��ַ
					"/"+
					icheck_hebgydxszysy, 
					Database.IcheckShenZhen.get("user"),   //���ݿ��û���
					Database.IcheckShenZhen.get("password"));  //���ݿ�����

			Statement stat9 = conn.createStatement();
			System.out.println("icheck_hebgydxszysy�޸ĳɹ�");
			stat9.executeUpdate(sql);//ִ��sql���
			conn.close();//�ر�����
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	//�޸�����ѧУ���ݿ�Ľṹ
	public static void changeStructureAllDatabase(String sql){
		changeStructure_icheck(sql);
		changeStructure_icheck_gdssszyjsxy(sql);
		changeStructure_icheck_gdzqszqxy(sql);
		changeStructure_icheck_gyhebshebgcdx(sql);
		changeStructure_icheck_hebgydxszysy(sql);
		changeStructure_icheck_hlju(sql);
		changeStructure_icheck_hlqqhesqqhedx(sql);
		changeStructure_icheck_hnjshnlgdx(sql);
		changeStructure_icheck_sdqdsqddx(sql);
		changeStructure_icheck_sziit(sql);
		
	}

	//������
	public static void main(String[] args) {
//		changeStructureAllDatabase("" +
//				"ALTER TABLE `teacher` ADD COLUMN `school`  char(30) NOT NULL DEFAULT 0 COMMENT '��ʦ����ѧУ' AFTER `telephone`;");
		changeStructureAllDatabase("" +
		"ALTER TABLE `average_class` ADD COLUMN `school`  char(30) NOT NULL DEFAULT 0 COMMENT '����ѧУ' AFTER `class_id`");

	} 
	
	
}
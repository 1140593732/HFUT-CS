package Miao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import javax.swing.JOptionPane;


public class DbProcess{
	Connection connection = null;
	public ResultSet rs = null;
	
	
	public Queue<String> list = new LinkedList<String>();
	public Queue<String> list_sum = new LinkedList<String>();
	
	//
	Connection con;// �������ݿ����
  	Statement stmt;// ����SQL�������
	//
	
	//Statement stmt;
	
	//mysql���ݿ�url
	//String userMySql="root"; 
	//String passwordMySql="mzc277171";
	
    String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
    String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";// ����Դ DatabaseName���Ѿ����������ݿ������ ���Ǳ������
	
	
    //String userMySql = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
    //String passwordMySql = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";// ����Դ DatabaseName���Ѿ����������ݿ������ ���Ǳ������
	
	//String urlMySql = "jdbc:mysql://localhost:3306/education?user="+userMySql+"&password="+passwordMySql + "&useUnicode=true&characterEncoding=gbk";
	public DbProcess() {
		
	     try {
	         Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
	     } catch (ClassNotFoundException e) {
	          // e.printStackTrace();
	         System.out.println("�������ݿ�����ʧ��");
	         System.exit(0);
	     }
	      
		
//		try {
//			//mysql���ݿ�����������������
//			Class.forName("com.mysql.jdbc.Driver"); 
//			System.out.println("mysql���ݿ��������سɹ�");
//		}
//		catch(java.lang.ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}


	public void pro_queryAllProcess(){
				
		try {
			if(Login.identify.equals("adminView")) {
				
				String user = "adminView";
				String password = "123456";
				
	        	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
	        	System.out.println("admin�������ݿ�ɹ�,���뵽DbProcess�׶�");
	        	
	        	Statement stmt = con.createStatement();
	        	ResultSet sum = stmt.executeQuery("SELECT * FROM Project where proCK = '1'");
	        	
	        	while (sum.next()) {
		        	  list_sum.add(sum.getString("proCK"));
		        }
	        	
	        	
	        	ResultSet rs = stmt.executeQuery("SELECT * FROM Project");

	        	
	          while (rs.next()) {
	        	  list.add(rs.getString("proNo"));
	        	  list.add(rs.getString("proName"));
	        	  list.add(rs.getString("proCK"));
	        	  list.add(rs.getString("teaNo"));
	          }
	          System.out.println("ȫ����ѯ�������");
			}
			if(Login.identify.equals("���")) {
				
				String user = "���";
				String password = "123456";
				
	        	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
	        	System.out.println("admin�������ݿ�ɹ�,���뵽DbProcess�׶�");
	        	
	        	Statement stmt = con.createStatement();
	        	ResultSet rs = stmt.executeQuery("SELECT * FROM Project");
	        	
	          while (rs.next()) {
	        	  list.add(rs.getString("proNo"));
	        	  list.add(rs.getString("proName"));
	        	  list.add(rs.getString("proCK"));
	        	  list.add(rs.getString("teaNo"));
	          }
	          System.out.println("ȫ����ѯ�������");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void tea_queryAllProcess(){
		
		try {
			if(Login.identify.equals("adminView")) {
				
				String user = "adminView";
				String password = "123456";
				
	        	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
	        	System.out.println("admin�������ݿ�ɹ�,���뵽DbProcess�׶�");
	        	
	        	Statement stmt = con.createStatement();
	        	ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");
	        	
	          while (rs.next()) {
	        	  list.add(rs.getString("teaNo"));
	        	  list.add(rs.getString("teaName"));
	        	  list.add(rs.getString("teaDept"));
	        	  list.add(rs.getString("teaDuty"));
	        	  list.add(rs.getString("teaTitle"));
	        	  list.add(rs.getString("teaGender"));
	          }
	          System.out.println("ȫ����ѯ�������");
			}
			
			if(Login.identify.equals("���")) {
				
				String user = "���";
				String password = "123456";
				
	        	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
	        	System.out.println("admin�������ݿ�ɹ�,���뵽DbProcess�׶�");
	        	
	        	Statement stmt = con.createStatement();
	        	ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");
	        	
	          while (rs.next()) {
	        	  list.add(rs.getString("teaNo"));
	        	  list.add(rs.getString("teaName"));
	        	  list.add(rs.getString("teaDept"));
	        	  list.add(rs.getString("teaDuty"));
	        	  list.add(rs.getString("teaTitle"));
	        	  list.add(rs.getString("teaGender"));
	          }
	          System.out.println("ȫ����ѯ�������");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try{
			if(connection != null){
				connection.close();
				connection = null;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


//	public ResultSet executeQuery(String sql) {
//		try {
//			System.out.println("executeQuery(). sql = " + sql);
//			PreparedStatement pstm = connection.prepareStatement(sql);
//			// ִ�в�ѯ
//			rs = pstm.executeQuery();
//		} 
//		catch(SQLException ex) { 
//			ex.printStackTrace();
//		}
//		return rs;
//	}
	
	//����
	//executeUpdate �ķ���ֵ��һ��������ָʾ��Ӱ��������������¼�������
	//executeUpdate����ִ�� INSERT��UPDATE �� DELETE ���
	//�Լ� SQL DDL�����ݶ������ԣ���䣬���� CREATE TABLE �� DROP TABLE��
	
	//ִ������ɾ�������ķ���
//	public int executeUpdate(String sql) {
//		int count = 0;
//		connect();
//		try {
//			Statement stmt = connection.createStatement();
//			count = stmt.executeUpdate(sql);
//		} 
//		catch(SQLException ex) { 
//			System.err.println(ex.getMessage());		
//		}
//		disconnect();
//		return count;
//	}


public void pro_queryProcess()
{
	String singel_query = scoer.temp_proNo;
	
	try{
		if(Login.identify.equals("adminView")) {
		// ������ѯ����
		String sql = "select * from Project where proNo = ";
		
		sql = sql + "'" + singel_query + "'";

		String user = "adminView";
		String password = "123456";
		
    	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
    	System.out.println("ֻ������Ŀ�š�����ѯ���");
    	
    	Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
        while (rs.next()) {
      	  list.add(rs.getString("proNo"));
      	  list.add(rs.getString("proName"));
      	  list.add(rs.getString("proCK"));
      	  list.add(rs.getString("teaNo"));
        }
        System.out.println("��ȡ���");       

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		}
		else if(Login.identify.equals("���")) {
		// ������ѯ����
		String sql = "select * from Project where proNo = ";
		
		sql = sql + "'" + singel_query + "'";

		String user = "���";
		String password = "123456";
		
    	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
    	System.out.println("ֻ������Ŀ�š�����ѯ���");
    	
    	Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
        while (rs.next()) {
      	  list.add(rs.getString("proNo"));
      	  list.add(rs.getString("proName"));
      	  list.add(rs.getString("proCK"));
      	  list.add(rs.getString("teaNo"));
        }
        System.out.println("��ȡ���");       

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		}
		
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
}

public void tea_queryProcess()
{
	String singel_query = teacher_couse_aet.temp_teaNo;
	
	try{
		if(Login.identify.equals("adminView")) {
		// ������ѯ����
		String sql = "select * from Teacher where teaNo = ";
		
		sql = sql + "'" + singel_query + "'";

		String user = "adminView";
		String password = "123456";
		
    	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
    	System.out.println("ֻ������Ŀ�š�����ѯ���");
    	
    	Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
        while (rs.next()) {
      	  list.add(rs.getString("teaNo"));
      	  list.add(rs.getString("teaName"));
      	  list.add(rs.getString("teaDept"));
      	  list.add(rs.getString("teaDuty"));
      	list.add(rs.getString("teaTitle"));
      	list.add(rs.getString("teaGender"));
        }
        System.out.println("��ȡ���");       

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		}
		
		else if(Login.identify.equals("���")) {
		// ������ѯ����
		String sql = "select * from Teacher where teaNo = ";
		
		sql = sql + "'" + singel_query + "'";

		String user = "���";
		String password = "123456";
		
    	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
    	System.out.println("ֻ������Ŀ�š�����ѯ���");
    	
    	Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
        while (rs.next()) {
      	  list.add(rs.getString("teaNo"));
      	  list.add(rs.getString("teaName"));
      	  list.add(rs.getString("teaDept"));
      	  list.add(rs.getString("teaDuty"));
      	list.add(rs.getString("teaTitle"));
      	list.add(rs.getString("teaGender"));
        }
        System.out.println("��ȡ���");       

		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		}
		
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
}

public void pro_updataProcess() {
	
	String single_proNo = scoer.temp_proNo;
	String single_proCK = scoer.temp_proCK;
	
	try{
		if(Login.identify.equals("adminView")) {
		
			String sql = "update Project set proCK = '";
			sql = sql + single_proCK + "'where proNo = '";
			sql = sql + single_proNo + "'";
			
		String user = "adminView";
		String password = "123456";
		
    	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
    	
    	Statement stmt = con.createStatement();
		
   		int rs = stmt.executeUpdate(sql);
   		//System.out.println("");
   		
//   		while (rs > 0) {
//        	  list.add(rs.getString("proNo"));
//        	  list.add(rs.getString("proName"));
//        	  list.add(rs.getString("proCK"));
//        	  list.add(rs.getString("teaNo"));
//        	  rs--;
//          }
          System.out.println("��Ŀ�������");
          
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		}
		
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
	
}


public void pro_insertProcess() {
	
	String single_proNo = scoer.temp_proNo;
	String single_proName = scoer.temp_proName;
	String single_proCK = scoer.temp_proCK;
	String single_teaNo = scoer.temp_teaNo;
	
	try{
		if(Login.identify.equals("���")) {
		
			String sql = "insert into Project (proNo, proName, proCK, teaNo) values ('";
			sql = sql + single_proNo + "', '";
			sql = sql + single_proName + "', '";
			sql = sql + "0" + "', '";
			sql = sql + single_teaNo + "');";
			
		String user = "���";
		String password = "123456";
		
    	Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
    	
    	Statement stmt = con.createStatement();
		
   		int rs = stmt.executeUpdate(sql);
   		//System.out.println("");
   		
//   		while (rs > 0) {
//        	  list.add(rs.getString("proNo"));
//        	  list.add(rs.getString("proName"));
//        	  list.add(rs.getString("proCK"));
//        	  list.add(rs.getString("teaNo"));
//        	  rs--;
//          }
          System.out.println("��Ŀ�������");
          
		// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
		}
		
	}catch(SQLException sqle){
		System.out.println("sqle = " + sqle);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}catch(Exception e){
		System.out.println("e = " + e);
		JOptionPane.showMessageDialog(null,
			"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
	}
}

}

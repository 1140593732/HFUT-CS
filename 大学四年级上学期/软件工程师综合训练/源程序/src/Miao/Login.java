package Miao;

//���й���ϵͳ��¼ҳ��

import javax.imageio.ImageIO;
import javax.swing.*;

import Miao.Manager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Login extends JFrame implements ActionListener {
	
	// �������
	//String stu_num="adminView";
	//String stu_pwd="123456";
	
	static String identify = "��½�����";
	
	JLabel jLuser = null;//�û�
	JLabel jLpossword = null;//����	
	JLabel jLloging=null;
	
	JTextField jTFuser = null;//����
	JTextField jTFpossword = null;//�Ա�
	
	JButton logings = null;//��¼
	JButton register = null;//��¼
	public  void clear()
  {  
		jTFuser.setText("");
		jTFpossword.setText("");  
  }
	
	// ���캯��
	public Login() {
		// �������	
		jLloging = new JLabel("��У���й���ϵͳ");
		jLloging.setForeground(Color.blue);
		jLloging.setFont(new   java.awt.Font("Dialog",   0,   25));
		
		jLuser = new JLabel("�û�:");
		jLpossword= new JLabel("����:");
		jLuser.setFont(new   java.awt.Font("Dialog",   0,   19));
		jLpossword.setFont(new   java.awt.Font("Dialog",   0,   19));
		
		jTFuser = new JTextField(10);//�û���TextField
		jTFpossword = new JTextField(10);//����TextField
		jTFuser.setFont(new   java.awt.Font("Dialog",   0,   19));
		jTFpossword.setFont(new   java.awt.Font("Dialog",   0,   19));
		
		logings = new JButton("��¼");
		logings.setFont(new   java.awt.Font("Dialog",   1,   16));
		//register = new JButton("ע��");
		//register.setFont(new   java.awt.Font("Dialog",   1,   16));

		JPanel jP1, jP2,jP3,jP4=null;
		JPanel jPTop, jPBottom = null;
		
		// ���ü���
		//logings.addActionListener();
		logings.addActionListener(this);

		jP1 = new JPanel();
		jP2 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
		jP1.add(jLloging);
		
		jP2.add(jLuser);
		jP2.add(jTFuser);
		jP2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP2.setPreferredSize(new Dimension(20,20));
		
		jP3.add(jLpossword);
		jP3.add(jTFpossword);
		jP3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP3.setPreferredSize(new Dimension(20,20));
		
		jP4.add(logings);
		//jP4.add(register);
	
		jP4.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		jPTop.setLayout(new GridLayout(4, 1));
		jPTop.add(jP1);
		jPTop.add(jP2);
		jPTop.add(jP3);
		jPTop.add(jP4);
		
		this.add("North",jP1);
		this.add("Center",jP2);
		this.add("Center",jP3);
		this.add("Center",jP4);
		
		/*
		BufferedImage img=null;
		try {
			img=ImageIO.read(new File("./img/bg.gif"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		JLabel labl=new JLabel(new ImageIcon(img));
		getContentPane().add(labl);
		labl.setBounds(0, 0, img.getWidth(), img.getHeight());
      */
		this.setLayout(new GridLayout(4, 1));
		this.setTitle("��У���й���ϵͳ��¼");
		this.setSize(370,270);
		this.setLocation(555, 225);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		//dbProcess = new DbProcess();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//if(stu_num.equals(jTFuser.getText())&&stu_pwd.equals(jTFpossword.getText()))  
		
		String user = jTFuser.getText();
		String password = jTFpossword.getText();
		
	    String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
	    String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";// ����Դ DatabaseName���Ѿ����������ݿ������ ���Ǳ������
		
		//if((jTFuser.getText()).equals(admin_num) && (jTFpossword.getText()).equals(admin_pwd))
		        //{  
//          		if(user.equals("adminView") && password.equals("123456")) {
//							Connection con = DriverManager.getConnection(connectDB, user, password);
//          				System.out.println("admin�������ݿ�ɹ�");
//          				
//          				
//          				Statement stmt = con.createStatement();// ����SQL�������
//          	          
//          	          // ������
//          	          System.out.println("��ʼ������");
//          	          String query = "create table TABLE1(ID NCHAR(2),NAME NCHAR(10))";// ������SQL���
//          	          stmt.executeUpdate(query);// ִ��SQL�������
//          	          System.out.println("�����ɹ�");
//          				//�����½���  
//          				//new Manager();
//          				//this.setVisible(false);
//		            
//		        }
//	    		try {
	    		//ȷ����¼����admin���ǽ�ʦ
	    			if(jTFuser.getText().equals("adminView") && jTFpossword.getText().equals("123456")) {
	    				identify = "adminView";
	    	        	//Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
	    	        	System.out.println("admin�������ݿ�ɹ�");
						new Manager();
						this.setVisible(false);
						System.out.println("�ɹ�����");
	    	          	//Statement stmt = con.createStatement();// ����SQL�������
	    	          	
	    			}
	    			else if(jTFuser.getText().equals("���") && jTFpossword.getText().equals("123456")) {
	    				identify = "���";
	    	        	//Connection con = DriverManager.getConnection(connectDB, user, password);// �������ݿ����
	    	        	System.out.println("����������ݿ�ɹ�");
						new Manager();
						this.setVisible(false);
						System.out.println("�ɹ�����");
	    	          	//Statement stmt = con.createStatement();// ����SQL�������
	    	          	
	    			}
	          		else if(jTFuser.getText().isEmpty()&&jTFpossword.getText().isEmpty())
			        {  
			            JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
			        }else if(jTFuser.getText().isEmpty())  
			        {  
			            JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
			        }else if(jTFuser.getText().isEmpty())  
			        {  
			            JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
			        }else  
			        {  
			            JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
			            //��������  
			            clear();  
			        } 
	    			
//	    		}
//	    		catch (SQLException e) {
//	              e.printStackTrace();
//	              System.out.println("���ݿ����Ӵ���");
//	              System.exit(0);
//	    		}
	}
}
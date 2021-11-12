package Miao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class scoer extends Panel implements ActionListener {
	// �������
	JLabel jLStudentInfoTable = null;//ѧ����Ϣ��
	JLabel jLSelectQueryField = null;//ѡ���ѯ�ֶ�
	JLabel jLEqual = null;//=
	JLabel jLSNo = null;//ѧ��
	JLabel jLSName = null;//����
	JLabel jLcourse = null;//�γ̺�
	JLabel jLscoer = null;//�ɼ�
	
	JTextField jTFQueryField = null;//��ѯ�ֶ�
	JTextField jTFSNo = null;//ѧ��
	JTextField jTFSName = null;//����
	JTextField jTFcourse = null;//�γ̺�
	JTextField jTFscoer = null;//�ɼ�
	
	//��������ϵ�button
	JButton jBQuery = null;//��ѯ
	JButton jBQueryAll = null;//��ѯ���м�¼
	JButton jBInsert = null;//����
	JButton jBUpdate = null;//����
	JButton jBDeleteCurrentRecord = null;//ɾ����ǰ��¼
	JButton jBDeleteAllRecords = null;//ɾ�����м�¼
	
	//JComboBox jCBSelectQueryField = null;
	//������
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
	JPanel jP1, jP2,jP3,jP4,jP5 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
	private static DbProcess dbProcess;
	
	String SelectQueryFieldStr = "��Ŀ��";
	
	// ���캯��
	public scoer() {
		// �������	
		jLStudentInfoTable = new JLabel("������Ŀ��Ϣ");
		jLSelectQueryField = new JLabel("��ͨ����Ŀ�Ų���");
		jLEqual = new JLabel(" = ");
		jLSNo = new JLabel("��Ŀ��");
		jLSName = new JLabel("��Ŀ��");
	    jLcourse = new JLabel("�������");//�γ̺�
		jLscoer = new JLabel("��ʦ��");;//�ɼ�
		
		jTFQueryField = new JTextField(10);//��ѯ�ֶ�
		jTFSNo = new JTextField(18);//ѧ��
		jTFSName = new JTextField(18);//����
		jTFcourse = new JTextField(18);//�γ̺�
	    jTFscoer = new JTextField(18);//�ɼ�
		
		jBQuery = new JButton("��ѯ");
		jBQueryAll = new JButton("��ѯ���м�¼");
		jBInsert = new JButton("����");
		jBUpdate = new JButton("����");
		jBDeleteCurrentRecord = new JButton("ɾ����ǰ��¼");
		jBDeleteAllRecords = new JButton("ɾ�����м�¼");
		// ���ü���
		jBQuery.addActionListener(this);
		jBQueryAll.addActionListener(this);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		jBDeleteAllRecords.addActionListener(this);
		
		jCBSelectQueryField = new JComboBox<String>();//��ѯ�ֶ�
		jCBSelectQueryField.addItem("��Ŀ��");  
		jCBSelectQueryField.addItem("��Ŀ��");  
		jCBSelectQueryField.addItem("�������");
		jCBSelectQueryField.addItem("��ʦ��");
		
//		jCBSelectQueryField.addItemListener(new ItemListener() {//�������¼�����  
//            public void itemStateChanged(ItemEvent event) {  
//                switch (event.getStateChange()) {  
//                case ItemEvent.SELECTED:  
//                	SelectQueryFieldStr = (String) event.getItem();  
//                    System.out.println("ѡ�У�" + SelectQueryFieldStr);  
//                    break;  
//                case ItemEvent.DESELECTED:  
//                    System.out.println("ȡ��ѡ�У�" + event.getItem());  
//                    break;  
//                }  
//            }  
//        });
	
		studentVector = new Vector();
		titleVector = new Vector();
		
		// �����ͷ
		titleVector.add("��Ŀ��");
		titleVector.add("��Ŀ��");
		titleVector.add("�������");
		titleVector.add("��ʦ��");
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(600,260));
		studentJScrollPane = new JScrollPane(studentJTable);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane.setHorizontalScrollBarPolicy(                
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//Ϊ�����Ӽ����� 
		studentJTable.addMouseListener(new MouseAdapter()
		{ 
			public void mouseClicked(MouseEvent e) 
			{ 
				int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
				System.out.println("mouseClicked(). row = " + row);
				Vector v = new Vector();
				v = (Vector) studentVector.get(row);

				jTFSNo.setText((String) v.get(0));// ѧ��
				jTFSName.setText((String) v.get(1));// ����
				jTFcourse.setText((String) v.get(2));// �γ̺�
				jTFscoer.setText((String) v.get(4));// �ɼ���
			}
		});


		jP1 = new JPanel();
		jP2 = new JPanel();
		jP5 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
		jP2.add(studentJScrollPane);
		
		
		jP3.add(jLSelectQueryField);    //ѡ���ѯ�ֶ�
		//jP3.add(jCBSelectQueryField);   //��ѯ�ֶ�
		//jP3.add(jLEqual);  //=
		jP3.add(jTFQueryField);	
		jP3.add(jBQuery);
		jP3.add(jBQueryAll);
		jP3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP3.setPreferredSize(new Dimension(20,20));
		
		jP4.add(jLSNo);
		jP4.add(jTFSNo);
		jP4.add(jLSName);
		jP4.add(jTFSName);
		jP4.add(jLcourse);
		jP4.add(jTFcourse);
		jP4.add(jLscoer);
		jP4.add(jTFscoer);
		
		jP4.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP4.setPreferredSize(new Dimension(30,30));
		
		
		jP5.add(jBInsert);
		jP5.add(jBUpdate);
		jP5.add(jBDeleteCurrentRecord);
		jP5.add(jBDeleteAllRecords);
		jP5.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP5.setPreferredSize(new Dimension(20,20));
		
		jPTop.add(jP1);
		jPTop.add(jP2);
		
		jPBottom.setLayout(new GridLayout(3, 1));
		jPBottom.add(jP3);
		jPBottom.add(jP4);
		jPBottom.add(jP5);
		this.add("North", jPTop);
		this.add("South", jPBottom);
	
		this.setLayout(new GridLayout(2, 1));
		//this.setTitle("�ɼ���Ϣ����");
		this.setSize(530, 500);
		this.setLocation(150, 150);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
		
		dbProcess = new DbProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��ѯ")  
				&& !jTFQueryField.getText().isEmpty()){
				System.out.println("actionPerformed(). ��ѯ");
				String sQueryField = jTFQueryField.getText().trim();
				queryProcess(sQueryField);
				jTFQueryField.setText("");
			}
		
		else if(e.getActionCommand().equals("��ѯ���м�¼")) {
				System.out.println("actionPerformed(). ��ѯ���м�¼");
				queryAllProcess();
			}
		
		else if(e.getActionCommand().equals("����")
					&& !jTFSNo.getText().isEmpty()
					&& !jTFSName.getText().isEmpty()
					
					&& !jTFscoer.getText().isEmpty()){
				System.out.println("actionPerformed(). ����");
				insertProcess();
			}
		
		else if(e.getActionCommand().equals("����")
					&& !jTFSNo.getText().isEmpty()
					&& !jTFcourse.getText().isEmpty()
					){
				System.out.println("actionPerformed(). ����");
				updateProcess();//����
			}
		
//		else if(e.getActionCommand().equals("ɾ����ǰ��¼")){
//				System.out.println("actionPerformed(). ɾ����ǰ��¼");
//				deleteCurrentRecordProcess();
//			}
		}
	
     /*
	
	public static void main(String[] args) {
		scoer  getcon = new  scoer();
   }

	*/
	
	public static String temp_proNo;
	
	public void queryProcess(String sQueryField)
	{
		temp_proNo = sQueryField;
		
		dbProcess.pro_queryProcess();
		
		studentVector.clear();
		
        while (!dbProcess.list.isEmpty()) {
            
      	  //System.out.print(dbProcess.list.poll());
      	  	Vector v = new Vector();
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				studentVector.add(v);
        }
        
			studentJTable.updateUI();

			dbProcess.disconnect();
	}
	
	public static String sum = "";
	public static String checked = "";
	
	public void queryAllProcess()
	{
		  dbProcess.pro_queryAllProcess();	                 
	          
		  studentVector.clear();
		  
		  sum = dbProcess.list.size() / 4 + "";
		  checked = dbProcess.list_sum.size() + "";
		  dbProcess.list_sum.clear();
		  
		  jTFcourse.setText(checked + "/" + sum);
		  
          while (!dbProcess.list.isEmpty()) {
      
        	  //System.out.print(dbProcess.list.poll());
        	  	Vector v = new Vector();
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				studentVector.add(v);
          }
          //
          studentJTable.updateUI();
          		
          System.out.println("��ȡ���");
          
			dbProcess.disconnect();
	}
	
	//public static String temp_proNo;
	public static String temp_proCK;
	
	public void updateProcess()
	{
		temp_proNo = jTFSNo.getText().trim();
		temp_proCK = jTFcourse.getText().trim();
		
		dbProcess.pro_updataProcess();	
		
		studentVector.clear();
		
      	dbProcess.disconnect();
	}
	
	public static String temp_proName;
	public static String temp_teaNo;
	public void insertProcess()
	{
		System.out.println("׼���걨");
		
		temp_proNo = jTFSNo.getText().trim();
		temp_proName = jTFSName.getText().trim();
		temp_proCK = jTFcourse.getText().trim();
		temp_teaNo = jTFscoer.getText().trim();
		
		dbProcess.pro_insertProcess();	
		
		System.out.println("�걨�ɹ�");
		
		studentVector.clear();
		
      	dbProcess.disconnect();
	}
	
}

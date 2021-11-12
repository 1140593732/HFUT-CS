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
import java.util.Vector;

public class teacher_couse_aet extends Panel implements ActionListener {
	// �������
	JLabel jLStudentInfoTable = null;//ѧ����Ϣ��
	JLabel jLSelectQueryField = null;//ѡ���ѯ�ֶ�
	//JLabel jLEqual = null;//=
	JLabel jLteacher = null;//ѧ��
	JLabel jLScourse = null;//����
	JLabel jLjidian = null;//�༶
	JLabel jLclassroom = null;//�༶
	JLabel jLwe_day = null;//�༶
	JLabel jLclasnumer = null;//�༶

	JTextField jTteacher = null;//��ѯ�ֶ�
	JTextField jTScourse = null;//ѧ��
	JTextField jTjidian = null;//����
	JTextField jTclassroom = null;//�༶
	JTextField jTwe_day = null;//�༶
	JTextField jTclasnumer = null;//�༶
	JTextField jTFQueryField=null;
	
	//��������ϵ�button
	JButton jBQuery = null;//��ѯ
	JButton jBQueryAll = null;//��ѯ���м�¼
	JButton jBInsert = null;//����
	JButton jBUpdate = null;//����
	JButton jBDeleteCurrentRecord = null;//ɾ����ǰ��¼
	//JButton jBDeleteAllRecords = null;//ɾ�����м�¼
	
	//JComboBox jCBSelectQueryField = null;
	//������
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
	JPanel jP1, jP2,jP3,jP4,jP5,jP6 = null;
	JPanel jPTop, jPBottom = null;
	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
	private static DbProcess dbProcess;
	String SelectQueryFieldStr = "ѧ��";
	
	// ���캯��
	public teacher_couse_aet() {
		// �������	
		jLStudentInfoTable = new JLabel("��ʦ��Ϣ");
		jLSelectQueryField = new JLabel("��ͨ����ʦ�Ų�ѯ");
		//jLEqual = new JLabel(" = ");
		jLteacher = new JLabel("��ʦ��");
		jLScourse = new JLabel("��ʦ��");
		jLjidian = new JLabel("����");
		jLclassroom = new JLabel("ְ��");
		jLwe_day = new JLabel("ְ��");
		jLclasnumer = new JLabel("�Ա�");
		
		
		jTteacher = new JTextField(10);//��ѯ�ֶ�
		jTScourse = new JTextField(10);//ѧ��
		jTjidian = new JTextField(10);//����
		jTclassroom = new JTextField(10);//�Ա�
		jTwe_day = new JTextField(10);//�Ա�
		jTclasnumer = new JTextField(10);//�Ա�
		jTFQueryField=new JTextField(10);
		
		jBQuery = new JButton("��ѯ");
		jBQueryAll = new JButton("��ѯ���м�¼");
		jBInsert = new JButton("����");
		jBUpdate = new JButton("����");
		jBDeleteCurrentRecord = new JButton("ɾ����ǰ��¼");
		//jBDeleteAllRecords = new JButton("ɾ�����м�¼");
		// ���ü���
		jBQuery.addActionListener(this);
		jBQueryAll.addActionListener(this);
		jBInsert.addActionListener(this);
		jBUpdate.addActionListener(this);
		jBDeleteCurrentRecord.addActionListener(this);
		//jBDeleteAllRecords.addActionListener(this);
		
		jCBSelectQueryField = new JComboBox<String>();//��ѯ�ֶ�
		jCBSelectQueryField.addItem("��ʦ��");
		jCBSelectQueryField.addItem("��ʦ��");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItem("ְ��");
		jCBSelectQueryField.addItem("ְ��");
		jCBSelectQueryField.addItem("�Ա�");
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
		titleVector.add("��ʦ��");
		titleVector.add("��ʦ��");
		titleVector.add("����");
		titleVector.add("ְ��");
		titleVector.add("ְ��");
		titleVector.add("�Ա�");
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(600,200));
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

				jTteacher.setText((String) v.get(0));// ѧ��
				jTScourse.setText((String) v.get(1));
				jTjidian.setText((String) v.get(2));// ����
				jTclassroom.setText((String) v.get(3));// �༶
				jTwe_day.setText((String) v.get(4));
				jTclasnumer.setText((String) v.get(5));
				
			}
		});


		jP1 = new JPanel();
		jP2 = new JPanel();
		jP5 = new JPanel();
		jP3 = new JPanel();
		jP4 = new JPanel();
		jP5 = new JPanel();
		jP6 = new JPanel();
		
		jPTop = new JPanel();
		jPBottom = new JPanel();
		
		jP1.add(jLStudentInfoTable,BorderLayout.SOUTH);
		jP2.add(studentJScrollPane);
		
		
		jP3.add(jLSelectQueryField);    //ѡ���ѯ�ֶ�
		jP3.add(jCBSelectQueryField);   //��ѯ�ֶ�
		//jP3.add(jLEqual);  //=
		jP3.add(jTFQueryField);	
		jP3.add(jBQuery);
		jP3.add(jBQueryAll);
		jP3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP3.setPreferredSize(new Dimension(20,20));
		
		jP4.add(jLteacher);
		jP4.add(jTteacher);
		jP4.add(jLScourse);
		jP4.add(jTScourse);
		jP4.add(jLjidian);
		jP4.add(jTjidian);
		jP4.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP4.setPreferredSize(new Dimension(30,30));
		jP5.add(jLclassroom);
		jP5.add(jTclassroom);
		jP5.add(jLwe_day);
		jP5.add(jTwe_day);
		jP5.add(jLclasnumer);
		jP5.add(jTclasnumer);
		jP5.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP5.setPreferredSize(new Dimension(20,20));
		
		
		jP6.add(jBInsert);
		jP6.add(jBUpdate);
		jP6.add(jBDeleteCurrentRecord);
		//jP6.add(jBDeleteAllRecords);
		jP6.setLayout(new FlowLayout(FlowLayout.CENTER));
		jP6.setPreferredSize(new Dimension(20,20));
		
		jPTop.add(jP1);
		jPTop.add(jP2);
		
		jPBottom.setLayout(new GridLayout(4, 1));
		jPBottom.add(jP3);
		jPBottom.add(jP4);
		jPBottom.add(jP5);
		jPBottom.add(jP6);
		this.add("North", jPTop);
		this.add("South", jPBottom);
		
	
		
		this.setLayout(new GridLayout(2, 1));
		//this.setTitle("���ҿγ����ñ�");
		this.setSize(580, 500);
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
				System.out.println("actionPerformed().��ѯ");
				String sQueryField = jTFQueryField.getText().trim();
				queryProcess(sQueryField);
				jTFQueryField.setText("");
			}else if(e.getActionCommand().equals("��ѯ���м�¼")) {
				System.out.println("actionPerformed(). ��ѯ���м�¼");
				queryAllProcess();
			}
//			else if(e.getActionCommand().equals("����")
//					&& !jTteacher.getText().isEmpty()
//					&& !jTScourse.getText().isEmpty()
//					&& !jTjidian.getText().isEmpty()
//					&& !jTclassroom.getText().isEmpty()
//					&& !jTwe_day.getText().isEmpty()
//					&& !jTclasnumer.getText().isEmpty()){
//				System.out.println("actionPerformed(). ����");
//				insertProcess();
//			}
		}
	
	
	/*
	public static void main(String[] args) {
		teacher_couse_aet getcon = new  teacher_couse_aet();
   }
   */
	public static String temp_teaNo;
	
	public void queryProcess(String jTFQueryField)
	{
		
		temp_teaNo = jTFQueryField;
		
		dbProcess.tea_queryProcess();
		
		studentVector.clear();
		
        while (!dbProcess.list.isEmpty()) {
            
      	  //System.out.print(dbProcess.list.poll());
      	  	Vector v = new Vector();
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				studentVector.add(v);
        }
        
			studentJTable.updateUI();
			dbProcess.disconnect();
	}
	
	public void queryAllProcess()
	{
		dbProcess.tea_queryAllProcess();	
		
		studentVector.clear();
		  
        while (!dbProcess.list.isEmpty()) {
    
      	  	Vector v = new Vector();
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				v.add(dbProcess.list.poll());
				studentVector.add(v);
        }
        
        studentJTable.updateUI();
        		
        System.out.println("��ȡ���");
        
			dbProcess.disconnect();	
	}
	
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("��ʦ")){
			outputStr = "��ʦ";
		}else if(InputStr.equals("�γ���")){
			outputStr = "�γ���";
		}else if(InputStr.equals("ѧ�ּ���")){
			outputStr = "ѧ�ּ���";
		}
		else if(InputStr.equals("�Ͽν���")){
			outputStr = "�Ͽν���";
		}
		else if(InputStr.equals("�Ͽ��ܴ�")){
			outputStr = "�Ͽ��ܴ�";
		}
		else if(InputStr.equals("�ڴ�")){
			outputStr = "�ڴ�";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
}

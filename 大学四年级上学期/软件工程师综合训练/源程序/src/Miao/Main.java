package Miao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

public class Main {

public ResultSet rs;//test
	
public static void main(String[] args) {
	
      String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
      String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test";// ����Դ DatabaseName���Ѿ����������ݿ������ ���Ǳ������
      
      try {
          Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
      } catch (ClassNotFoundException e) {
          // e.printStackTrace();
          System.out.println("�������ݿ�����ʧ��");
          System.exit(0);
      }
      
      System.out.println("���ݿ������ɹ�");
      
      Login login = new Login();
      
  }
}
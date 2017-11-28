import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Mail extends JFrame implements ActionListener
 {
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2,label3,label4,label5,label6;
  JTextField  text1,text2,text3,text4;
  //JFrame f=new JFrame("MINI-OS");
   Mail()
   {
   label1 = new JLabel();
   label1.setText("From:");
   text1 = new JTextField();

   label2 = new JLabel();
   label2.setText("Password:");
   text2 = new JPasswordField();

   label3 = new JLabel();
   label3.setText("To:");
   text3 = new JTextField();

   label4 = new JLabel();
   label4.setText("Message:");
   text4 = new JTextField();

   label5 = new JLabel();
   label5.setText("");

   label6 = new JLabel();
   label6.setText("");

   SUBMIT=new JButton("Mail");
   Cursor cur=new Cursor(Cursor.HAND_CURSOR);
   SUBMIT.setCursor(cur);
   panel=new JPanel(new GridLayout(3,1));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(label3);
   panel.add(text3);
   panel.add(label4);
   panel.add(text4);
   panel.add(label5);
   panel.add(label6);
   panel.add(SUBMIT);
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("Send Mail");
   }
  public void actionPerformed(ActionEvent ae)
   {
   	String from=text1.getText();
   	String pwd=text2.getText();
        String to=text3.getText();
        String message=text4.getText();
   	Process p;
	try {
		p = Runtime.getRuntime().exec("python mail.py"+" "+from+" "+message+" "+pwd+" "+to);		//p.destroyForcibly();
       } catch (Exception e) {}
  text1.setText("");
  text2.setText("");
  text3.setText("");
  text4.setText("");
  label5.setText("mailed succesfully");
 }
  public static void main(String args[]){
    Mail frame=new Mail();
    frame.setSize(400,100);
    frame.setLocation(500,280);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 }

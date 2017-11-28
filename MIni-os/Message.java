import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class Message extends JFrame implements ActionListener
 {
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2,label3;
  JTextField  text1,text2;
  //JFrame f=new JFrame("MINI-OS");
   Message()
   {
   label1 = new JLabel();
   label1.setText("number");
   text1 = new JTextField(15);

   label2 = new JLabel();
   label2.setText("message");
   text2 = new JTextField();

   label3 = new JLabel();
   label3.setText("");

   SUBMIT=new JButton("SEND");
   Cursor cur=new Cursor(Cursor.HAND_CURSOR);
   SUBMIT.setCursor(cur);
   panel=new JPanel(new GridLayout(3,1));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(label3);
   panel.add(SUBMIT);
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("Send message");
   }
  public void actionPerformed(ActionEvent ae)
   {
   	String value1=text1.getText();
   String value2=text2.getText();
   Process p;
		try {
		    p = Runtime.getRuntime().exec("python message.py"+" "+value1+" "+value2);
				//p.destroyForcibly();
		} catch (Exception e) {}
  text1.setText("");
  text2.setText("");
  label3.setText("sent succesfully");
 }
  public static void main(String[] args){
    Message frame=new Message();
    frame.setSize(300,100);
    frame.setLocation(500,280);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
 }

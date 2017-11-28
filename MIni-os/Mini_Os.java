import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

class Login extends JFrame implements ActionListener
 {
  JButton SUBMIT,res;
  JPanel panel;
  JLabel label1,label2;
  JTextField  text1,text2;
  //JFrame f=new JFrame("MINI-OS");
   Login()
   {
   label1 = new JLabel();
   label1.setText("Username:");
   text1 = new JTextField(15);

   label2 = new JLabel();
   label2.setText("Password:");
   text2 = new JPasswordField(15);
   res = new JButton("RESET");
   SUBMIT=new JButton("SUBMIT");
   Cursor cur=new Cursor(Cursor.HAND_CURSOR);
   SUBMIT.setCursor(cur);
   panel=new JPanel(new GridLayout(3,1));
   panel.add(label1);
   panel.add(text1);
   panel.add(label2);
   panel.add(text2);
   panel.add(SUBMIT);
   panel.add(res);
   res.addActionListener( new ActionListener()
   {
      public void actionPerformed(ActionEvent e)
      {
	  text1.setText("");text2.setText("");
      }
   });
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("LOGIN FORM");
   }
  public void actionPerformed(ActionEvent ae)
   {
   String value1=text1.getText();
   String value2=text2.getText();
   int flag = 0;
   try {
   	FileReader reader = new FileReader("users.txt");
   	BufferedReader bufferedReader = new BufferedReader(reader);
   	String line;
        while((line = bufferedReader.readLine()) != null) {
        	String[] parts = line.split("\\s");
        	if(value1.equals(parts[0]) && value2.equals(parts[1])) {
        		flag = 1;
        		break;
        	}
        }
   }
   catch (IOException e) {
   	e.printStackTrace();
   }
   catch (ArrayIndexOutOfBoundsException e) {
   	flag = 0;
   }
   if (flag == 1) {
	    	text1.setText("");text2.setText("");
		new AWTCounter();
   }
   else{
   System.out.println("enter the valid username and password");
   JOptionPane.showMessageDialog(this,"Incorrect login or password",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }

 }
 class Mini_Os
 {
   public static void main(String args[])
   {
   try
   {
   Login frame=new Login();
   frame.setSize(300,100);
	 frame.setLocation(500,280);
   frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(null, e.getMessage());}
   }
 }

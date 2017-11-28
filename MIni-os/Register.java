import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Register extends JFrame implements ActionListener{
	JButton SUBMIT;
	JPanel panel;
  	JLabel label1,label2,label3,label4;
  	JTextField text1,text2,text3;
  	Register(){
  		label1 = new JLabel();
   		label1.setText("Username: (only alphanumeric)");
   		text1 = new JTextField(15);

	        label2 = new JLabel();
	        label2.setText("Password:");
	        text2 = new JPasswordField(15);

	        label3 = new JLabel();
	        label3.setText("Re-enter Password:");
	        text3 = new JPasswordField(15);

          label4 = new JLabel();
	        label4.setText(" ");
  		SUBMIT=new JButton("ADD");

  		panel=new JPanel(new GridLayout(4,1));
   		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
    		panel.add(label4);
		panel.add(SUBMIT);
		add(panel,BorderLayout.CENTER);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		SUBMIT.setCursor(cur);
		SUBMIT.addActionListener(this);
		setTitle("ADD-USER");
  }
		public void actionPerformed(ActionEvent e){
			String value1=text1.getText();
   			String value2=text2.getText();
     			String value3=text3.getText();
					int l = value1.length();
					int l1 = value2.length();
					int l2 = value3.length();
     			if(value2.equals(value3) && (l1!=0 && l2!=0 && l!=0) && value1.matches("[0-9]+")==false){
     				try {
				    FileWriter writer = new FileWriter("users.txt", true);
				    BufferedWriter bufferedWriter = new BufferedWriter(writer);
				    bufferedWriter.write("\n"+value1+" "+value2);

				    bufferedWriter.close();
						text1.setText("");
						text2.setText("");
						text3.setText("");
						label4.setText(value1+" "+"added succesfully");
				} catch (IOException e1) {
				    e1.printStackTrace();
				}
     			}
			else{
			    System.out.println("enter the valid username and password");
			    JOptionPane.showMessageDialog(this,"enter the valid username and password",
			    "Error",JOptionPane.ERROR_MESSAGE);
			 }
     		}

			public static void main(String[] args) {
				Register frame=new Register();
		    frame.setSize(500,200);
		    frame.setLocation(1000,200);
		    frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
}

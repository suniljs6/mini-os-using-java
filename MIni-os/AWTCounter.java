import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.geom.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;



public class AWTCounter implements ActionListener{
JFrame f;
JMenuBar mb;
JMenu Application,Chat,Enterainment,SApplication;
JMenuItem text,music,game,file,paint,cal,cmd,chat,email,adduser;
Process text_editor,tet,p,m,expl,mes,mai,c;
JLabel label1,l;
AWTCounter(){
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
mb = new JMenuBar();
Application = new JMenu("Applications");
Chat = new JMenu("Chat");
Enterainment = new JMenu("Enterainment");
SApplication = new JMenu("System-Application");
adduser = new JMenuItem("Add User");
adduser.addActionListener(this);
text = new JMenuItem("Text-Editor");
text.addActionListener(this);
music = new JMenuItem("MP3-Player");
music.addActionListener(this);
game = new JMenuItem("Tetris");
game.addActionListener(this);
paint = new JMenuItem("Paint");
paint.addActionListener(this);
cal = new JMenuItem("Calendar");
cal.addActionListener(this);
cmd = new JMenuItem("Terminal");
cmd.addActionListener(this);
chat = new JMenuItem("Message");
chat.addActionListener(this);
email = new JMenuItem("G-Mail");
email.addActionListener(this);
Chat.add(chat);
Chat.add(email);
Enterainment.add(music);
Enterainment.add(game);
Enterainment.add(paint);
SApplication.add(text);
SApplication.add(cal);
SApplication.add(cmd);
SApplication.add(adduser);
Application.add(Chat);
Application.add(Enterainment);
Application.add(SApplication);
mb.add(Application);
f=new JFrame("MINI-OS"+"                                                                                                                                                                                                                                                                                   "+sdf.format(date));
f.getContentPane().setBackground(Color.cyan);
f.setUndecorated( true );
Image icon = Toolkit.getDefaultToolkit().getImage("/root/Desktop/MIni-os/pics/index.png");
f.setIconImage(icon);
// use value from 1 to 8
f.getRootPane().setWindowDecorationStyle(2);
f.setJMenuBar(mb);
JButton b=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/text"));
b.setBounds(380,580,100, 100);
b.setBackground(Color.black);
b.setOpaque(true);
f.add(b);
Toolkit tk = Toolkit.getDefaultToolkit();
int xsize = (int)tk.getScreenSize().getWidth();
int ysize = (int)tk.getScreenSize().getHeight();
/*
ImageIcon icon1 = new ImageIcon(getClass().getResource("/root/Desktop/MIni-os/pics/index.png"));
l = new JLabel(icon1);
l.setBounds(0,0,xsize,ysize);
f.add(l);*/
//Tooltip tooltip = new Tooltip();
//tooltip.setText("Text-editor");
b.setToolTipText("Text-Editor");
b.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      try {
          text_editor = Runtime.getRuntime().exec("python3 main.py");
          //text_editor.waitFor();
          //System.out.println(text_editor.exitValue());
      } catch (Exception ex) {}
    }
});


label1 = new JLabel();
label1.setText("MINI-OS");
label1.setSize(665,100);
label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 50));
label1.setForeground(Color.black);
label1.setLocation(575,100);
f.add(label1);
JTextField search = new JTextField(25);
search.setBounds(550,200,250,30);
f.add(search);
JButton b1=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/search"));
b1.setBounds(800,200,30,30);
f.add(b1);
b1.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        String text = search.getText();
	search.setText("");
	if(text.equals("cmd")){
    try {
        c = Runtime.getRuntime().exec("java Terminal");
        //c.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
  }
	else if(text.equals("editor")){
      try {
          text_editor = Runtime.getRuntime().exec("python3 main.py");
          //text_editor.waitFor();
      } catch (Exception ex) {}
    }
	else if(text.equals("chat")){
    try {
        mes = Runtime.getRuntime().exec("java Message");
        //mes.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
	  }
	else if(text.equals("email")){
    try {
        mai = Runtime.getRuntime().exec("java Mail");
        //mai.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
	  }
	else if(text.equals("paint")){
    try {
		    p = Runtime.getRuntime().exec("python draw.py");
        //p.waitFor();
				//p.destroyForcibly();
		} catch (Exception ex) {}
  }
	else if(text.equals("game")){
    try {
        tet = Runtime.getRuntime().exec("python tetris.py");
        //tet.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
  }
	else if(text.equals("music")){
    try {
		    m = Runtime.getRuntime().exec("python3 music.py");
        //m.waitFor();
		} catch (Exception ex) {}
  }
	else if(text.equals("calendar")){
	    //System.out.println("cal");
	    int year = Calendar.getInstance().get(Calendar.YEAR);
	    int month = Calendar.getInstance().get(Calendar.MONTH);
	    Month panel = new Month(month,year);
	    JFrame frame = new JFrame();
	    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new FlowLayout());
	    frame.setLocation(1250,100);
	    frame.add(panel);
	    frame.pack();
	    frame.setVisible(true);
	  }
	else if(text.equals("")){search.setText("Enter something.");}
	else{search.setText("No such app exists.");}
    }
});


JButton b2=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/music"));
b2.setBounds(500,580,100, 100);
f.add(b2);
b2.setBackground(Color.black);
b2.setOpaque(true);
b2.setToolTipText("Music-Player");
b2.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      try {
          m = Runtime.getRuntime().exec("python3 music.py");
          //m.waitFor();
      } catch (Exception ex) {}
    }
});


JButton b3=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/a"));
b3.setBounds(1290,620,65,65);
f.add(b3);
b3.setBackground(Color.black);
b3.setOpaque(true);
b3.setToolTipText("Poweroff");
b3.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        try{
          text_editor.destroyForcibly();
          tet.destroyForcibly();
          p.destroyForcibly();
          m.destroyForcibly();
        }
        catch(NullPointerException ne){}
        f.setState(Frame.ICONIFIED);
        new Halt();
        System.exit(0);
    }
});


JButton b4=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/tetris"));
b4.setBounds(620,580,100, 100);
f.add(b4);
b4.setBackground(Color.black);
b4.setOpaque(true);
b4.setToolTipText("Tetris");
b4.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      try {
          tet = Runtime.getRuntime().exec("python tetris.py");
          //tet.waitFor();
          //p.destroyForcibly();
      } catch (Exception ex) {}
    }
});

/*JButton b5=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/file.jpeg"));
b5.setBounds(740,580,100, 100);
f.add(b5);
b5.setBackground(Color.black);
b5.setOpaque(true);
b5.setToolTipText("File-Manager");
b5.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
        new ExplorerTest("/root/Desktop/MIni-os");
    }
});*/


JButton b6=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/mypaint"));
b6.setBounds(860,580,100,100);
f.add(b6);
b6.setBackground(Color.black);
b6.setOpaque(true);
b6.setToolTipText("Paint");
b6.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      try {
          p = Runtime.getRuntime().exec("python draw.py");
          //p.waitFor();
          //p.destroyForcibly();
      } catch (Exception ex) {}
    }
});

JButton b7=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/cal"));
//b7.setBounds(1250,10,65,65);
b7.setBounds(740,580,100, 100);
f.add(b7);
b7.setBackground(Color.black);
b7.setOpaque(true);
b7.setToolTipText("Calendar");
b7.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      int year = Calendar.getInstance().get(Calendar.YEAR);
      int month = Calendar.getInstance().get(Calendar.MONTH);
      Month panel = new Month(month,year);
      JFrame frame = new JFrame();
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      frame.setLocation(1250,100);
      frame.add(panel);
      frame.pack();
      frame.setVisible(true);
    }
});

/*JButton b8=new JButton(new AbstractAction("ADD-USER"){
  public void actionPerformed(ActionEvent e){
    Register frame=new Register();
    frame.setSize(500,100);
    frame.setLocation(1000,100);
    frame.setVisible(true);
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
});
Cursor cur=new Cursor(Cursor.HAND_CURSOR);
b8.setCursor(cur);
b8.setBounds(1000,10,175,65);
b8.setToolTipText("Add-User");
f.add(b8);*/


JButton b9=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/cmd"));
b9.setBounds(980,580,100,100);
f.add(b9);
b9.setBackground(Color.black);
b9.setOpaque(true);
b9.setToolTipText("CMD");
b9.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      try {
          c = Runtime.getRuntime().exec("java Terminal");
          //c.waitFor();
          //p.destroyForcibly();
      } catch (Exception ex) {}
    }
});

JButton b10=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/message"));
//b10.setBounds(1080,10,65,65);
b10.setBounds(1250,10,65,65);
f.add(b10);
b10.setBackground(Color.black);
b10.setOpaque(true);
b10.setToolTipText("Send-Message");
b10.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      /*Message frame=new Message();
      frame.setSize(300,100);
      frame.setLocation(500,280);
      frame.setVisible(true);
      */
      try {
          mes = Runtime.getRuntime().exec("java Message");
          //mes.waitFor();
          //p.destroyForcibly();
      } catch (Exception ex) {}
    }
});


JButton b11=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/mail"));
b11.setBounds(1160,10,65,65);
f.add(b11);
b11.setBackground(Color.black);
b11.setOpaque(true);
b11.setToolTipText("Send-GMAIL");
b11.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {
      try {
          mai = Runtime.getRuntime().exec("java Mail");
          //mai.waitFor();
          //p.destroyForcibly();
      } catch (Exception ex) {}
    }
});

/*JButton b13=new JButton(new ImageIcon("/root/Desktop/MIni-os/pics/mail"));
b13.setBounds(450,260,100,100);
f.add(b13);
b13.setBackground(Color.black);
b13.setOpaque(true);
b13.setToolTipText("CALCULATOR");
b13.addActionListener( new ActionListener()
{
    public void actionPerformed(ActionEvent e)
    {

    }
});
*/
f.setSize(xsize,ysize);
f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent e) {
  if(e.getSource()==chat){
    try {
        mes = Runtime.getRuntime().exec("java Message");
        //mes.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
  }
  if(e.getSource()==email){
    Mail frame=new Mail();
    frame.setSize(400,100);
    frame.setLocation(500,280);
    frame.setVisible(true);
  }
  if(e.getSource()==paint){
    //System.out.println("paint");
    try {
        p = Runtime.getRuntime().exec("python draw.py");
        //p.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
  }
  if(e.getSource()==game){
    //System.out.println("game");
    try {
        tet = Runtime.getRuntime().exec("python tetris.py");
        //tet.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
  }
  if(e.getSource()==music){
    //System.out.println("music");
    try {
        m = Runtime.getRuntime().exec("python3 music.py");
        //m.waitFor();
    } catch (Exception ex) {}
  }
  if(e.getSource()==text){
    //System.out.println("text");
    try {
        text_editor = Runtime.getRuntime().exec("python3 main.py");
        //text_editor.waitFor();
    } catch (Exception ex) {}
  }
  if(e.getSource()==cmd){
    //System.out.println("cmd");
    try {
        c = Runtime.getRuntime().exec("java Terminal");
        //c.waitFor();
        //p.destroyForcibly();
    } catch (Exception ex) {}
  }
  if(e.getSource()==adduser){
    Register frame=new Register();
    frame.setSize(500,200);
    frame.setLocation(1000,200);
    frame.setVisible(true);
  }
  if(e.getSource()==cal){
    //System.out.println("cal");
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int month = Calendar.getInstance().get(Calendar.MONTH);
    Month panel = new Month(month,year);
    JFrame frame = new JFrame();
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    frame.setLocation(1250,100);
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}

}

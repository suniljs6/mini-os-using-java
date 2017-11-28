import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.text.*;
public class Terminal implements ActionListener,KeyListener{
JLabel l1,l2;
JTextArea area;
JButton b;
JTextArea textArea;
JFrame frame;
	Terminal() {
	frame = new JFrame ("MINI OS Terminal");
	textArea = new JTextArea();
	textArea.addKeyListener(this);
	Font font = new Font("Verdana", Font.BOLD, 12);
    textArea.setFont(font);
	textArea.setBackground(Color.BLACK);
    textArea.setForeground(Color.GREEN);
	textArea.setCaretColor(Color.GREEN);
	JScrollPane scroll = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	frame.add(scroll);
	frame.setSize(550,300);
		//frame.setLayout(null);
	frame.setVisible (true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	Dictionary<String, String> d = new Hashtable<String, String>();

	public void keyPressed(KeyEvent e){
    		if(e.getKeyCode() == KeyEvent.VK_ENTER){
				//int countLine = textArea.getLineCount();
				//System.out.println(countLine);
    			String text[] = textArea.getText().split("\\n");
    			String last = text[text.length-1];
				command(last);
    		}
	}
	public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
	public void actionPerformed(ActionEvent e){}
	public String addcommand(String[] last,int sizearr,int start){
		float sum = 0;
		try{
			for(int i=start;i<sizearr;i++){
				if(d.get(last[i])!=null && !d.isEmpty()){last[i] = d.get(last[i]);}
			}
			for(int i=start;i<=sizearr - 1;i++){
				sum = sum + Float.parseFloat(last[i]);
			}
			return Float.toString(sum);
		}
		catch(NumberFormatException e){
			String out="";
			for(int i=0;i<=sizearr - 1;i++){
				out = out + last[i] + " ";
			}
			return out;
		}
	}
	public String subcommand(String[] last,int sizearr,int start){
		try{
			for(int i=start;i<sizearr;i++){
				if(d.get(last[i])!=null && !d.isEmpty()){last[i] = d.get(last[i]);}
			}
			float diff = Float.parseFloat(last[start]);
			for(int i=start+1;i<=sizearr - 1;i++){
				diff = diff - Float.parseFloat(last[i]);
			}
			return Float.toString(diff);
		}
		catch(NumberFormatException e){
			String out="";
			for(int i=0;i<=sizearr - 1;i++){
				out = out + last[i] + " ";
			}
			return out;
		}
	}
	public String mulcommand(String[] last,int sizearr,int start){
		float mul = 1;
		try{
			for(int i=start;i<sizearr;i++){
				if(d.get(last[i])!=null && !d.isEmpty()){last[i] = d.get(last[i]);}
			}
			for(int i=start;i<=sizearr - 1;i++){
				mul = mul*Float.parseFloat(last[i]);
			}
			return Float.toString(mul);
		}
		catch(NumberFormatException e){
			String out="";
			for(int i=0;i<=sizearr - 1;i++){
				out = out + last[i] + " ";
			}
			return out;
		}
	}
	public String divcommand(String[] last,int sizearr,int start){
		try{
			for(int i=start;i<sizearr;i++){
				if(d.get(last[i])!=null && !d.isEmpty()){last[i] = d.get(last[i]);}
			}
			float diff = Float.parseFloat(last[start]);
			for(int i=start+1;i<=sizearr - 1;i++){
				diff = diff/Float.parseFloat(last[i]);
			}
			return Float.toString(diff);
		}
		catch(NumberFormatException e){
			String out="";
			for(int i=0;i<=sizearr - 1;i++){
				out = out + last[i] + " ";
			}
			return out;
		}
	}
	public void command(String var){
		String[] last = var.split("\\s");
		int sizearr = last.length;
		if(last[0].equals("poweroff") || last[0].equals("Poweroff") || last[0].equals("POWEROFF")){System.exit(0);}
		else if(last[0].equals("exit") || last[0].equals("Exit") || last[0].equals("EXIT")){frame.setVisible(false);}
		else if(last[0].equals("date") || last[0].equals("time") || last[0].equals("month") || last[0].equals("day")){
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
			if(last[0].equals("time")){df = new SimpleDateFormat("hh:mm:ss aa");}
			else if(last[0].equals("month")){df = new SimpleDateFormat("MMMMMM");}
			else if(last[0].equals("day")){df = new SimpleDateFormat("EEEEEE");}
			Calendar calobj = Calendar.getInstance();
			textArea.append("\n"+"-----> "+df.format(calobj.getTime()));
		}
		else if(last[0].equals("who")){textArea.append("\n"+"-----> "+"MINI-OS");}
		else if(last[0].equals("typeof")){
			try{
				Float.parseFloat(last[1]);
				if(last[1].contains(".")){textArea.append("\n"+"-----> "+"Float");}
				else{textArea.append("\n"+"-----> "+"Integer");}
			}
			catch(NumberFormatException e){
				textArea.append("\n"+"-----> "+"String");
			}
		}
		else if(last[0].contains("==")){
			String[] tobe = last[0].split("==");
			for(int i=0;i<tobe.length;i++){
				if(d.get(tobe[i])!=null && !d.isEmpty()){tobe[i] = d.get(tobe[i]);}
			}
			if(tobe[0].equals(tobe[1])){textArea.append("\n"+"-----> "+"True");}
			else{textArea.append("\n"+"-----> "+"False");}
		}
		else if(last[0].contains(">")) {
			String[] tobe = last[0].split(">");
			for(int i=0;i<tobe.length;i++){
				if(d.get(tobe[i])!=null && !d.isEmpty()){tobe[i] = d.get(tobe[i]);}
			}
			try{
				if(Float.parseFloat(tobe[0]) > Float.parseFloat(tobe[1])){textArea.append("\n"+"-----> "+"True");}
				else{textArea.append("\n"+"-----> "+"False");}
			}
			catch(NumberFormatException e){
				textArea.append("\n"+"-----> "+"Strings cannot be compared.");
			}
		}
		else if(last[0].contains("<")) {
			String[] tobe = last[0].split("<");
			for(int i=0;i<tobe.length;i++){
				if(d.get(tobe[i])!=null && !d.isEmpty()){tobe[i] = d.get(tobe[i]);}
			}
			try{
				if(Float.parseFloat(tobe[0]) < Float.parseFloat(tobe[1])){textArea.append("\n"+"-----> "+"True");}
				else{textArea.append("\n"+"-----> "+"False");}
			}
			catch(NumberFormatException e){
				textArea.append("\n"+"-----> "+"Strings cannot be compared.");
			}
		}
		else if(last[0].contains("=")){
			String[] tobe = last[0].split("=");
			try{
				Float i1 = Float.parseFloat(tobe[0]);
				if(d.get(tobe[1])!=null && !d.isEmpty()){tobe[1] = d.get(tobe[1]);}
				if(tobe[0].equals(tobe[1])){textArea.append("\n"+"-----> "+"True");}
				else{textArea.append("\n"+"-----> "+"False");}
			}
			catch(NumberFormatException e){
				if(tobe[1].contains("+")){
					String[] l = tobe[1].split("\\+");
					for(int i=0;i<l.length;i++){
						if(d.get(l[i])!=null && !d.isEmpty()){l[i] = d.get(l[i]);}
					}
					String a = addcommand(l,l.length,0);
					textArea.append("\n"+"-----> "+a);
					d.put(tobe[0],a);
				}
				else if(tobe[1].contains("-")){
					String[] l = tobe[1].split("\\-");
					for(int i=0;i<l.length;i++){
						if(d.get(l[i])!=null && !d.isEmpty()){l[i] = d.get(l[i]);}
					}
					String a = subcommand(l,l.length,0);
					textArea.append("\n"+"-----> "+a);
					d.put(tobe[0],a);
				}
				else if(tobe[1].contains("*")){
					String[] l = tobe[1].split("\\*");
					for(int i=0;i<l.length;i++){
						if(d.get(l[i])!=null && !d.isEmpty()){l[i] = d.get(l[i]);}
					}
					String a = mulcommand(l,l.length,0);
					textArea.append("\n"+"-----> "+a);
					d.put(tobe[0],a);
				}
				else if(tobe[1].contains("/")){
					String[] l = tobe[1].split("\\/");
					for(int i=0;i<l.length;i++){
						if(d.get(l[i])!=null && !d.isEmpty()){l[i] = d.get(l[i]);}
					}
					String a = divcommand(l,l.length,0);
					textArea.append("\n"+"-----> "+a);
					d.put(tobe[0],a);
				}
				else{
					d.put(tobe[0],tobe[1]);
					textArea.append("\n"+"-----> "+tobe[1]);
				}
			}
			/*Enumeration<String> key = d.keys();
			while(key.hasMoreElements()){
				System.out.println(key.nextElement());
			}
			Enumeration<String> element = d.elements();
			while(element.hasMoreElements()){
				System.out.println(element.nextElement());
			}*/
		}
		else if(!d.isEmpty() && d.get(last[0])!=null){textArea.append("\n"+"-----> "+d.get(last[0]));}
		else if(last[0].equals("clear")){textArea.setText("");}
		else if(last[0].equals("clearall")){
			Enumeration<String> key = d.keys();
			while(key.hasMoreElements()){
				d.remove(key.nextElement());
			}
			textArea.setText("");
		}
		else if(last[0].equals("mini")){textArea.append("\n"+"-----> "+"created by Sunil, Chaitanya, Rohit.");}
		/*else if(last[0].equals("run")){
			try{
				if(last[1].equals("paint")){new paint();}
				else if(last[1].equals("editor")){new TextEditor();}
				else if(last[1].equals("chat")){
					Message frame=new Message();
		    			frame.setSize(300,100);
		    			frame.setLocation(500,280);
		    			frame.setVisible(true);
				}
				else if(last[1].equals("mail")){
					Mail frame=new Mail();
		    			frame.setSize(400,100);
		    			frame.setLocation(500,280);
		    			frame.setVisible(true);
				}
				else if(last[1].equals("game")){new Tetris();}
				else if(last[1].equals("explorer")){new ExplorerTest("/root/Desktop/jos");}
				else if(last[1].equals("music")){new Music();}
				else if(last[1].equals("calander")){
				    int year = Calendar.getInstance().get(Calendar.YEAR);
				    int month = Calendar.getInstance().get(Calendar.MONTH);
				    Month panel = new Month(month,year);
				    JFrame frame = new JFrame();
				    frame.setLayout(new FlowLayout());
				    frame.setLocation(1250,200);
				    frame.add(panel);
				    frame.pack();
				    frame.setVisible(true);
				}
				else {textArea.append("\n"+"-----> "+"SORRY!!! No such app in our Mini-OS");return;}
				textArea.append("\n"+"-----> "+"open simsim");
			}
			catch(ArrayIndexOutOfBoundsException e){textArea.append("\n"+"-----> "+"Enter something");}
		}
		*/
		else if(last[0].contains("+")){
			String[] l = last[0].split("\\+");
			if(d.get(l[0])!=null && !d.isEmpty()){l[0] = d.get(l[0]);}
			textArea.append("\n"+"-----> "+addcommand(l,l.length,0));
		}
		else if(last[0].contains("-")){
			String[] l = last[0].split("\\-");
			if(d.get(l[0])!=null && !d.isEmpty()){l[0] = d.get(l[0]);}
			textArea.append("\n"+"-----> "+subcommand(l,l.length,0));
		}
		else if(last[0].contains("*")){
			String[] l = last[0].split("\\*");
			if(d.get(l[0])!=null && !d.isEmpty()){l[0] = d.get(l[0]);}
			textArea.append("\n"+"-----> "+mulcommand(l,l.length,0));
		}
		else if(last[0].contains("/")){
			String[] l = last[0].split("\\/");
			if(d.get(l[0])!=null && !d.isEmpty()){l[0] = d.get(l[0]);}
			textArea.append("\n"+"-----> "+divcommand(l,l.length,0));
		}
		else if(last.length > 1)
		{
			if(last[0].equals("echo") || last[0].equals("Echo") || last[0].equals("ECHO")){
				if(last[1].equals("add")){textArea.append("\n"+"-----> "+addcommand(last,sizearr,2));}
				else if(last[1].equals("sub")){textArea.append("\n"+"-----> "+subcommand(last,sizearr,2));}
				else if(last[1].equals("mul")){textArea.append("\n"+"-----> "+mulcommand(last,sizearr,2));}
				else if(last[1].equals("div")){textArea.append("\n"+"-----> "+divcommand(last,sizearr,2));}
				else {
					String out="";
					for(int i=1;i<=sizearr - 1;i++){
						out = out + last[i] + " ";
					}
					textArea.append("\n"+"-----> "+out);
				}
			}
			else if(last[0].equals("add")){
				textArea.append("\n"+"-----> "+addcommand(last,sizearr,1));
			}
			else if(last[0].equals("sub")){
				textArea.append("\n"+"-----> "+subcommand(last,sizearr,1));
			}
			else if(last[0].equals("mul")){
				textArea.append("\n"+"-----> "+mulcommand(last,sizearr,1));
			}
			else if(last[0].equals("div")){
				textArea.append("\n"+"-----> "+divcommand(last,sizearr,1));
			}
			else {
				String out="";
				for(int i=0;i<=sizearr - 1;i++){
					out = out + last[i] + " ";
				}
				textArea.append("\n"+"-----> "+out);
			}
		}
		else {
			String out="";
			for(int i=0;i<=sizearr - 1;i++){
				out = out + last[i] + " ";
			}
			textArea.append("\n"+"-----> "+out);
		}
	}
  public static void main(String[] args) {
  	new Terminal();
  }
}

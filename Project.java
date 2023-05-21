package ProjectPackage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;


public class Project extends JFrame {
	JLabel name;
	JLabel email;
	JLabel password;
	JButton submit;
	JButton cancel;
	static JTextField tname;
	JTextField tmail;
	JPasswordField tpass;
	JPasswordField tcpass;
	
	public static long dwellTime;
	public static long FlightTime;
	public static long dt;
	public static long ft;
	public static String b;

	public Project() {
		JPanel jp = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		CustomMouseListener MouseActivity = new CustomMouseListener();
		gbc.insets = new Insets(8,8,8,8);
		name = new JLabel("Name");
		gbc.gridx = 0;
		gbc.gridy = 0;
		jp.add(name,gbc);
		email = new JLabel("Email");
		gbc.gridx = 0;
		gbc.gridy = 1;
		jp.add(email,gbc);
		password = new JLabel("Password");
		gbc.gridx = 0;
		gbc.gridy = 2;
		jp.add(password,gbc);
		tname = new JTextField(16);
		tname.addMouseListener(MouseActivity);
		gbc.gridx = 1;
		gbc.gridy = 0;
		jp.add(tname,gbc);
		tmail= new JTextField(16);
		tmail.addMouseListener(MouseActivity);
		gbc.gridx = 1;
		gbc.gridy = 1;
		jp.add(tmail,gbc);
		tpass = new JPasswordField(16);
		tpass.addMouseListener(MouseActivity);
		gbc.gridx = 1;
		gbc.gridy = 2;
		jp.add(tpass,gbc);
		submit = new JButton("Submit");
		submit.addMouseListener(MouseActivity);
		submit.setSize(15, 15);
		gbc.gridx = 0;
		gbc.gridy = 4;
		jp.add(submit,gbc);
		cancel = new JButton("Cancel");
		cancel.addMouseListener(MouseActivity);
		cancel.setSize(15, 15);
		gbc.gridx = 1;
		gbc.gridy = 4;
		jp.add(cancel,gbc);
		
		this.getContentPane().add(jp);
		setSize(500,400);
		setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String args[])  {
		LocalDateTime  dateObj = LocalDateTime.now();
        DateTimeFormatter formatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatObj2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String finalDate = dateObj.format(formatObj1);
        String finalTime = dateObj.format(formatObj2);
		Project bf = new Project();
		try {
			String bookHeader[] = {"Button", "DwellTime","FlightTime"};
	        String Date[] = {"Session", finalDate,finalTime};
//	        String Name[] = {"Name", tname.getText()," "};
		    
	        List<String[]> s = new ArrayList<String[]>();
	        s.add(bookHeader);
	        s.add(Date);
//	        s.add(Name);
	        File f = new File("Time_Data.csv");
	        FileWriter fos = new FileWriter(f,true);
	        CSVWriter writer = new CSVWriter(fos);
	        writer.writeNext(Date);
//	        writer.writeNext(Name);
	        writer.writeNext(bookHeader);
	      
	        writer.close();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
 
	}
}

class CustomMouseListener implements MouseListener {
	
	public long pressTime;
	public long releaseTime;
	public static long ftime;
	public static long dtime;
	public static long clickStore = 0;
	public int count = 0;
	public static String buttonType;
	
	
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e)  {
    	pressTime = System.currentTimeMillis();
    	if(count == 0) {
    		count++;
    	}else {
    		ftime = FlightTimeFunc(pressTime, clickStore);
    	}
    }
    public void mouseReleased(MouseEvent e) {
    	if(e.getButton() == MouseEvent.BUTTON1) {
    		buttonType = "Left";

    	}
    	else if(e.getButton() == MouseEvent.BUTTON3) {
    		buttonType = "Right";

    	}
    	releaseTime = System.currentTimeMillis();
    	clickStore = releaseTime;
    	dtime = DwellTimeFunc(pressTime, releaseTime, buttonType);
    	display();
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    
    public static long DwellTimeFunc(long t1, long t2, String bt) {
    	Project.dwellTime = t2-t1;
    	System.out.println("Dual Time: "+Project.dwellTime+" ");
    	System.out.println("Button Type: "+ bt);
		return Project.dwellTime;
    	
    }
    
    public static long FlightTimeFunc(long t1, long t2) {
    	Project.FlightTime = t1-t2;
		ftime=t1-t2;
    	System.out.println("Flight Time: "+Project.FlightTime+" ");
    	return Project.FlightTime;
    }
 
	public void display() {
		try {
		String bookHeader[] = {"Button", "DwellTime","FlightTime"};
        
	    
        String reading[]= {buttonType,Long.toString(dtime),Long.toString(ftime)};
        String space[] = {" ", " "," "};
        List<String[]> s = new ArrayList<String[]>();
        s.add(reading);
        s.add(space);
        
        File f = new File("Time_Data.csv");
        FileWriter fos = new FileWriter(f,true);
       //FileWriter fos = new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\School\\Bruh things\\src\\Adv_java\\Time_Database.csv",true);
        CSVWriter writer = new CSVWriter(fos);
        writer.writeNext(reading);
        writer.writeNext(space);
        writer.close();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
    
	}
 }
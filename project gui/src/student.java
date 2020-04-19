
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

public class student extends JFrame implements Runnable
{   
	
	  final int port=8000;
	  final String ip="192.168.134.1";
	  private BufferedReader serverInput=null;
	  private PrintWriter OutPut=null;
	  private Socket socket=null;
	  private int id;
	  public boolean connect=true;
	JFrame frame;
	
	JTextField client2;
	JTextField message;
	JTextField gpa;
	
	JTextArea Marea;
	JTextArea Rarea;
	
	JSeparator Sseparate;
	JScrollPane s1;
	
	
	 JButton send;
	  
	  JPanel panel1;
	  
	  JLabel g;
	  JLabel result;
	  JLabel Swelcome;
	  
	 

	  Font font = new Font("Serif", Font.ITALIC, 18);
	  Font font1 = new Font("Serif", Font.BOLD, 24);
	  
	  //adding information to be added in the student gui and creating student gui
	  public void add(String name,String mark1,String mark2,String Gpa) throws IOException
	  {
		  
		  frame = new JFrame();
		  frame.setTitle("login");	 
		  frame.setLocation(500,280);
		  frame.setSize(600, 600);
		    
		  
		  panel1=new JPanel();			   
		  panel1.setLayout(null);
			    
			 

			   
			    Swelcome = new JLabel("Welcome "+name);
			    Swelcome.setFont(font1);
			    Swelcome.setBounds(0, 10, 450, 25);
			    panel1.add(Swelcome);
			    
			  
			    g = new JLabel("GPA : ");
			    g.setFont(font1);
			    g.setBounds(30, 80, 70, 30);
			    panel1.add(g);
			    
			    result = new JLabel("Result :");
			    result.setFont(font1);
			    result.setBounds(30, 100, 121, 152);
			    panel1.add(result);
			
			    
			    gpa = new JTextField("");
			    gpa.setBounds(66, 122, 76, 21);
			    gpa.setEditable(false);	
			    gpa.setFont(font);
			    gpa.setText(Gpa);
			    panel1.add(gpa);
			    
						   
			    Rarea = new JTextArea("");
			    Rarea.setBounds(62, 211, 100, 55);
			    Rarea.setFont(font);
			    Rarea.setEditable(false);
			    Rarea.setText("Mark 1 :" + mark1 +'\n'+"Mark 2 :" + mark2);
			    panel1.add(Rarea);
			    
			    Sseparate = new JSeparator(JSeparator.VERTICAL);
			    Sseparate.setBounds(240, 41, 2, 211);
			    panel1.add(Sseparate);
			    
			    //right side of seperator to communicate with teacher
			    client2 = new JTextField("teacher ID");
			    client2.setBounds(270, 53, 146, 21);
			    client2.setFont(font);
			    panel1.add(client2);
			    
			    message = new JTextField("");
			    message.setBounds(270, 211, 146, 21);
			    message.setFont(font);
			    panel1.add(message);
			    
			    Marea = new JTextArea("");
			    
			    s1 = new JScrollPane(Marea);
			    s1.setBounds(270, 80, 151, 125);
			    s1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			    s1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			    Marea.setEditable(false);		    
			    panel1.add(s1);
			    
			    send = new JButton("send");
			    send.setFont(font);
			    send.setBounds(430, 209, 70, 25);
				  panel1.add(send);

			    
			   frame.add(panel1);
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
           	socket=new Socket(ip,port);

        	InputStreamReader isr=new InputStreamReader(socket.getInputStream());
        	
             
        		
        	serverInput=new BufferedReader(isr);
        	 OutPut=new PrintWriter(socket.getOutputStream(),true);
        	new Thread(this).start();
        	 
        	  
        	  send.addActionListener(new ActionListener() 
        	    {
        	      public void actionPerformed(ActionEvent e)
        	      {
        	        		 try {
        	        			 if (OutPut!= null)
        	     				OutPut.println(message.getText());
        	        			 Marea.append("me:"+message.getText()+"\n");
        	        			 
        						
        					}
        	        		 catch (Exception e1)
        	        		 {
        						e1.printStackTrace();
        					}}});
        	        	
        					
       

        	    }

        	  
        	  public void run() {
        	  	String msg;
        	  	try {
        	  		msg=serverInput.readLine();
        	  	
        	  		while(true) {
        	  			  
        	  			msg = serverInput.readLine(); 	
        	  			Marea.append(client2.getText()+" :"+ msg + "\n");
        	  			
        	  		}
        	  	} catch (IOException e) {
        	  		// TODO Auto-generated catch block
        	  		e.printStackTrace();
        	  	}
        	  	
        	  	
        	  	
        	  	
        	  }
        	    
        	    
        	

	  }
	 









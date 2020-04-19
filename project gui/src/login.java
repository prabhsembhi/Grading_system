import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.*;

public class login extends JFrame implements Runnable, CallBack.CallBack 
{
	  private ServerSocket sersocket=null;
	   private Socket socket=null;
	   final int port=8000;
	   private  ArrayList<PrintWriter> toSend;
	
	//login page Gui elements
  JButton blogin;
  JButton teacher;
  JButton student;
  JButton submit;
  
  JTextField id;
  JTextField pass;
  
  JLabel username;
  JLabel password;

  
  JRadioButton tButton = new JRadioButton("Teacher");
  JRadioButton sButton = new JRadioButton("Student");
  
  JPanel loginpanel;
  
  
  
  //Teacher Gui elements
  JFrame userframe;
  JTextField sid;
	JTextField marks;
	JTextField client;
	JTextField message;
	
	JTextArea Marea;
	JTextArea rarea;
	
	JSeparator separate;
	JScrollPane a1;
	
	JButton submit2;
	JButton average;
	JButton send;
	  
	  JPanel panel1;
	  JLabel welcome;
	  
	  JRadioButton UButton = new JRadioButton("Update");//update button to update information
	  JRadioButton MButton = new JRadioButton("Marks");//marks button to just see the marks
  
  
  
  
  Font font = new Font("Serif",Font.ITALIC, 14);
  Font font1 = new Font("Serif", Font.BOLD, 24);
  
  String ID1,ID2;
  
  //calling other classes
  DLinkedList ll = new DLinkedList();
  DLinkedList avg = new DLinkedList();
  tree info = new tree(); 
  student s = new student(); 
  gpa g = new gpa();
  
  
  
  
  //Teacher GUI
  public void teacher(int c) throws IOException
  {
	  
	 userframe = new JFrame();  
	 userframe.setSize(600,600);
	 userframe.setLocation(500,280);
	    
     panel1=new JPanel();  
	 panel1.setLayout(null);
	    
	 
	   
	   ButtonGroup group = new ButtonGroup();
	   group.add(MButton);
	   group.add(UButton);
	    
	   
	   //setting the top greetings
	    if(c==1)
		   {
		    welcome = new JLabel("Welcome John");
		   }
		   if(c==2)
		   {
		    welcome = new JLabel("Welcome Peter");
		   }
	    welcome.setFont(font1);
	    welcome.setBounds(0, 10, 450, 25);
	    panel1.add(welcome);
	    
	    //field to enter student id to access information
	    sid = new JTextField("Student ID");
	    sid.setBounds(62, 53, 106, 21);
	    sid.setFont(font);
	    panel1.add(sid);
	   
	    
	    UButton.setBounds(24, 100, 90, 16);
	    MButton.setBounds(135, 100, 90, 16);
	    panel1.add(UButton);
	    panel1.add(MButton);
	    
	    //field to enter updated marks
	    marks = new JTextField("");
	    marks.setBounds(66, 122, 76, 21);
	    panel1.add(marks);
	    
	  submit2 = new JButton("Submit");
	  submit2.setFont(font);
	  submit2.setBounds(62, 149, 95, 25);
	  panel1.add(submit2);

	  average = new JButton("Class Average");
	  average.setFont(font);
	  average.setBounds(62, 180, 140, 25);
	  panel1.add(average);
	   
	  rarea = new JTextArea("");
	  rarea.setBounds(62, 211, 150, 70);
	  rarea.setFont(font);
	  panel1.add(rarea);
	    
	    separate = new JSeparator(JSeparator.VERTICAL);
	    separate.setBounds(240, 41, 2, 211);
	    panel1.add(separate);
	    
	    //right side of seperator for communicating with teacher
	    client = new JTextField("Student ID");
	    client.setBounds(270, 53, 146, 21);
	    client.setFont(font);
	    panel1.add(client);
	    
	    message = new JTextField("");
	    message.setBounds(270, 211, 146, 21);
	    message.setFont(font);
	    panel1.add(message);
	    
	    Marea = new JTextArea("");
	    
	    a1 = new JScrollPane(Marea);
	    a1.setBounds(270, 80, 151, 125);
	    a1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	   a1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    Marea.setEditable(false);		    
	    panel1.add(a1);
	    
	    send = new JButton("send");
	    send.setFont(font);
	    send.setBounds(430, 209, 70, 25);
		panel1.add(send);

	    
	   userframe.add(panel1);
	   userframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   userframe.setVisible(true);
	    
	   //action performed on pressing submit button
	   submit2.addActionListener(new ActionListener() 
	    {
	      public void actionPerformed(ActionEvent e) 
	      {
	       //if marks radio button is pressed
	        	if(MButton.isSelected() == true)
	        	{
	        		tree newinfo = new tree();
	        		try {
						newinfo.put();
					} catch (FileNotFoundException e1) {

						e1.printStackTrace();
					}
	        	String data =newinfo.find(sid.getText());
	        		if(welcome.getText().equals("Welcome John"))
	        		{
	        			if(data != "No Record")
	        			{
	        		String[] sepr =data.split(",");
	        		
	        		rarea.setText(sepr[4]);
	        		}
	        			else
	        			{
	        				rarea.setText("No Record");
	        			}
	        		}
	        		
	        		
	        		if(welcome.getText().equals("Welcome Peter"))
	        		{
	        			if(data != "No Record")
	        			{
	        		String[] sepr =data.split(",");
	        		
	        		rarea.setText(sepr[5]);
	        		}
	        			else
	        			{
	        				rarea.setText("No Record");
	        			}
	        		}
	        		
  }
	        	
	        	 
	        	//if update radio button is pressed
	        	if(UButton.isSelected() == true)
	        	{
	        	String data = ll.search(sid.getText());
	        	int d =Integer.parseInt(data);
	        	String b = ll.get(d);  
	        	
	        	
	        		if(welcome.getText().equals("Welcome John"))
	        		{
	        			if(data != "0")
	        			{
	        				
	        					String[] sepr =b.split(",");
	        					String Marks = marks.getText();
	        					sepr[4] = marks.getText();
	        					double score = g.ScoreCalculator(Double.parseDouble(sepr[4]), Double.parseDouble(sepr[5]));
	        					double gpa = g.Gpa(score);
	        					String n = sepr[0]+","+sepr[1]+","+sepr[2]+","+sepr[3]+","+sepr[4]+","+sepr[5]+","+Double.toString(gpa);	   
	        					ll.remove(d);	        					
	        					ll.add(d, n); 	        					
	        					//info.replace(b);
									try
									{
										ll.write();
										
									} 
									catch (Exception e1)
									{
										
										 System.out.println("Caught IOException: " + e1.getMessage());
									}
									
									 System.out.println(ll);
	        					
	        					rarea.setText("Updated marks :"+sepr[4]);
	        				
	        		
	        		
	        		
	        		}
	        			else
	        			{
	        				rarea.setText("No Record");
	        			}
	        		}
	        		
	        		if(welcome.getText().equals("Welcome Peter"))
	        		{
	        			if(data != "0")
	        			{
	        				
	        					String[] sepr =b.split(",");
	        					String Marks = marks.getText();
	        					sepr[5] = marks.getText();
	        					double score = g.ScoreCalculator(Double.parseDouble(sepr[4]), Double.parseDouble(sepr[5]));
	        					double gpa = g.Gpa(score);
	        					String n = sepr[0]+","+sepr[1]+","+sepr[2]+","+sepr[3]+","+sepr[4]+","+sepr[5]+","+Double.toString(gpa);	   
	        					ll.remove(d);
	        					ll.add(d, n); 	        					
	        					try {
									ll.write();
								}
	        					catch (IOException e1) 
	        					{
									
									e1.printStackTrace();
								}
	        					rarea.setText("Updated marks :"+sepr[5]);
	        		
	        		
	        		
	        		}
	        			else
	        			{
	        				rarea.setText("No Record");
	        			}
	        		}
	        		
  }
	      }
	    });
	 	
	   	System.out.println("Started");
	   	sersocket=new ServerSocket(8000);
	   	Thread t=new Thread(login.this);
	   	
	   	toSend=new ArrayList<PrintWriter>();
	   	t.start();

	   	  
	   	  
	   
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (PrintWriter o : toSend)
					o.println(message.getText());
				Marea.append(message.getText()+"\n");
			}
		});
	   	
	   	
	   	
	   	
	   	
	   	
	     

	   

	 
	   /*private void saveFile(Socket clientSock) throws IOException {
	   	DataInputStream dis = new DataInputStream(clientSock.getInputStream());
	   	FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Desktop\\StudentId\\GenerateRandomID\\FinalReadfile.txt");
	   	byte[] buffer = new byte[4096];
	   	
	   	int filesize =5000; // Send file size in separate msg
	   	int read = 0;
	   	int totalRead = 0;
	   	int remaining = filesize;
	   	while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
	   		totalRead += read;
	   		remaining -= read;
	   	//	System.out.println("read " + totalRead + " bytes.");
	   		fos.write(buffer, 0, read);
	   	}
	   	

	   }
	   */
	 
	 
 
 
	   //if class average button is pressed
	   average.addActionListener(new ActionListener() 
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	    	 
	      
	    	  File student = new File("data.txt");
     		 try {
     			 	        			 
					Scanner scan = new Scanner(student);
					String [] data = new String[6];
					int c=0;
					while(scan.hasNext())
					{ 							
						data=scan.next().split(",");					
						
							if(welcome.getText().equals("Welcome John"))
			        		{
						
							//sending information to student class 
							avg.add(data[4]);	
							
				        	
						}
							if(welcome.getText().equals("Welcome Peter"))
			        		{
						
							//sending information to student class 
							avg.add(data[5]);	
							
				        	
						}
					}
					DecimalFormat deci = new DecimalFormat();
					String average = String.valueOf(deci.format(avg.avg()));
		        	rarea.setText(average);
     		 }
     		catch (IOException e1)
				{
					
					e1.printStackTrace();
				}
     		
	      
  }
	    });
  }
  

  //login Gui
  public login() throws FileNotFoundException
  {
    super("Login Autentification");

    setSize(600, 600);
   
    submit = new JButton("Submit");
    
    
    blogin = new JButton("Login");
    
    loginpanel = new JPanel();
    
    
    
    info.put();
    ll.put();
  
    
    
    
    id = new JTextField(15);
    pass = new JPasswordField(15);
    
    username = new JLabel("User - ");
    password = new JLabel("Pass - ");
    welcome = new JLabel("Welcome");

    setSize(300,200);
    setLocation(500,280);
    loginpanel.setLayout (null);


    id.setBounds(70,30,150,20);
    pass.setBounds(70,65,150,20);
    blogin.setBounds(110,100,80,20);
    username.setBounds(20,28,80,20);
    password.setBounds(20,63,80,20);
    
    welcome.setBounds(100,10,150,20);
   tButton.setBounds(20,110,80,20);
    sButton.setBounds(20,130,80,20);
    
   
loginpanel.add(welcome);
loginpanel.add(tButton);
loginpanel.add(sButton);
    loginpanel.add(blogin);
    loginpanel.add(id);
    loginpanel.add(pass);
    loginpanel.add(username);
    loginpanel.add(password);
    

    
 tButton.setSelected(true);

    

    // Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(tButton);
    group.add(sButton);

 


    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
   
    File teacher = new File("teacherPass.txt");
    File student = new File("data.txt");
      



//when login button is pressed
    blogin.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent e)
      {
       //teacher button
        	if(tButton.isSelected() == true)
        	{
        		
        		 try {
        			 
        			 
					Scanner scan = new Scanner(teacher);
					String [] data = new String[2];
					int c=0;
					
					while(scan.hasNext())
					{
						
						 //adding file information to binary tree 
						
						
						
						data=scan.next().split(",");						
						if(data[0].equals(id.getText())  && data[1].equals(pass.getText()))
						{		
							ID1=id.getText();
							
						int c1 = 1;
						if(data[2].equals("John"))
						{
							c1=1;
							try {
								teacher( c1);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						if(data[2].equals("Peter"))
						{
							c1=2;
							try {
								teacher( c1);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						
						
				        	c=1;
				        	break;
						}
						
					}
					if(c==0)
					{
						 JOptionPane.showMessageDialog(null,"Wrong Username / Password");
					}
					
				}
        		 catch (FileNotFoundException e1)
        		 {
					e1.printStackTrace();
				};
        	}
				
				
				
				if(sButton.isSelected() == true)
	        	{
	        		 File student = new File("data.txt");
	        		 try {
	        					 
						Scanner scan = new Scanner(student);
						String [] data = new String[2];
						int c=0;
						while(scan.hasNext())
						{ 							
							data=scan.next().split(",");					
							if(data[0].equals(id.getText())  && data[1].equals(pass.getText()))
							{
								
								//sending information to student class and creating it
								try {
									s.add(data[2],data[4],data[5],data[6]);
									 ID2=data[2];
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}													        	
					        	c=1;
					        	break;
							}
							
						}
						if(c==0)
						{
							 JOptionPane.showMessageDialog(null,"Wrong Username / Password");
						}
						
					}
	        		 catch (FileNotFoundException e1)
	        		 {
						e1.printStackTrace();
					};
        	}
        	
        	
    
      }
    });
  }
  

  public static void main(String[] args) throws FileNotFoundException
  {
  	login l = new login(); 
  	
  	
  }

  public void CallBack(String id, String msg) {
 	   	// TODO Auto-generated method stub
 	  
 	   	
 	   Marea.append( id + ": " + msg + "\n");

 	   
  
  }
  public void run() {
	   	Socket connectionSock;
	   	Boolean talk=true;
	   	String id1=ID2;
	   	Clienthandler ch;
	   	Thread t;
	   	PrintWriter pw;
	   	while(talk) {
	   		try {
	   			connectionSock=sersocket.accept();
	   			//saveFile(connectionSock);
	   		
	   		
	   			ch=new Clienthandler(connectionSock,id1,this);
	   			pw=new PrintWriter(connectionSock.getOutputStream(),true);
	   			pw.println("Welcome "+id1);
	   			toSend.add(pw);
	   		
	   		
	   			t=new Thread(ch);
	   			t.start();
	   		} catch (IOException e) {
	   			// TODO Auto-generated catch block
	   			e.printStackTrace();
	   		}
	   		
	   	}
	   }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import CallBack.CallBack;

public class Clienthandler implements Runnable{
 private Socket socket;
 private String id;
 private CallBack cBack;
	
	public Clienthandler(Socket socket,String id, CallBack cBack)
	{
		this.socket=socket;
		this.id=id;
		this.cBack=cBack;
	}
	public void run() {
		Boolean proceed=true;
		try {
			Scanner input=new Scanner(System.in); 
			InputStreamReader isr=new InputStreamReader(socket.getInputStream());
			BufferedReader bf=new BufferedReader(isr);
			String line;
			
		
			while(true) {
				
				line=bf.readLine();
				cBack.CallBack(id+"", line);;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


class DLinkedList
{
   
    private class Node
    {
        String value;   
        Node next;      
        Node prev;      
		  
     
		  
        Node(String val, Node n, Node p)
        {
            value = val;
            next = n;
            prev = p;
        }
		   
      
        Node(String val)
        {
          
           this(val, null, null);            
        }
    }
    
    private Node first;  
    private Node last;    
	
    

    
    public DLinkedList()
    {
        first = null;
        last = null;        
    }
   
  
    
    public boolean isEmpty()
    {        
        return first == null;
    }
    
   
    
    public int size()
    {
       int count = 0;
       Node p = first;   
       while (p != null)
       {
          
           count ++;
           p = p.next;
       }
       return count;
    }
    
  
    
    public void add(String e)
    {
      if (isEmpty()) 
      {
          last = new Node(e);
          first = last;
      }
      else
      {
         
          last.next = new Node(e, null, last);
          last = last.next;         
      }      
    }
    
   
    
    public void add(int index, String e)
    {
         if (index < 0  || index > size()) 
         {
             String message = String.valueOf(index);
             throw new IndexOutOfBoundsException(message);
         }
         
        
         if (index == 0)
         {
             
             Node p = first;           
             first = new Node(e, p, null);
             if (p != null)
                 p.prev = first;             
             if (last == null)
                 last = first;
             return;
         }
         
        
         Node pred = first;       
         for (int k = 2; k <= index ; k++)        
         {
            pred = pred.next;           
         }
         
        
         Node succ = pred.next;
         Node middle = new Node(e, succ, pred);
         pred.next = middle;  
         if (succ == null)             
             last = middle;       
         else            
             succ.prev = middle;                     
    }
    
  
    
    public String toString()
    {
      StringBuilder strBuilder = new StringBuilder();
      
      
     
      Node p = first;
      while (p != null)
      {
         strBuilder.append(p.value + "\n"); 
         p = p.next;
      }      
      return strBuilder.toString(); 
    }
    
    public String display(int index)
	 {
		 if (index < 0 || index >= size())  
	       {
String message = "Record not found";
return message.toString();
	       }          
		 else {
	      
	       Node T = first;  
	      for (int k = 1; k <= index; k++)
	       {
	           T = T.next;
	       }
	      
	       
	       StringBuilder str = new StringBuilder();
	       str.append(T.value + "\n"); 
	       
	     return str.toString();       
	    }
	 }
   
    
    public String get(int index)
    {
    	 Node target = first; 
    	 for (int k = 1; k <= index; k++)
             target = target.next;
    	 
    	 String element = target.value; 
    	 return element;
    }
    public double avg()
    {
    	 Node target = first; 
    	 double element =0;
    	 for (int k = 1; k <= 35; k++)
    	 {
             target = target.next;
    	 
    	  element += Double.parseDouble(target.value); 
    	 }
    	 System.out.println(size());
    	 element = element/(size()-1);
    	 return element;
    	
    }
    public String search(String s)
    {
    	 Node target = first; 
    	 for (int k = 1; k <= size(); k++)
    	 {
    		 target = target.next;
    		 
    		 if(target.value.substring(0,8).equals(s))
    		 {
    			
    			 return String.valueOf(k);
    		 }
    	 }
		return "0";
    }
    public String remove(int index)
    {
       if (index < 0 || index >= size())  
       {
          String message = String.valueOf(index);
          throw new IndexOutOfBoundsException(message);
       }            
      
      
       Node target = first;  
       for (int k = 1; k <= index; k++)
           target = target.next;
       
       String element = target.value;  
       Node pred = target.prev;        
       Node succ = target.next;        
       
     
       if (pred == null)       
           first = succ;
       else
           pred.next = succ;
       
       if (succ == null)
           last = pred;
       else
           succ.prev = pred;
       
       return element;        
    }
    
public void sort()
{
	
}
    
    public boolean remove(String element)
    {
       if (isEmpty()) 
           return false;      
      
       
       Node target = first;  
       while (target != null 
               && !element.equals(target.value))
           target = target.next;
       
       if (target == null)
           return false;       
      
       Node pred = target.prev;     
       Node succ = target.next;      
       
       
       if (pred == null)       
           first = succ;
       else
           pred.next = succ;
       
       if (succ == null)
           last = pred;
       else
           succ.prev = pred;      
    
        return true;       
    }
    
    public void put()throws FileNotFoundException
    {
   	 File file = new File("data.txt");
  	   	 
		Scanner scan = new Scanner(file);
		while(scan.hasNext())
		{
									
			add(scan.next());	
		}
   }
public void write() throws IOException
{
	File file = new File("data.txt");
	FileWriter write = new FileWriter(file);
	PrintWriter writefile = new PrintWriter(write);
	
	StringBuilder str = new StringBuilder();
    
    
    
    Node p = first;
    while (p != null)
    {
    	str.append(p.value + "\n"); 
       p = p.next;
    }   
    writefile.write(""); 
    writefile.write(str.toString()); 
    writefile.close();
}
   
    
    public static void main(String [] args) throws IOException
    {
     /* DLinkedList ll = new DLinkedList();
    ll.put();
    DLinkedList avg = new DLinkedList();
    File student = new File("studentPass.txt");
    String average = null;
	 try {
		 	        			 
			Scanner scan = new Scanner(student);
			String [] data = new String[6];
			int c=0;
			while(scan.hasNext())
			{ 							
				data=scan.next().split(",");					
				
					
					//sending information to student class 
					avg.add(data[5]);	
					
		        	
		        	//rarea.setText(average);
				}
			 average = String.valueOf(avg.avg());
			System.out.println(average);
			System.out.println(avg.get(7));
			}
	 
	catch (IOException e1)
		{
			
			e1.printStackTrace();
		}
    
    
    
    String data = ll.search("30012366");
	String b = ll.get(Integer.parseInt(data)); 
	
	int d =Integer.parseInt(data);
 		
	String[] sepr =b.split(",");
	//String Marks = marks.getText();
	sepr[4] ="1197656";
	String n = sepr[0]+","+sepr[1]+","+sepr[2]+","+sepr[3]+","+sepr[4]+","+sepr[5]+","+sepr[6];	   
	ll.remove(d);
	ll.add(d, n); 	        	
 		ll.write();
    }*/
    }
}

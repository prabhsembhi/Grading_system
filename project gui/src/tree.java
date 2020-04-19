import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tree 
{
	
	 String value;
	    tree left;
	    tree right;
	    tree root;
	 
	    tree(String value)
	    {
	        this.value = value;
	        right = null;
	        left = null;
	    }
	    
	    public tree() 
	    {
	    	
	    	right = null;
	        left = null;
		}
	    
	    //to add file info to tree
	    public void put() throws FileNotFoundException
	    {
	    	
	    	 File file = new File("data.txt");  	 
	 		Scanner scan = new Scanner(file);
	 		while(scan.hasNext())
	 		{	 									
	 			add(scan.next());	
	 		}
	    }

		public void add(String value)
	    {
			String id = value.substring(0, 8);
	        root = addRecursive(root, value, id);
	    }
	
private tree addRecursive(tree current, String value,String id)
{
    if (current == null)
    {
    	
        return new tree(value);
    }
 
    if (id.compareTo(current.value.substring(0, 8)) < 0) 
    {
        current.left = addRecursive(current.left, value,id);
    } 
    else if(id.compareTo(current.value.substring(0, 8)) > 0) 
    {
        current.right = addRecursive(current.right, value,id);
    } else
    {
        // value already exists
        return current;
    }
 
    return current;
}

private String search(tree current, String value)
{
	
	if (current == null) 
	{
        return "No Record";
    } 
    if (value.compareTo(current.value.substring(0, 8)) == 0)
    {
        return current.value;
    } 
    return (value.compareTo(current.value.substring(0, 8)) < 0) 
      ? search(current.left, value)
      : search(current.right, value);
}



public String find(String id) 
{
	
    String ans = search(root, id);
    return ans;
}


}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Tester {

	public static void main(String[] args) {
		String pattern=".java";
		// TODO Auto-generated method stub
		testShallowFileIterator(new File("filesystem"));
		testDeepFileIterator(new File("filesystem"));
	   testFilteredFileIterator(new File("filesystem"),pattern);
	}
   
    public static boolean testShallowFileIterator(File f)
    {
    	try {
			ShallowFileIterator sfi=new ShallowFileIterator(f);
			String expectedResults="";
			try {
				while(sfi.hasNext())
				{
					expectedResults=expectedResults+sfi.next().getName()+", ";
				}
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println(expectedResults);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Given filepath is not valid");
		}
    	
    	return true;
    	
    }
    
    public static boolean testDeepFileIterator(File f)
    {
    	//f = new File(f.getPath() + File.separator + "assignments");
    	try {
			DeepFileIterator dfi=new DeepFileIterator(f);
			String expectedResults="";
			
			try {
				while(dfi.hasNext())
				{
					
					expectedResults=expectedResults+dfi.next().getName()+", ";
				   
						
					
				}
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println(expectedResults);
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Given filepath is not valid");
		}
    	
    	return true;
    	
    }
    public static boolean testFilteredFileIterator(File f,String pattern)
    {
    	try {
			FilteredFileIterator ffi=new FilteredFileIterator(f, pattern);
			String expectedResults="";
			
			try {
				while(ffi.hasNext())
				{
					expectedResults=expectedResults+ffi.next().getName()+", ";
					
				   
						
					
				}
				
			 } catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println(expectedResults);
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Given filepath is not valid");
		}
    	
    	return true;
    	
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilteredFileIterator implements Iterator<File> {
	DeepFileIterator fileIterator;
	String searchPattern;
	File nextMatchingFile=null;
	public FilteredFileIterator(File f,String searchPattern) throws FileNotFoundException {
		this.searchPattern = searchPattern;
		try {
			fileIterator=new DeepFileIterator(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException();
			
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		nextMatchingFile=null;
      while(nextMatchingFile==null)
      {
	    	
    	  try {	
				while(fileIterator.hasNext())
				{
					nextMatchingFile=fileIterator.next();
					if(nextMatchingFile.getName().contains(".") && nextMatchingFile.getName().lastIndexOf(".")!= 0 && (searchPattern.equals(nextMatchingFile.getName().substring(nextMatchingFile.getName().lastIndexOf(".")))))
					{
						return true;
					}	
					else
					{
						nextMatchingFile=null;
					}	
					
				}	
			  }		
    	  catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				throw new NoSuchElementException();
			 }	
      }
      throw new NoSuchElementException();			
					
	}			
				
			 
			
      
		
	
	@Override
	public File next() {
		// TODO Auto-generated method stub
		return nextMatchingFile;
	}
	

}

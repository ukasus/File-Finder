import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DeepFileIterator implements Iterator<File> {
	File[] folderContents;
	int nextIndex=0;
	DeepFileIterator contentsIterator=null;
	
	public DeepFileIterator(File f) throws FileNotFoundException {
		try {
			folderContents=f.listFiles();
			Arrays.sort(folderContents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException();
		}
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(nextIndex<folderContents.length)
			return true;
	
		
		throw new NoSuchElementException();
	}
	@Override
	public File next() {
		// TODO Auto-generated method stub
		if(folderContents[nextIndex].isDirectory())
		{
			if(contentsIterator==null)
			{
			try {
				contentsIterator=new DeepFileIterator(folderContents[nextIndex]);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				
			}
			try {
				if(contentsIterator.hasNext())
				return contentsIterator.next();
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				contentsIterator=null;
				
			}
			
			}
			else
			{
				try {
					if(contentsIterator.hasNext())
					return contentsIterator.next();
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					contentsIterator=null;
				}
				
			}
		
				
			
		}
		return folderContents[nextIndex++];
	}

}

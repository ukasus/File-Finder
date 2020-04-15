import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class ShallowFileIterator implements Iterator<File> {
	
	File[] folderContents;
	int nextIndex=0;
	

	
	public ShallowFileIterator(File f) throws FileNotFoundException {
		try {
			folderContents=f.listFiles();
			Arrays.sort(folderContents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException();
		}
	}


	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(nextIndex<folderContents.length)
			return true;
		throw new NoSuchElementException();
	}

	
	public File next() {
		// TODO Auto-generated method stub
		return folderContents[nextIndex++];
	}

}

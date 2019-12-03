import java.io.*;
import java.nio.file.*;

/*this class needed to save objects to disk*/
public class Saver {
	private Path path;
	private static Path savePath = Paths.get("/CheckPoint/allsaves");
	FileOutputStream out;
	ObjectOutputStream obstream;
	

	
	
	//checks whether create new file or there is existing one RETURNS FALSE IF CANT CREATE FILE
	private boolean createFile(Savable s) {
		String fileName = s.getFileName();	//gets name from an object to create a file by this name
		path = Paths.get(savePath.toString()+File.separatorChar+fileName);	//get the file itself
		//check if exist or not
		if(Files.exists(path)) {
			return true;
		}else {
			try {
				path = Files.createFile(path);				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("can't create file to save");
				return false;
			}
		}
		return true;
	}

	public boolean saveBook(Book book) {
		
		if(createFile(book)) {
			try {
				out = new FileOutputStream(path.toString());
				obstream = new ObjectOutputStream(out);
				obstream.writeObject(book);
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("didnt save try again");
			}
		}
		return false;
	}

}











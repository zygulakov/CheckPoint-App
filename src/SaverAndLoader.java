import java.io.*;

/*this class needed to save objects to disk*/
public class SaverAndLoader {
	private static final File savePath = new File("allsaves");
	File file;
	FileOutputStream out;
	ObjectOutputStream objOut;
	FileInputStream in;
	ObjectInputStream objIn;

	// checks whether create new file or there is existing one RETURNS FALSE IF CANT
	private boolean createFile(Savable s) {
		String fileName = s.getFileName(); // gets name from an object to create a file by this name
		file = new File(savePath.toString() + File.separatorChar + fileName); // get the file itself
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean saveBook(Book book) {

		if (createFile(book)) {
			try {
				out = new FileOutputStream(file);
				objOut = new ObjectOutputStream(out);
				objOut.writeObject(book);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("didnt save try again");
			}
		}
		return false;
	}

}

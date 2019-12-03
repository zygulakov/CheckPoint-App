import java.io.*;

/*this class needed to save objects to disk*/
public class SaverAndLoader {
	
	private static final File savePath = new File("allsaves");
	private static SaverAndLoader instance ;
	private SaverAndLoader() {
		
	}
	public static SaverAndLoader getInstance() {
		if(instance == null) {
			instance = new SaverAndLoader();
		}
		return instance;
	}
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
				out.close();
				objOut.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("didnt save try again");
			}
		}
		return false;
	}

	public boolean saveMovie(Movie movie) {

		if (createFile(movie)) {
			try {
				out = new FileOutputStream(file);
				objOut = new ObjectOutputStream(out);
				objOut.writeObject(movie);
				out.close();
				objOut.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("didnt save try again");
			}
		}
		return false;
	}

	public Book loadBook(Book book) {
		Book b = null;
		if (createFile(book)) {
			try {
				in = new FileInputStream(file);
				objIn = new ObjectInputStream(in);
				b = (Book) objIn.readObject();
				in.close();
				objIn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("cant load book obj");
			}
		}
		return b;

	}

	public Movie loadMovie(Movie movie) {
		Movie m = null;
		if (createFile(movie)) {
			try {
				in = new FileInputStream(file);
				objIn = new ObjectInputStream(in);
				m = (Movie) objIn.readObject();
				in.close();
				objIn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("cant load movie obj");
			}
		}
		return m;

	}

}

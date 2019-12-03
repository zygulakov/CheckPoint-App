import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Start {

	public static void main(String[] args) throws FileNotFoundException {

		Book b = new Book("book");
		b.setPage(13);
		Saver saver = new Saver();
		saver.saveBook(b);

	}
}

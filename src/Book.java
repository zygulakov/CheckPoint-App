import java.io.Serializable;

public class Book implements Serializable, Savable {
	private final String fileName;
	private int page;
	private String name;

	public String getFileName() {
		return fileName;
	}

	public Book(String name) {
		if (!name.isBlank() && !name.isEmpty()) {
			this.name = name;
			fileName = name + (int) (Math.random() * 100); // name and random num for saving object as file
		} else {
			throw new IllegalArgumentException("book whithout name?");			
		}

	}

	public int getPage() {
		return page;
	}

	// throws IllegalArgumentException if smaller than 0
	public void setPage(int page) {
		if (page > 0) {
			this.page = page;
		} else
			throw new IllegalArgumentException("book whithout pages?");

	}

	public String getName() {
		return name;
	}
	
}

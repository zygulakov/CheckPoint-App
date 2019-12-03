import java.io.Serializable;

public class Book  implements Serializable{
	private final String fileName;
	private int page;
	private String name;
	private String getFileName() {
		return fileName;
	}
	public Book(String name) {
		this.name = name;
		fileName = name + (int)(Math.random() * 100); // name and random num for saving object as file
	}
	
	public int getPage() {
		return page;
	}
	//throws IllegalArgumentException if smaller than 0
	public void setPage(int page) {
		if(page>0) {
			this.page = page;			
		}else
			throw new IllegalArgumentException("book whithout pages?");
		
	}
	public String getName() {
		return name;
	}
	//throws IllegalArgumentException if no name
	public void setName(String name) {
		if(!name.isBlank() && name.isEmpty()) {
			this.name = name;			
		}else 
			throw  new IllegalArgumentException("book whithout name?");
	}
	
}

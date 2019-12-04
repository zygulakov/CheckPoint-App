package com.zy.checkpoint;

public class Book extends BookMovie {

	private static final long serialVersionUID = 1L;
	private final String fileName;
	private int page;

	public Book(String name) {
		super(name);
		this.fileName = super.getFileName();		
	}

	// throws IllegalArgumentException if smaller than 0
	public void set(int page) {
		if (page > 0) {
			this.page = page;
		} else
			throw new IllegalArgumentException("book whithout pages?");

	}

	@Override
	public String toString() {
		return "(BOOK)  " + name +"  "+ page;
	}
}

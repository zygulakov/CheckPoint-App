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
	@Override
	public void set(int ...i) {
		if(i.length>1) {
			throw new IllegalArgumentException("only one integer for this class allowed");
		}
		int page = i[0];
		if (page >=0) {
			this.page = page;
		} else
			throw new IllegalArgumentException("book whithout pages?");

	}

	@Override
	public String toString() {
		return "(BOOK)  " + name +" page: "+ page;
	}
}

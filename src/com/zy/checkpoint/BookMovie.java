package com.zy.checkpoint;

import java.io.Serializable;


//this class made to avoid too much code and increase readability 
public abstract class BookMovie implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String fileName;
	public String name;

	public BookMovie(String name) {
		if (!name.isBlank() && !name.isEmpty()) {
			this.name = name;
			fileName = name + (int) (Math.random() * 100); // name and random num for saving object as file
		} else {
			throw new IllegalArgumentException("where is  name?");
		}
	}

	public String getFileName() {
		return fileName;
	}

	


}

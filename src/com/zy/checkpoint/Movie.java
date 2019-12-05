package com.zy.checkpoint;

public class Movie extends BookMovie {

	private static final long serialVersionUID = 1L;
	private final String fileName;
	private int season;
	private int episode;
	private int minute;

	public Movie(String name) {
		super(name);
		this.fileName = super.getFileName();
	}

	// throws IllegalArgumentException if smaller than 0
	@Override
	public void set(int ...i) {
		if(i.length>3) {
			throw new IllegalArgumentException("only three integer for this class allowed");
		}
		int season = i[0];
		int episode = i[1];
		int minute = i[2];
		if (season > 0 && episode > 0 && minute >= 0) {
			this.season = season;
			this.episode = episode;
			this.minute = minute;
		} else
			new IllegalArgumentException("only minute can be 0!");

	}

	@Override
	public String toString() {
		
		return "(MOVIE)  " + name + "  " + season + "  "+episode+"  "+minute;
	}

}

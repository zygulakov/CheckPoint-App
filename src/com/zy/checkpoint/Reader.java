package com.zy.checkpoint;
import java.io.*;

public class Reader extends Thread {
	private boolean canRead;
	private String str; // string from reader (r)
	private BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static Reader instance;

	private Reader() {
	}

	public static Reader getInstance() { // i wanted to make this class singleton
											// because one instance is enough and wont get messy
		if (instance == null) {
			instance = new Reader();
		}
		return instance;
	}

	// to check if string is ready to read
	public boolean canRead() {
		return canRead;
	}

	// getter sets canRead to false to prevent from reading same string more than
	// once
	public String getString() {
		canRead = false;
		return str;
	}

	// to read from console all the time sets canRead to true u can have the string
	@Override
	public void run() {
		while (!interrupted()) {
			try {

				str = r.readLine();
				if (!str.isEmpty() && !str.isBlank()) {
					canRead = true;
				} else
					System.out.println("for help type <help> ");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("restart app pls(Reader issue)");
			}

		}
	}

}
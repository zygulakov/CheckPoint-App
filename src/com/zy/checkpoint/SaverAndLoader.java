package com.zy.checkpoint;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*this class needed to save objects to disk*/
public class SaverAndLoader {

	private static final File savePath = new File("allsaves");
	private static SaverAndLoader instance;

	private SaverAndLoader() {

	}

	public static SaverAndLoader getInstance() {
		if (instance == null) {
			instance = new SaverAndLoader();
		}
		return instance;
	}

	private File file;
	private FileOutputStream out;
	private ObjectOutputStream objOut;
	private FileInputStream in;
	private ObjectInputStream objIn;

	// checks whether create new file or there is existing one RETURNS FALSE IF CANT
	private boolean createFile(BookMovie s) {
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

	public boolean save(BookMovie mb) {

		if (createFile(mb)) {
			try {
				out = new FileOutputStream(file);
				objOut = new ObjectOutputStream(out);
				objOut.writeObject(mb);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("didnt save try again");
			}
		}
		try {
			out.close();
			objOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// loads all objects from "savePath" to list and returns it
	public List<BookMovie> load() {
		String[] l = savePath.list();
		List<BookMovie> list = new ArrayList<>();
		BookMovie b;
		File f;
		if (l.length > 0) {

			for (String str : l) {
				f = new File(savePath.toString() + File.separatorChar + str);
				try {
					in = new FileInputStream(f);
					objIn = new ObjectInputStream(in);
					b = (BookMovie) objIn.readObject();
					list.add(b);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("cant load book obj");
				}

			}
			try {
				in.close();
				objIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

}

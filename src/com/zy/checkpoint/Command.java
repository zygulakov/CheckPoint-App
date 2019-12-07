package com.zy.checkpoint;

import java.io.File;
import java.util.*;

public class Command {
	public static List<String> listOfCommands = Arrays.asList("add", "remove", "update", "list", "help");
	private HashMap<Integer, BookMovie> items = new HashMap<>();
	private SaverAndLoader s = SaverAndLoader.getInstance();
	private int num;
	public BookMovie getObj(int num) {
		refresh();
		return items.get(num);
	}
	public int getSizeOfItems() {
		return items.size();
	}
	//needed to add numbers to map and also update data after an operation made;
	private void refresh() {
		int refNum = 0;
		HashMap<Integer, BookMovie> itemsR = new HashMap<>();
		for (Map.Entry<Integer, BookMovie> entry : items.entrySet()) {
			refNum++;
			itemsR.put(refNum, entry.getValue());
		}
		items.clear();
		items.putAll(itemsR);
	}

	private boolean init() {
		List<BookMovie> list = s.load();
		if (list.size() > 0) {

			try {
				for (BookMovie bookMovie : list) {
					num++;
					items.put(num, bookMovie);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("cantload items");
				return false;
			}
		}
		return true;
	}

	public Command() {
		init();
	}
	//adds data to item map
	public void add(BookMovie... bm) {
		for (BookMovie bookMovie : bm) {
			num++;
			items.put(num, bookMovie);
		}
		refresh();
	}
	//removes data from items map and refresh it
	public void remove(int... i) {
		for (int n : i) {
			items.remove(n);
		}
		refresh();
	}
	//updates data 
	public void update(int... num) {
		refresh();
		if (num.length == 2) {
			int key = num[0];
			int page = num[1];
			BookMovie b = items.get(key);
			b.set(page);
			items.put(key, b);
		} else if (num.length > 2) {
			int key = num[0];
			int season = num[1];
			int episode = num[2];
			int minute = num[3];
			BookMovie b = items.get(key);
			b.set(season, episode, minute);
			items.put(key, b);
		}

	}
	//lists all data
	public void listItem() {
		if (!items.isEmpty()) {

			for (Map.Entry<Integer, BookMovie> entry : items.entrySet()) {
				int number = entry.getKey();
				BookMovie bm = entry.getValue();
				System.out.println(number + bm.toString());
			}
		} else
			System.out.println("list is empty");
	}

	// removes all files from the file and then saves all new data
	public void done() {
		final File savePath = new File("allsaves");
		for (File file : savePath.listFiles()) {
			file.delete();
		}
		for (Map.Entry<Integer, BookMovie> entry : items.entrySet()) {
			BookMovie mb = entry.getValue();
			s.save(mb);
		}
	}
}

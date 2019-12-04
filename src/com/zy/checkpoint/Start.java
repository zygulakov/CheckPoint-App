package com.zy.checkpoint;
import java.util.List;
import java.io.*;

public class Start {

	public static void main(String[] args) {
		/*
		 * ls // must list what we have by numbers update // must update selected data
		 * add // must add written data remove // must remove selected data
		 */

		Book b1 = new Book("book");
		Book b2 = new Book("bookTwo");
		
		Movie m1 = new Movie("Joker");
		Movie m2 = new Movie("StarWars");
		b1.set(10);
		b2.set(21);
		m1.set(3,3,20);
		m2.set(2,1,40);
		SaverAndLoader s = SaverAndLoader.getInstance();
		s.save(b1);
		s.save(b2);
		s.save(m1);
		s.save(m2);
		
		
		
		List<BookMovie> l = s.load();
		for (BookMovie sa : l) {
			System.out.println(sa.toString());			
		}
		for (BookMovie sa : l) {
			if(sa instanceof Book) {
				Book book = (Book) sa;
				book.set(23);
				s.save(book);
			}else {
				Movie mo = (Movie) sa;
				mo.set(3,2,1);
				s.save(mo);
			}
				
		}
		for (BookMovie sa : l) {
			System.out.println(sa.toString());			
		}
		
		
	}
}
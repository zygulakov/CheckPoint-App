package com.zy.checkpoint;

import java.io.*;
import java.util.List;

public class Reader {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	List<String> listOfCommands = Command.listOfCommands;
	Command comm = new Command();
	String str;
	boolean saved = false;

	public void listen() throws Exception {

		while (!(str = reader.readLine()).equals("exit")) {
			if (listOfCommands.contains(str)) {
				if (str.equalsIgnoreCase("add")) {
					System.out.println("add book or movie ? 1-BOOK  2-MOVIE");
					// while ((str = reader.readLine()).equals("1") || (str =
					// reader.readLine()).equals("2")) {
						str = reader.readLine();
					if (str.equals("1")) {
						System.out.println("whats name of the book?");
						str = reader.readLine();
						Book book = new Book(str);
						System.out.println("last page you red?");
						str = reader.readLine();
						book.set(Integer.parseInt(str));
						comm.add(book);
						System.out.println("Done");
					} else {
						int[] sem = new int[3];
						System.out.println("whats name of the Movie?");
						str = reader.readLine();
						Movie movie = new Movie(str);
						System.out.println("which season?");
						str = reader.readLine();
						sem[0] = Integer.parseInt(str);
						System.out.println("which episode?");
						str = reader.readLine();
						sem[1] = Integer.parseInt(str);
						System.out.println("which minute?");
						str = reader.readLine();
						sem[2] = Integer.parseInt(str);
						movie.set(sem);
						comm.add(movie);
						System.out.println("Done");
					}
					// }

				} else if (str.equalsIgnoreCase("update")) {
					comm.listItem();
					System.out.println("which one you wanna update pls enter number ?");
					str = reader.readLine();
					try {
						int num = Integer.parseInt(str);
						if (num <= comm.getSizeOfItems()) {
							if (comm.getObj(num) instanceof Book) {
								System.out.println(" change to which page ?");
								int num2 = Integer.parseInt(reader.readLine());
								comm.update(num, num2);
								System.out.println("Updated!");
							} else {
								int[] sem = new int[4];
								sem[0] = num;
								System.out.println(" change to what season ?");
								str = reader.readLine();
								sem[1] = Integer.parseInt(str);
								System.out.println("which episode?");
								str = reader.readLine();
								sem[2] = Integer.parseInt(str);
								System.out.println("which minute?");
								str = reader.readLine();
								sem[3] = Integer.parseInt(str);
								comm.update(sem);
								System.out.println("Updated!");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("NUMBER PLS");

					}
				} else if (str.equalsIgnoreCase("remove")) {
					comm.listItem();
					System.out.println("which one you wanna remove pls enter number ?");
					str = reader.readLine();
					try {
						int num = Integer.parseInt(str);
						if (num <= comm.getSizeOfItems()) {
							System.out
									.println(comm.getObj(num).toString() + "   <-- will be REMOVED are you sure? Y/N");
							str = reader.readLine();
							if (str.equalsIgnoreCase("Y")) {
								comm.remove(num);
								System.out.println("removed");
							} else if (str.equalsIgnoreCase("N")) {
								System.out.println("did not removed anything!");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("NUMBER PLS");

					}
				} else if (str.equalsIgnoreCase("list")) {
					System.out.println("HERE IS WHAT WE HAVE!");
					comm.listItem();
				} else if (str.equalsIgnoreCase("save")) {
					comm.done();
					saved = true;
					System.out.println("everything saved !");
				}else if(str.equalsIgnoreCase("HELP")) {
					System.out.println("            *****Help*****");
					System.out.println("to list all your saved items pls type <list>");
					System.out.println("to add item to list pls type <add>");
					System.out.println("to remove item from list pls type <remove>");
					System.out.println("to update item in list pls type <update>");
					System.out.println("to save changes  pls type <save>");
					System.out.println("for help pls type <help>");
					System.out.println("to exit  pls type <exit>");
					System.out.println("Thank You!");
				}
			}
		}
		if (!saved) {

			System.out.println("did you save changes by typing <save> ?   Y/N");
			str = reader.readLine();
			if (str.equalsIgnoreCase("Y")) {
				System.out.println("ok bye");
			} else if (str.equalsIgnoreCase("N")) {
				System.out.println("save changes ?  Y/N");
				str = reader.readLine();
				if (str.equalsIgnoreCase("Y")) {
					comm.done();
					System.out.println("ok saved bye");
				} else if (str.equalsIgnoreCase("N")) {
					System.out.println("changes didnt saved bye");
				}
			}
		}

	}

}

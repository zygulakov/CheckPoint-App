package com.zy.checkpoint;
import java.util.*;

public class Command {
	private static List<String> listOfCommands = Arrays.asList("add","remove","update","list","help");
	private HashMap<Integer,Showable> items = new HashMap<>();
	private boolean init(); 
	public void add();
	public void remove();
	public void update();
	public void listItem();
	
}

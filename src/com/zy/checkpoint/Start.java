package com.zy.checkpoint;

import java.util.List;
import java.io.*;

public class Start {

	public static void main(String[] args) throws Exception {
		Reader reader = new Reader();
		System.out.println("type <help> to see commands ");
		reader.listen();
	}
}
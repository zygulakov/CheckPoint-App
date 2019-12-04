import java.io.*;

public class Start {

	public static class Tread extends Thread {
		@Override
		public void run() {
			while(!interrupted()) {
				System.out.println("sasdfasdf");
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
	Tread a = new Tread();
	a.start();
	Thread.sleep(1000);
	a.interrupt();
	
	}
}
import java.io.*;

public class Reader extends Thread {
	private boolean breaker = true; 		// if something goes wrong to stop reader
	private boolean canRead ;
	private String str; 					// string from reader (r)
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	
	// to check if string is ready to read
	public boolean canRead() {
		return canRead;
	}
	// getter    sets canRead to  false to prevent from reading same string more than once
	public String getString() {
		canRead = false;
		return str;
	}
	
	//to read from console all the time    sets canRead to true u can have the string 
	@Override
	public void run()  {
		while(breaker) {
			try {
				
				str = r.readLine();
				if(!str.isEmpty() && !str.isBlank()) {
					canRead = true;					
				}else System.out.println("try not matching word foung for help type <help> ");
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("restart app pls(Reader issue)");
			}
			
		}
	}
	
}
package application;
import java.io.*;
import java.util.Random;

public class IDGenerator {
	private static int START = 1000; 
	
	/**
	 * Create new User name. 3 Random letters and a count to ensure it is
	 * always a unique user name. 
	 * 
	 * @return user name
	 */
	public static String generate()
	{
		String letters = "abcdefghijklmnopqrstuvwxyz"; 
		Random random = new Random();
		
		int count = getMaxCount(); 
		String prefix = ""; 
		for(int i=0; i<3; i++) {
			prefix += letters.charAt(random.nextInt(letters.length()));
		}
		
		if(count == 0) {
			count += START + 1;
		} else {
			count += 1;
		}
		
		return String.format("%s%d", prefix, count); 
	}
	
	/**
	 * Function to count the number of files stored in the decisions folder. 
	 * 
	 * @return number of IDS generated. 
	 */
	public static int getMaxCount() {
		int count = 0; 
		
		try {
			File file = new File("decisions"); 
			return file.listFiles().length;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
}

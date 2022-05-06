package application;

import java.io.*;
import java.util.*;

/**
 * Class to manage the File Io for the Admission Applications. 
 * 
 * @author Programmer
 *
 */

public class FileIO {
	
	private static final String DIR = "decisions/";
	private static final String DICT_FILE = "dictionary.txt";
	
	/**
	 * Function to save the application to the file. 
	 * 
	 * @param application
	 */
	public static void saveToFile(AdmissionApplication application) {
		
		try {
			String fileName = application.getPerson().getFirstName() + "_" + 
					application.getPerson().getLastName() + "_" + 
					application.getDecision() +".txt"; 
			
			File file = new File(DIR + fileName); 
			
			PrintStream stream = new PrintStream(file); 
			stream.println(application.getStaus().toString());
			stream.print(application.getPerson().toString());
			
			if(application.getAddress() != null) {
				stream.print(application.getAddress().toString());
			}
			
			if(application.getScore() != null) {
				stream.print(application.getScore().toString());
			}
			
			if(application.getEssay() != null) {
				stream.print(application.getEssay().toString());
			}
			
			stream.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to load all the applications form the disc files. 
	 * 
	 * @return collection of applications. 
	 */
	public static Map<String, AdmissionApplication> loadApplications() {
		Map<String, AdmissionApplication> map = new TreeMap<>();
		
		try {
			
			// load directory
			File dir = new File(DIR); 
			
			// Iterate each file. 
			for(String name: dir.list()) {
				loadFile(map, name);
			}
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * Load a Single AdmissionApplication from the File. 
	 * 
	 * @param map of applications
	 * @param name of file
	 */
	private static void loadFile(Map<String, AdmissionApplication> map, String name) {
		
		try {
			File file = new File(DIR + name); 
			Scanner reader = new Scanner(file); 
			
			// Read status
			String status = reader.nextLine();
			AdmissionApplication app = new AdmissionApplication();
			
			if(status.equalsIgnoreCase(Status.Person.toString())) {
				app.setStaus(Status.Person);
				readPerson(reader, app);
			} else if(status.equalsIgnoreCase(Status.Address.toString())) {
				app.setStaus(Status.Address);
				
				readPerson(reader, app);
				readAddress(reader, app);
			} else if(status.equalsIgnoreCase(Status.Scores.toString())) {
				app.setStaus(Status.Scores);
				
				readPerson(reader, app);
				readAddress(reader, app);
				readScore(reader, app);
			} else if(status.equalsIgnoreCase(Status.Complete.toString())) {
				app.setStaus(Status.Complete);
				
				readPerson(reader, app);
				readAddress(reader, app);
				readScore(reader, app);
				readEssay(reader, app);
			}
			
			map.put(app.getPerson().getUserId(), app);
			
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read Address 
	 * 
	 * @param reader
	 * @param app
	 */
	private static void readAddress(Scanner reader, AdmissionApplication app) {
		
		Address address = new Address();
		
		String line = reader.nextLine();
		String token = line.substring(49); 
		address.setPhoneNumber(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		address.setLineOne(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		address.setLineTwo(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		address.setCity(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		address.setState(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		address.setPostCode(token.trim());
		
		app.setAddress(address);
	}
	
	/**
	 * Read Scores 
	 * 
	 * @param reader
	 * @param app
	 */
	private static void readScore(Scanner reader, AdmissionApplication app) {
		Score score = new Score();
		
		String line = reader.nextLine();
		String token = line.substring(49); 
		score.setGpa(Double.parseDouble(token.trim()));
		
		line = reader.nextLine();
		token = line.substring(49); 
		score.setSatScore(Integer.parseInt(token.trim()));
		
		line = reader.nextLine();
		token = line.substring(49); 
		score.setFamilyIncome(Double.parseDouble(token.trim()));
		
		app.setScore(score);
	}
	
	/**
	 * Read essay scores
	 * 
	 * @param reader
	 * @param app
	 */
	private static void readEssay(Scanner reader, AdmissionApplication app) {
		
		Essay essay = new Essay();
		
		String line = reader.nextLine();
		String token = line.substring(49); 
		essay.setScore(Double.parseDouble(token.trim()));
		
		line = reader.nextLine();
		token = line.substring(49); 
		essay.setErrors(Integer.parseInt(token.trim()));
		
		app.setEssay(essay);		
	}
	
	
	/**
	 * Function to read a Person data from file. 
	 * 
	 * @param reader
	 * @param app
	 */
	private static void readPerson(Scanner reader, AdmissionApplication app) {
		
		Person person = new Person();
		
		String line = reader.nextLine();
		String token = line.substring(49); 
		person.setFirstName(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		person.setLastName(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		person.setEmail(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		person.setUserId(token.trim());
		
		line = reader.nextLine();
		token = line.substring(49); 
		person.setPassword(token.trim());
		
		System.out.println(person);
		app.setPerson(person);
	}
	
	public static Map<String, String> getDictionary() {
		Map<String, String> dict = new TreeMap<String, String>();
		
		try {
			File file = new File(DICT_FILE);
			Scanner reader = new Scanner(file); 
			
			while(reader.hasNextLine()) {
				String word = reader.nextLine().trim();
				
				dict.put(word.toLowerCase(), word.toLowerCase());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return dict;
	}
}

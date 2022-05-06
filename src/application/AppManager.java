package application;

import java.util.*;

public class AppManager {
	private Map<String, AdmissionApplication> applications;
	
	public AppManager() {
		this.applications = FileIO.loadApplications();
	}
	
	public void addApplication(AdmissionApplication app) {
		this.applications.put(app.getPerson().getUserId(), app);
		FileIO.saveToFile(app);
	}
	
	public AdmissionApplication login(String userId, String password) {
		
		for(String key: applications.keySet()) {
			AdmissionApplication app = applications.get(key);
			Person person = app.getPerson();
			
			if(person.getUserId().equals(userId) && 
					person.getPassword().equals(password)) {
				return app;
			}
		}
		
		return null; 
	}
}

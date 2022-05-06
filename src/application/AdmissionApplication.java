package application;

public class AdmissionApplication {
	
	private Person person;
	private Address address;
	private Score score;
	private Essay essay;
	private Status staus;
	private String decision;
	
	public AdmissionApplication() {
		this.decision = "waiting";
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Score getScore() {
		return score;
	}
	
	public void setScore(Score score) {
		this.score = score;
	}
	
	public Essay getEssay() {
		return essay;
	}
	
	public void setEssay(Essay essay) {
		this.essay = essay;
	}
	
	public Status getStaus() {
		return staus;
	}
	
	public void setStaus(Status staus) {
		this.staus = staus;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	public boolean isAccepted() {
		
		if(this.getScore().getGpa() >= 3.5 && this.essay.getScore() < 60 && this.essay.getErrors() < 3 && 
				this.score.getFamilyIncome() >= 100000 && this.score.getSatScore() >= 1200) 
			return true; 
		
		return false; 
	}
	
	public boolean isRejected() {
		
		if(this.score.getGpa() < 2.5 && this.essay.getScore() > 70 && 
				this.essay.getErrors() > 10 && this.score.getFamilyIncome() < 10000 
			 && this.score.getSatScore() < 800) {
			return true; 
		}
		
		return false; 
	}
	
	public int calculateAIScore() {
		int AI = 0; 
		
		// increase 2 points for each 0.1
		double gpa = this.score.getGpa();
		AI = (int) ((gpa / 0.1) * 2); 
		
		// fletch points: 2 point each for every 10 points
		double fPoints = this.essay.getScore() / 10;
		AI -= (int)(fPoints * 2);
		
		// errors 1 point each
		int errors = this.essay.getErrors(); 
		AI -= errors; 
		
		// Family income: every 10,000 1 point increase
		AI += (int) (this.score.getFamilyIncome()/10000);
		
		// Sat Score 1 point every 100 increase
		AI += (int)(this.score.getSatScore() / 100); 
		
		return AI;
	}
	
	public void doDecide() {
		if(this.isAccepted()) {
			this.decision = "Accepted"; 
		} else if(this.isRejected()) {
			this.decision = "Rejected";
		} else {
			this.decision = "Waiting";
		}
	}
	
	public String toString() {
		
		String output = "Personal Info: \n";
		output += person.toString(); 
		
		output += "Address: \n";
		output += address.toString();
		
		output += "Scores:\n";
		output += score.toString();
		
		output += "Essay Scores: \n";
		output += essay.toString(); 
	
		output += "\nResult:\n";
		output += "Decision: " + decision + "\n"; 
		
		if(decision.equalsIgnoreCase("waiting")) {
			output += "AI Score: " + String.format("%d", calculateAIScore());
		}
		
		return output;
	}
}

package application;

public class Essay {
	
	private String essay;
	private double score; 
	private int errors; 
	
	public void calcScores() {
		score = FleschScore.calcScores(essay);
		errors = FleschScore.countErrors();
	}
	
	public int getErrors() {
		return errors;
	}

	public void setErrors(int errors) {
		this.errors = errors;
	}

	public String getEssay() {
		return essay;
	}

	public void setEssay(String essay) {
		this.essay = essay;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	} 
	
	public String toString() {
		String output = String.format("%-50s%.2f%n", "Essay Score:", score);
		output += String.format("%-50s%d%n", "Error Per 100 Words:", errors); 
		
		return output; 
	}
}

package application;

public class Score {
	
	private double gpa; 
	private int satScore; 
	private double familyIncome;
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public int getSatScore() {
		return satScore;
	}
	
	public void setSatScore(int satScore) {
		this.satScore = satScore;
	}
	
	public double getFamilyIncome() {
		return familyIncome;
	}
	
	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}
	
	public String toString() {
		String output = String.format("%-50s%.2f%n", "GPA:", gpa);
		output += String.format("%-50s%d%n", "SAT Score:", satScore);
		output += String.format("%-50s%.2f%n", "Family Income:", familyIncome);
		return output; 
	}
}

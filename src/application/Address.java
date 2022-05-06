package application;

public class Address {
	
	private String phoneNumber; 
	private String lineOne; 
	private String lineTwo; 
	private String city; 
	private String state; 
	private String postCode;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getLineOne() {
		return lineOne;
	}
	
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	
	public String getLineTwo() {
		return lineTwo;
	}
	
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public String toString() {
		String output = String.format("%-50s%s%n", "Phone Number:", phoneNumber);
		output += String.format("%-50s%s%n", "Line One:", lineOne);
		output += String.format("%-50s%s%n", "Line Two:", lineTwo);
		output += String.format("%-50s%s%n", "City:", city);
		output += String.format("%-50s%s%n", "State:", state);
		output += String.format("%-50s%s%n", "Post Code:", postCode);
		return output;
	}
}

package application;

public class Person {
	
	private String userId; 
	private String firstName;
	private String lastName; 
	private String email; 
	private String password;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Function to convert this string for file string. 
	 * 
	 * @return string representation
	 */
	public String toString() {
		String output = String.format("%-50s%s%n", "First Name:", firstName);
		output += String.format("%-50s%s%n", "Last Name:", lastName);
		output += String.format("%-50s%s%n", "Email Name:", email);
		output += String.format("%-50s%s%n", "User id:", userId);
		output += String.format("%-50s%s%n", "Password:", password);
		return output;
	}
}

package application;
	

import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	
	// Top Level Components
	private Stage stage; 
	private FlowPane root; 
	
	
	// first window labels
	private Label lblUserName;
	private Label lblFirstName;
	private Label lblLastName; 
	private Label lblEmail; 
	private Label lblPassword;
	
	// second window labels
	private Label lblPhoneNumber;
	private Label lblLineOne;
	private Label lblLineTwo;
	private Label lblCity;
	private Label lblState;
	private Label lblPostCode;
	
	// third window labels
	private Label lblGPA;
	private Label lblSatScore;
	private Label lblFamilyIncome;
	
	// fourth window labels
	private Label lblEssay;
	
	// Login window Labels
	private Label lblLoginUserName;
	private Label lblLoginPassword;
	
	// First Window text boxes
	private TextField txtUserName;
	private TextField txtFirstName;
	private TextField txtLastName;
	private TextField txtEmail;
	private PasswordField txtPassword;
	
	// First Window text boxes
	private TextField txtPhoneNumber;
	private TextField txtLineOne;
	private TextField txtLineTwo;
	private TextField txtCity;
	private TextField txtState;
	private TextField txtPostCode;
	
	// First Window text boxes
	private TextField txtGPA;
	private TextField txtSatScore;
	private TextField txtFamilyIncome;
	
	// First Window text boxes
	private TextArea txtEssay;
	private TextArea txtResult; 
	private Label lblResult; 
	
	// Login Window text boxes
	private TextField txtLoginUserName;
	private PasswordField  txtLoginPassword;
	
	private Button btnCreateAccount;
	private Button btnSaveAddress;
	private Button btnLogin;
	private Button btnSaveScores;
	private Button btnProcessEssay;
	private Button btnClose;
	private Button btnRegister;
	private Button btnBack;
	
	private Font font = Font.font("Ariel", 20);
	private Font font1 = Font.font("Courier New", 11);
	
	// Map of applications
	private AppManager manager;
	private AdmissionApplication app;
	
	@Override
	public void start(Stage primaryStage) {
		try {
				
			// Create First Window			
			root = new FlowPane();
			root.setVgap(10);
			root.setHgap(10);
			root.setPadding(new Insets(10, 10, 10, 10));
			root.setAlignment(Pos.CENTER);
			
			// Create & show Login Screen. 
			createLoginScreen();
			
			// Create manager
			manager = new AppManager();
			
			Scene scene = new Scene(root,500,500);
			stage = primaryStage;
			stage.setScene(scene);
			stage.setTitle("Admission Management System");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to create Person Screen and display it. 
	 */
	private void createPersonScreen() {
		Label lblMain = new Label("Account Registration"); 
		lblMain.setPrefSize(480, 30);
		lblMain.setFont(font);
		lblMain.setAlignment(Pos.CENTER);
		
		this.lblUserName = new Label("User Name: ");
		this.lblUserName.setPrefSize(200, 30);
		this.lblUserName.setAlignment(Pos.CENTER_LEFT);
		
		this.txtUserName = new TextField();
		this.txtUserName.setPrefSize(200, 30);
		this.txtUserName.setEditable(false);
		
		this.lblPassword = new Label("Password: ");
		this.lblPassword.setPrefSize(200, 30);
		this.lblPassword.setAlignment(Pos.CENTER_LEFT);
		
		this.txtPassword = new PasswordField();
		this.txtPassword.setPrefSize(200, 30);
		
		this.lblFirstName = new Label("First Name: ");
		this.lblFirstName.setPrefSize(200, 30);
		this.lblFirstName.setAlignment(Pos.CENTER_LEFT);
		
		this.txtFirstName = new TextField();
		this.txtFirstName.setPrefSize(200, 30);
		
		this.lblLastName = new Label("Last Name: ");
		this.lblLastName.setPrefSize(200, 30);
		this.lblLastName.setAlignment(Pos.CENTER_LEFT);
		
		this.txtLastName = new TextField();
		this.txtLastName.setPrefSize(200, 30);
		
		this.lblEmail = new Label("Email: ");
		this.lblEmail.setPrefSize(200, 30);
		this.lblEmail.setAlignment(Pos.CENTER_LEFT);
		
		this.txtEmail = new TextField();
		this.txtEmail.setPrefSize(200, 30);
		
		this.btnCreateAccount = new Button("Create Account");
		this.btnCreateAccount.setPrefSize(130, 30);
		this.btnCreateAccount.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            createAccount();
	        }
	    });
		
		this.btnBack = new Button("Back");
		this.btnBack.setPrefSize(130, 30);
		this.btnBack.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	createLoginScreen();
	        }
	    });
		
		
		// Set the User's user name
		this.txtUserName.setText(IDGenerator.generate());
		
		this.root.getChildren().clear();
		this.root.getChildren().add(lblMain);
		this.root.getChildren().add(this.lblFirstName);
		this.root.getChildren().add(this.txtFirstName);
		this.root.getChildren().add(this.lblLastName);
		this.root.getChildren().add(this.txtLastName);
		this.root.getChildren().add(this.lblUserName);
		this.root.getChildren().add(this.txtUserName);
		this.root.getChildren().add(this.lblPassword);
		this.root.getChildren().add(this.txtPassword);
		this.root.getChildren().add(this.lblEmail);
		this.root.getChildren().add(this.txtEmail);
		this.root.getChildren().add(this.btnCreateAccount);
		this.root.getChildren().add(this.btnBack);
	}
	
	/**
	 * Function to create Address Screen. 
	 */
	private void createAddressScreen() {
		Label lblMain = new Label("Submit Your Address"); 
		lblMain.setPrefSize(480, 30);
		lblMain.setFont(font);
		lblMain.setAlignment(Pos.CENTER);
		
		this.lblPhoneNumber = new Label("Phone Number: ");
		this.lblPhoneNumber.setPrefSize(200, 30);
		this.lblPhoneNumber.setAlignment(Pos.CENTER_LEFT);
		
		this.txtPhoneNumber = new TextField();
		this.txtPhoneNumber.setPrefSize(200, 30);
		
		this.lblLineOne = new Label("Line One: ");
		this.lblLineOne.setPrefSize(200, 30);
		this.lblLineOne.setAlignment(Pos.CENTER_LEFT);
		
		this.txtLineOne = new TextField();
		this.txtLineOne.setPrefSize(200, 30);
		
		this.lblLineTwo = new Label("Line Two: ");
		this.lblLineTwo.setPrefSize(200, 30);
		this.lblLineTwo.setAlignment(Pos.CENTER_LEFT);
		
		this.txtLineTwo = new TextField();
		this.txtLineTwo.setPrefSize(200, 30);
		
		this.lblCity = new Label("City: ");
		this.lblCity.setPrefSize(200, 30);
		this.lblCity.setAlignment(Pos.CENTER_LEFT);
		
		this.txtCity = new TextField();
		this.txtCity.setPrefSize(200, 30);
		
		this.lblState = new Label("State: ");
		this.lblState.setPrefSize(200, 30);
		this.lblState.setAlignment(Pos.CENTER_LEFT);
		
		this.txtState = new TextField();
		this.txtState.setPrefSize(200, 30);
		
		this.lblPostCode = new Label("Post Code: ");
		this.lblPostCode.setPrefSize(200, 30);
		this.lblPostCode.setAlignment(Pos.CENTER_LEFT);
		
		this.txtPostCode = new TextField();
		this.txtPostCode.setPrefSize(200, 30);
		
		this.btnBack = new Button("Back");
		this.btnBack.setPrefSize(130, 30);
		this.btnBack.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	createLoginScreen();
	        }
	    });
		
		this.btnSaveAddress = new Button("Save Address");
		this.btnSaveAddress.setPrefSize(130, 30);
		this.btnSaveAddress.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	saveAddress();
	        }
	    });
		
		this.root.getChildren().clear();
		this.root.getChildren().add(lblMain);
		this.root.getChildren().add(this.lblPhoneNumber);
		this.root.getChildren().add(this.txtPhoneNumber);
		this.root.getChildren().add(this.lblLineOne);
		this.root.getChildren().add(this.txtLineOne);
		this.root.getChildren().add(this.lblLineTwo);
		this.root.getChildren().add(this.txtLineTwo);
		this.root.getChildren().add(this.lblCity);
		this.root.getChildren().add(this.txtCity);
		this.root.getChildren().add(this.lblState);
		this.root.getChildren().add(this.txtState);
		this.root.getChildren().add(this.lblPostCode);
		this.root.getChildren().add(this.txtPostCode);
		this.root.getChildren().add(this.btnSaveAddress);
		this.root.getChildren().add(this.btnBack);
	}
	
	/**
	 * Function to create and display Score Screen. 
	 */
	private void createScoreScreen() {
		Label lblMain = new Label("Submit Your Score Details"); 
		lblMain.setPrefSize(480, 30);
		lblMain.setFont(font);
		lblMain.setAlignment(Pos.CENTER);
		
		this.lblGPA = new Label("GPA: ");
		this.lblGPA.setPrefSize(200, 30);
		this.lblGPA.setAlignment(Pos.CENTER_LEFT);
		
		this.txtGPA = new TextField();
		this.txtGPA.setPrefSize(200, 30);
		
		this.lblSatScore = new Label("SAT Score: ");
		this.lblSatScore.setPrefSize(200, 30);
		this.lblSatScore.setAlignment(Pos.CENTER_LEFT);
		
		this.txtSatScore = new TextField();
		this.txtSatScore.setPrefSize(200, 30);
		
		this.lblFamilyIncome = new Label("Family Income: ");
		this.lblFamilyIncome.setPrefSize(200, 30);
		this.lblFamilyIncome.setAlignment(Pos.CENTER_LEFT);
		
		this.txtFamilyIncome = new TextField();
		this.txtFamilyIncome.setPrefSize(200, 30);
		
		this.btnBack = new Button("Back");
		this.btnBack.setPrefSize(130, 30);
		this.btnBack.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	createLoginScreen();
	        }
	    });
		
		this.btnSaveScores = new Button("Save Scores");
		this.btnSaveScores.setPrefSize(130, 30);
		this.btnSaveScores.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	saveScores();
	        }
	    });
	
		this.root.getChildren().clear();
		this.root.getChildren().add(lblMain);
		this.root.getChildren().add(this.lblGPA);
		this.root.getChildren().add(this.txtGPA);
		this.root.getChildren().add(this.lblSatScore);
		this.root.getChildren().add(this.txtSatScore);
		this.root.getChildren().add(this.lblFamilyIncome);
		this.root.getChildren().add(this.txtFamilyIncome);
		this.root.getChildren().add(this.btnSaveScores);
		this.root.getChildren().add(this.btnBack);
	}
	
	/**
	 * Function to create an Essay Screen. 
	 */
	private void createEssayScreen() {
		Label lblMain = new Label("Submit Your Score Details"); 
		lblMain.setPrefSize(480, 30);
		lblMain.setFont(font);
		lblMain.setAlignment(Pos.CENTER);
		
		this.lblEssay = new Label("Enter Essay: ");
		this.lblEssay.setPrefSize(400, 30);
		this.lblEssay.setAlignment(Pos.CENTER_LEFT);
		
		this.txtEssay = new TextArea();
		this.txtEssay.setPrefSize(460, 350);
		
		this.btnBack = new Button("Back");
		this.btnBack.setPrefSize(130, 30);
		this.btnBack.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	createLoginScreen();
	        }
	    });
		
		this.btnProcessEssay = new Button("Calculate Scores");
		this.btnProcessEssay.setPrefSize(130, 30);
		this.btnProcessEssay.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	processEssay();
	        }
	    });
	
		this.root.getChildren().clear();
		this.root.getChildren().add(lblMain);
		this.root.getChildren().add(this.lblEssay);
		this.root.getChildren().add(this.txtEssay);
		this.root.getChildren().add(this.btnProcessEssay);
		this.root.getChildren().add(this.btnBack);
	}
	
	/**
	 * Function to create a Result Screen to show the application status. 
	 */
	private void createResultScreen() {
		Label lblMain = new Label("Application Result"); 
		lblMain.setPrefSize(480, 30);
		lblMain.setFont(font);
		lblMain.setAlignment(Pos.CENTER);
		
		this.lblResult = new Label("Result: ");
		this.lblResult.setPrefSize(400, 30);
		this.lblResult.setAlignment(Pos.CENTER_LEFT);
		
		this.txtResult = new TextArea();
		this.txtResult.setPrefSize(460, 350);
		this.txtResult.setFont(font1);
		
		this.btnBack = new Button("Back");
		this.btnBack.setPrefSize(130, 30);
		this.btnBack.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	createLoginScreen();
	        }
	    });
		
		this.txtResult.setText(app.toString());
	
		this.root.getChildren().clear();
		this.root.getChildren().add(lblMain);
		this.root.getChildren().add(this.lblResult);
		this.root.getChildren().add(this.txtResult);
		this.root.getChildren().add(this.btnBack);
	}
	
	/**
	 * Function to create Login Screen and display it. 
	 */
	private void createLoginScreen() {
		
		Label lblMain = new Label("Login Form"); 
		lblMain.setPrefSize(480, 30);
		lblMain.setFont(font);
		lblMain.setAlignment(Pos.CENTER);
		
		this.lblLoginUserName = new Label("User Name: ");
		this.lblLoginUserName.setPrefSize(200, 30);
		this.lblLoginUserName.setAlignment(Pos.CENTER_LEFT);
		
		this.txtLoginUserName = new TextField();
		this.txtLoginUserName.setPrefSize(200, 30);

		this.lblLoginPassword = new Label("Password: ");
		this.lblLoginPassword.setPrefSize(200, 30);
		this.lblLoginPassword.setAlignment(Pos.CENTER_LEFT);
		
		this.txtLoginPassword = new PasswordField();
		this.txtLoginPassword.setPrefSize(200, 30);
		
		this.btnLogin = new Button("Login");
		this.btnLogin.setPrefSize(130, 30);
		this.btnLogin.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            doLogin();
	        }
	    });
		
		this.btnRegister = new Button("Register");
		this.btnRegister.setPrefSize(130, 30);
		this.btnRegister.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            createPersonScreen();
	        }
	    });
		
		
		this.btnClose = new Button("Close");
		this.btnClose.setPrefSize(130, 30);
		this.btnClose.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	            System.exit(0);
	        }
	    });
		
		this.root.getChildren().clear();
		this.root.getChildren().add(lblMain);
		this.root.getChildren().add(this.lblLoginUserName);
		this.root.getChildren().add(this.txtLoginUserName);
		this.root.getChildren().add(this.lblLoginPassword);
		this.root.getChildren().add(this.txtLoginPassword);
		this.root.getChildren().add(this.btnLogin);
		this.root.getChildren().add(this.btnRegister);
		this.root.getChildren().add(this.btnClose);
	}
	
	private void processEssay() {
		
		String text = this.txtEssay.getText();
		
		// validate
		if(!isPresent(text)) {
			showError("Provide Essay to calculate score");
			return;
		}
		
		Essay essay = new Essay();
		essay.setEssay(text);
		essay.calcScores();
		
		app.setEssay(essay);
		app.setStaus(Status.Complete);
		app.doDecide();
		manager.addApplication(app);
		
		// Go to Result Screen
		createResultScreen();
	}
	
	/**
	 * Perform the Login for a given user. If the Application is complete display the 
	 * result screen. If the application is not complete then display corresponding
	 * screen. 
	 */
	private void doLogin() {
		
		// Parse Values
		String userId = this.txtLoginUserName.getText();
		String password = this.txtLoginPassword.getText();
		
		app = manager.login(userId, password); 
		
		if(app == null) {
			showError("Login Failed - Try again or Register"); 
			txtLoginUserName.setText("");
			txtLoginPassword.setText("");
			return;
		}
		
		// Based on status open appropriate window
		if(app.getStaus() == Status.Person) {
			createAddressScreen();
		} else if(app.getStaus() == Status.Address) {
			createScoreScreen();
		} else if(app.getStaus() == Status.Scores) {
			createEssayScreen();
		} else if(app.getStaus() == Status.Complete) {
			createResultScreen();
		}
	}
	
	/**
	 * Function to create personal Account and manage the data saving from 
	 * the Personal Information Screen. 
	 */
	private void createAccount() {
		// Parse values
		String firstName = this.txtFirstName.getText();
		String lastName = this.txtLastName.getText();
		String userId = this.txtUserName.getText();
		String password = this.txtPassword.getText();
		String email = this.txtEmail.getText();
		
		// validate
		if(!isPresent(firstName)) {
			showError("Provide First Name");
			return;
		}
		
		if(!isPresent(lastName)) {
			showError("Provide Last Name");
			return;
		}
		
		if(!isPresent(email)) {
			showError("Provide Email");
			return;
		}
		
		if(!isPresent(password) || !isValidPassword(password)) {
			showError("Provide a valid Password");
			return;
		}
		
		Person person = new Person();
		person.setUserId(userId);
		person.setPassword(password);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);
		
		app = new AdmissionApplication();
		app.setPerson(person);
		app.setStaus(Status.Person);
		
		manager.addApplication(app);
		
		// show message
		showMessage("Your account has been created");
		
		// Move to Address Window
		createAddressScreen();
	}
	
	/**
	 * Save address of a given User. 
	 */
	private void saveAddress() {
		
		// parse values
		String phoneNumber = this.txtPhoneNumber.getText();
		String lineOne = this.txtLineOne.getText();
		String lineTwo = this.txtLineTwo.getText();
		String city = this.txtCity.getText();
		String state = this.txtState.getText();
		String postCode = this.txtPostCode.getText();
		
		if(!isPresent(phoneNumber)) {
			showError("Provide Your Phone Number");
			return;
		}
		
		if(!isPresent(lineOne)) {
			showError("Provide address line one");
			return;
		}
		
		if(!isPresent(lineTwo)) {
			showError("Provide address Line Two");
			return;
		}
		
		if(!isPresent(city)) {
			showError("Provide City");
			return;
		}
		
		if(!isPresent(state)) {
			showError("Provide State");
			return;
		}
		
		if(!isPresent(postCode)) {
			showError("Provide Post");
			return;
		}
		
		Address address = new Address();
		address.setPhoneNumber(phoneNumber);
		address.setLineOne(lineOne);
		address.setLineTwo(lineTwo);
		address.setCity(city);
		address.setState(state);
		address.setPostCode(postCode);
		
		app.setAddress(address);
		app.setStaus(Status.Address);
		manager.addApplication(app);
				
		showMessage("You address has been saved");
		
		createScoreScreen();
	}
	
	/**
	 * Save The Scores of the User. 
	 */
	private void saveScores() {
		
		try {
			
			// Parse values
			String strGPA = this.txtGPA.getText();
			String strSatScore = this.txtSatScore.getText();
			String strIncome = this.txtFamilyIncome.getText();
			
			// convert
			double gpa = Double.parseDouble(strGPA);
			double income = Double.parseDouble(strIncome);
			int satScore = Integer.parseInt(strSatScore);
			
			// GPA 0-4
			if(gpa < 0 || gpa > 4) {
				showError("Please enter valid GPA value between 0.0 to 4.0");
				return; 
			}
			
			// Income must be >= 0
			if(income < 0) {
				showError("Please a Non-Negative value for Income");
				return;
			}
			
			// Sat Score 400-1600
			if(satScore < 400 || satScore > 1600) {
				showError("Please enter a valie SAT Score between 400-1600");
				return;
			}
			
			Score score = new Score();
			score.setGpa(gpa);
			score.setSatScore(satScore);
			score.setFamilyIncome(income);
			
			app.setScore(score);
			app.setStaus(Status.Scores);
			manager.addApplication(app);
			
			showMessage("Your Score values are stored");
			
			// move to Essay Screen. 
			createEssayScreen();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			showError(e.toString());
		}
	}
	
	
	/**
	 * Show an error Message
	 * 
	 * @param message
	 */
	private void showError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(message);
		alert.show();
	}
	
	/**
	 * Function to show an Information Message. 
	 * 
	 * @param message
	 */
	private void showMessage(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setContentText(message);
		alert.show();
	}
	
	/**
	 * Validate that a given string is not empty or null. 
	 * 
	 * @param token
	 * @return
	 */
	private boolean isPresent(String token) {
		return token != null && token.length() > 0;
	}
	
	/**
	 * Function to validate that a password meets the requirements of 
	 *  at least 7 characters
	 *  at least 1 upper case
	 *  at least 1 lower case 
	 *  at least 1 digit
	 *  
	 *  
	 * @param password
	 * @return
	 */
	private boolean isValidPassword(String password) {
		
		if(password.length() < 7) {
			return false; 
		}
		
		int uCount = 0; 
		int lCount = 0; 
		int dCount = 0; 
		
		for(int i=0; i<password.length(); i++) {
			char c = password.charAt(i);
			
			if(Character.isUpperCase(c)) uCount++;
			else if(Character.isLowerCase(c)) lCount++;
			else if(Character.isDigit(c)) dCount++;
		}
		
		return uCount >= 1 && lCount >= 1 && dCount >= 1;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

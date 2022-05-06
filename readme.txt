Implementation:
--------------------------

The implementation of the project has been carried out using pure Object Oriented paradigm. 
The application has been divided into multiple classes to represent different entities. There
are controller classes to contorl the application logic. Main classes are:

	Address.java
	Person.java
	Score.java
	Essay.java
	AdmissionApplication.java
	Status.java
	
	Control & logic classes:
	
	FileIO.java
	FleschScore.java
	AppManager.java
	IDGenerator.java
	
	UI Class:
	
	Main.java
	
How it Works:
----------------------
When application starts, It reads all the files from decisions folder. Each file represent
one application. All these applications are stored into the Map object for efficient searching. 
When a User login: The application deterine the status of the applicaiton and invoke the 
corresponding screen for data input to get the missing information from the user. If the application
is completed previously the user will be taken to the result screen. 

There are total 6 screens in this application. 

1. Login Screen. 
2. Personal Information input screen. 
3. Address information input screen. 
4. Scores Input Screen. 
5. Essay Input Screen. 
6. Result Screen. 
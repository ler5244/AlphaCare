# Alphacare

## Dependencies Required to Run the Application
1. This application makes use of the GSON library, which can be found here: https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/
(gson-2.6.2.jar)

## Running the Application
1. Download the zip or clone the repo
2. Extract the zip file (if the zipped folder was downloaded)
3. Open up the folder in netbeans
4. If "resolve project problems" comes up, click on it and open the window.
5. Point the missing jar file (gson-2.6.2.jar) to the location of where it was downloaded
6. Click on resolve

## Refactors
1. We went through every single method in every class and added documentation for them
2. 
3. The README has been updated to include setup instructions along with information regarding the dependencies
4. When the user logs in successfully, the NavigationUI.fxml file now has a label on the top informing the user they are loggged in
5. In the CreateAccountUIController, we added a regex check on the email string to determine if the user inputted email is valid
6. In the NavigationUIController, the functionality to exit the application from the logout button has been added
7. 
8. 
9. We have added an extra text field to confirm their password and in the CreateAccountUIController, it checks if the passwords match before the account can be created
10. There is now a field for adding the user's address when they are creating their account  

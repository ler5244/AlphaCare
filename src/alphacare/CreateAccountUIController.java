/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

/**
 *
 * @author Laura
 */
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountUIController implements Initializable{

    private Stage stage;
    private static NavigationController theNavigationController;
    private LoginController theLoginController;
    private ArrayList<User> accountList;
    
    @FXML private Button createAccountButton;
    @FXML private Button goBack;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField passwordField1;
    @FXML private Label passwordStatus;
    @FXML private Label emailError;
    @FXML private Label userStatus;
    
    private String passwordValue;
    private String password2Value;
    private boolean passwordsMatch = false;
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    
    
    // Method which acts as the constructor for this class
    // This is called when the class is intitialized
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       accountList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory();
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {
            this.updatePasswordStatus(newValue);
            this.passwordValue = newValue;
        });
        passwordField1.textProperty().addListener((observable, oldValue, newValue) -> {
            this.matchPasswords(newValue);
            this.password2Value = newValue;
        });
    }
    
    /**
     * An FXML method that that takes the user input from CreateAccountUI and
     * pushes it into the controller on the press of the event param.
     * @param event 
     */
    @FXML protected void handleCreateAccountButtonAction(ActionEvent event) {
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String email = usernameField.getText();
        String password = passwordField.getText();
        
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        
        if(matcher.find()) {
            // reset the email error field
            emailError.setText("");
            
            boolean userExists = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().userExists(email);
            
            if(!userExists) {
                
                //adds new account to user directory
                boolean create = createNewAccount(email, password, fName, lName);


                if(create){
                    //opens the navigation scene
                   Stage stage = (Stage) createAccountButton.getScene().getWindow();
                   stage.hide();
                   NavigationController theNavigationController = NavigationController.getNavigationController(stage);   
                }else{
                    userStatus.setText("The information you entered is not complete.");
                }
                
            }
            
            else {
                userStatus.setText("Username is taken");
            }
        }
        else {
            emailError.setText("Invalid Email Format");
        }
    }
    
    
    /**
     * This method accesses the persisted data and adds a new user object to it.
     * It then writes the new JSON data to the JSON data model.
     * @param user is the Param that is added.
     */
    public void saveAccountData(User user){
        PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory().add(user);
        PersistentDataController.getPersistentDataCntl().writeJSONDataModel();
    }
    
    /**
     * Creates a new user from the following fields.
     * @param username
     * @param password
     * @param fName
     * @param lName 
     */
    public boolean createNewAccount(String username, String password, String fName, String lName){
        User newUser = new User(username, password, fName, lName);
        if(!(username.length()<6  || password.length()<6 || fName.length()==0 || lName.length()==0) && passwordsMatch){
            saveAccountData(newUser);
            return true;
        }else{
            System.out.println("There was an error in your login.");
            return false;
        }
    }
    
    /**
     * An FXML method that gets the LoginController and sets up the login scene
     */
    @FXML
    public void getLoginCntl() {
        // create instance of create account controller to load
        // create account UI
        Stage stage = (Stage) goBack.getScene().getWindow();
        theLoginController = new LoginController(stage);
    }
    
   
    /**
     * Takes the user inputted password from CreateAccountUI and
     * determines the strength of the password based on their input
     * @param password 
     */
    public void updatePasswordStatus(String password) {

        if(password.length() == 0) {
            passwordStatus.setText("");
        }
        else if(password.length() < 5) {
            passwordStatus.setText("WEAK PASSWORD");
        }
        else if(password.length() < 9 && password.length() >= 5) {
            passwordStatus.setText("MODERATE PASSWORD");
        }
        else {
            passwordStatus.setText("STRONG PASSWORD");
        }
        
    }
    
    /**
     * This method checks to make sure the two passwords match
     * @param password2 
     */
    public void matchPasswords(String password2){
        if(passwordValue.equals(password2)){
            passwordsMatch = true;
            updatePasswordStatus(password2);
        }else {
            passwordsMatch = false;
            passwordStatus.setText("Passwords do not match.");
        }
    }
    
}

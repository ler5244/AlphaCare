
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
    @FXML private Label passwordStatus;
    @FXML private Label emailError;
    
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
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(username);
        if(matcher.find()) {
            //adds new account to user directory
            createNewAccount(username, password, fName, lName);

            //opens the navigation scene
            Stage stage = (Stage) createAccountButton.getScene().getWindow();
            stage.hide();
            NavigationController theNavigationController = NavigationController.getNavigationController(stage);
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
    public void createNewAccount(String username, String password, String fName, String lName){
        
        User newUser = new User(username, password, fName, lName);
        saveAccountData(newUser);
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
}
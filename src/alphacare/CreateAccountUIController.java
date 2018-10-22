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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountUIController implements Initializable{

    private Stage stage;
    private static NavigationController theNavigationController;
    private LoginController theLoginController;
    
    @FXML private Button createAccountButton;
    @FXML private Button goBack;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    private ArrayList<User> accountList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       accountList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory();
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
        
        //adds new account to user directory
        createNewAccount(username, password, fName, lName);
        
        //opens the navigation scene
        Stage stage = (Stage) createAccountButton.getScene().getWindow();
        stage.hide();
        NavigationController theNavigationController = NavigationController.getNavigationController(stage);
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
    
     @FXML
    public void getLoginCntl() {
        // create instance of create account controller to load
        // create account UI
        Stage stage = (Stage) goBack.getScene().getWindow();
        theLoginController = new LoginController(stage);
    }
    
}
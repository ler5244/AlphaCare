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

    @FXML private Button createAccountButton;
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
    
    @FXML protected void handleCreateAccountButtonAction(ActionEvent event) {
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        //adds new account to user directory
        User createNewAccount = new User(username, password, fName, lName);
        saveAccountData(createNewAccount);
        
        //opens the navigation scene
        Stage stage = (Stage) createAccountButton.getScene().getWindow();
        stage.hide();
        NavigationController theNavigationController = NavigationController.getNavigationController(stage);
    }
    public void saveAccountData(User user){
        PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory().add(user);
        PersistentDataController.getPersistentDataCntl().writeJSONDataModel();
    }
}
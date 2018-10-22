
package alphacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;


public class LoginUIController {
    
    UserDirectory directory = new UserDirectory();
    private Stage mainStage;
    private CreateAccountController theCreateAccountController;
    
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button createAccountButton;
    @FXML private Button loginButton;
    @FXML private Label errorLabel;
    
    
    /**
     * compares Strings username and password to the usernames and passwords
     * of the User objects stored in User Directory.
     * @return true or false depending on if the username and password 
     * combination exists in the UserDirectory.
     */
    public LoginUIController(){
        
    }
    
    /*
    Authenticates theUserName and the String to any existing Users.
    If they exist, send the user to the navigation UI, otherwise show the error
    */
    @FXML
    public void authenticate(ActionEvent event){
        
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        if (directory.contains(username, password)) {
            mainStage = (Stage) loginButton.getScene().getWindow();
            NavigationController.getNavigationController(mainStage);
        }
        
        else {
            errorLabel.setText("Invalid credentials, please try again");
        }
    }
    
    /*
    When the user clicks on the create account button, it will switch
    scenses and load the create account interface
    */
    @FXML
    public void getCreateAccountCntl() {
        // create instance of create account controller to load
        // create account UI
        mainStage = (Stage) createAccountButton.getScene().getWindow();
        theCreateAccountController = new CreateAccountController(mainStage); 
    }
    
    
    
}
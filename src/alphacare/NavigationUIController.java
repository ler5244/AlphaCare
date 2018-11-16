/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Laura
 */
public class NavigationUIController implements Initializable{
    private Stage stage;
    private static NavigationController theNavigationController;
    private LoginController theLoginController;
    
    @FXML private Button gotoLogout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //accountList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory();
    }
    

     @FXML
    public void getLoginCntl() {
        // create instance of create account controller to load
        // create account UI
        Stage stage = (Stage) gotoLogout.getScene().getWindow();
        theLoginController = new LoginController(stage);
    }
    
    @FXML
    public void logOut(ActionEvent event) {
        System.out.println("EXITING");
        System.exit(0);
    }
    
}


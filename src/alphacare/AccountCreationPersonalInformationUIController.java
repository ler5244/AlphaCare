/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JoeQ7
 */
public class AccountCreationPersonalInformationUIController implements Initializable {
    private Stage stage;
    private static NavigationController theNavigationController;
    private static User user;
    
    @FXML private Button continueToNav;
    @FXML private TextField address1, address2, state, zip, cellPhone, homePhone;
    
    
    /**
     * Loads the create record scene
     * @param event 
     */
    //@FXML
    public void loadNavigation(ActionEvent event) {
        setInformation();
        saveAccountData();
        stage = (Stage) continueToNav.getScene().getWindow();
        
        Stage stage = (Stage) continueToNav.getScene().getWindow();
        stage.hide();
        NavigationController theNavigationController = NavigationController.getNavigationController(stage);
    }  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       user = AccountCreationPIController.getUser(); 
    }
    
    public void setInformation(){
        user.print();
        System.out.println("expecting fields: " + address1.getText() + address2.getText()+ state.getText() + zip.getText() + cellPhone.getText() + homePhone.getText());
        user.setMyInformation(new PersonalInformation(address1.getText(),address2.getText(), state.getText(),
                                                        zip.getText(),cellPhone.getText(),homePhone.getText()));
    }
    /**
     * This method accesses the persisted data and adds a new user object to it.
     * It then writes the new JSON data to the JSON data model.
     * @param user is the Param that is added.
     */
    public void saveAccountData(){
        PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory().add(user);
        PersistentDataController.getPersistentDataCntl().writeJSONDataModel();
    }
    
}

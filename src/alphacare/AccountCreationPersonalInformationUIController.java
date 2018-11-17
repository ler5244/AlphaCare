/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import static alphacare.CreateAccountUIController.VALID_EMAIL_ADDRESS_REGEX;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    @FXML private Label userError;
    
    public final Pattern VALID_STATE_REGEX = 
    Pattern.compile("^[A-Z]{2}$");
    
    public final Pattern VALID_ZIP_REGEX = 
    Pattern.compile("^[0-9]{5}$", Pattern.CASE_INSENSITIVE);
    
    public final Pattern VALID_PHONENUMBER_REGEX = 
    Pattern.compile("^[()0-9]*[0-9\\-]{3,4}[0-9\\-]{3,4}[0-9\\-]{4,5}$", Pattern.CASE_INSENSITIVE);
    
    
    
    /**
     * Loads the create record scene
     * @param event 
     */
    //@FXML
    public void loadNavigation() {
        stage = (Stage) continueToNav.getScene().getWindow();
        
        Stage stage = (Stage) continueToNav.getScene().getWindow();
        stage.hide();
        NavigationController theNavigationController = NavigationController.getNavigationController(stage);
    }  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       user = AccountCreationPIController.getUser();
       state.textProperty().addListener((observable, oldValue, newValue) -> {
            this.checkState(newValue);
        });
       zip.textProperty().addListener((observable, oldValue, newValue) -> {
            this.checkZip(newValue);
        });
       cellPhone.textProperty().addListener((observable, oldValue, newValue) -> {
            this.checkPhoneNumber(newValue);
        });
       homePhone.textProperty().addListener((observable, oldValue, newValue) -> {
            this.checkPhoneNumber(newValue);  
        });
    }
    
    /**
     * adds the information to the current user.
     */
    public void setInformation(){
        //user.print();
        if(checkState(this.state.getText()) &&
                checkZip(this.zip.getText()) &&
                checkPhoneNumber(this.cellPhone.getText()) &&
                checkPhoneNumber(this.homePhone.getText()) &&
                checkAddress(this.address1.getText()))
        {
            user.setMyInformation(new PersonalInformation(address1.getText(),address2.getText(), state.getText(),
                                                            zip.getText(),cellPhone.getText(),homePhone.getText()));
            this.saveAccountData();
            this.loadNavigation();
        }else{
            this.userError.setText("You have not filled out all the required forms");
        }
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
    
    /**
     * Checks to see if the state is in acceptable formats.
     * @param theState
     * @return boolean
     */
    private boolean checkState(String theState){
       Matcher matcher = VALID_STATE_REGEX .matcher(theState);
       if(matcher.find()){
           userError.setText("");
           return true;
       }else{
           userError.setText("Invalid State Name. Ex: NY");
           return false;
       }
    }
    
    /**
     * Checks to see if the Zip is in acceptable formats.
     * @param theZip
     * @return boolean
     */
    private boolean checkZip(String theZip){
       Matcher matcher = VALID_ZIP_REGEX .matcher(theZip);
       if(matcher.find()){
           userError.setText("");
           return true;
       }else{
           userError.setText("Invalid Zip Code. Ex: 11111");
           return false;
       }
    }
    
    /**
     * Checks to see if the phone number is in acceptable formats.
     * @param theNumber
     * @return boolean
     */
    private boolean checkPhoneNumber(String theNumber){
      Matcher matcher = VALID_PHONENUMBER_REGEX .matcher(theNumber);
       if(matcher.find() || theNumber.equals("")|| theNumber.equals(null)){
           userError.setText("");
           return true;
       }else{
           userError.setText("Invalid PhoneNumber. Ex: (#)-###-###-####");
           return false;
       }  
    }
    
    /**
     * Checks to see if the address is in acceptable formats.
     * @param theAddress
     * @return boolean
     */
    private boolean checkAddress(String theAddress){
       if(!(theAddress.equals("")|| theAddress.equals(null))){
           userError.setText("");
           return true;
       }else{
           userError.setText("Invalid Address.");
           return false;
       }  
    }
    
}

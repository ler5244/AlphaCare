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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ags12
 */
public class CreateRecordUIController implements Initializable {
    
    private Stage mainStage;
    
    @FXML private Button cancel;
    @FXML private Button submit;
    @FXML private TextField sickness;
    @FXML private TextField symptoms;
    @FXML private TextField miscInfo;
    @FXML private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Loads the main menu (cancel)
     * @param event 
     */
    @FXML
    public void loadMainMenu(ActionEvent event) {

        mainStage = (Stage) cancel.getScene().getWindow();
        NavigationController.getNavigationController(mainStage).setUpNavigationScene();
        
    }
    
    /**
     * Handle submission of the record
     */
    @FXML
    public void submitRecord() {
        String theSickness = sickness.getText();
        String theSymptoms = symptoms.getText();
        String theMiscInfo = miscInfo.getText();
        
        if(!theSickness.isEmpty() && !theSymptoms.isEmpty() && !theMiscInfo.isEmpty()) {
            // submit and persist the data
            System.out.println("Saving Record");
            
            // load main menu on successful submission
            mainStage = (Stage) submit.getScene().getWindow();
            NavigationController.getNavigationController(mainStage).setUpNavigationScene();
            
        }
        
        else {
            errorLabel.setText("Please fill out all of the fields");
        }
        
    }
    
    
}

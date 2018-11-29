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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Laura
 */
public class ViewRecordUICntl implements Initializable {
    @FXML private Text sicknessText;
    @FXML private Text nameText;
    @FXML private Text symptomsText;
    @FXML private Text miscInfoText;
    @FXML private Button backButton; 
    private NavigationController theNavCntl;
    private Stage stage;
    private ArrayList<String> currentUser;
    private ArrayList<Record> recordList; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        currentUser = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getCurrentUser();
        recordList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getRecordList().getRecord();
        
        for(Record r:recordList){
            if(currentUser.get(0).equals(r.getUsername())){
                nameText.setText(r.getUsername());
                sicknessText.setText(r.getSickness());
                symptomsText.setText(r.getSymptoms());
                miscInfoText.setText(r.getMiscInfo());
            }
            else{ 

            }
        }
    }    
    
    @FXML 
    public void handleBackButtonAction(ActionEvent event) {
        stage = (Stage) backButton.getScene().getWindow();
        
        theNavCntl = new NavigationController(stage);
    }
    
}

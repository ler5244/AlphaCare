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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ags12
 */
public class UpdateRecordUIController implements Initializable {
    
    private Stage mainStage;
    private ArrayList<String> currentUser;
    private ArrayList<Record> recordList; 
    private Record userRecord;
    
    @FXML private TextField sickness;
    @FXML private TextField symptoms;
    @FXML private TextField miscInfo;
    @FXML private Label errorLabel;
    @FXML private Button updateButton;
    @FXML private Button cancelButton;
    
    
    
    /**
     * Handle submission of the record
     */
    @FXML
    public void updateRecord() {
        String theSickness = sickness.getText();
        String theSymptoms = symptoms.getText();
        String theMiscInfo = miscInfo.getText();
        String username = currentUser.get(0);
        
        if(!theSickness.isEmpty() && !theSymptoms.isEmpty() && !theMiscInfo.isEmpty()) {
            // submit and persist the data
            Record record = new Record(theSickness, theSymptoms, theMiscInfo, username);
            saveRecordData(record);
            System.out.println("Updating Record");
            
            // load main menu on successful submission
            mainStage = (Stage) updateButton.getScene().getWindow();
            NavigationController.getNavigationController(mainStage).setUpNavigationScene();
            
        }
        
        else {
            errorLabel.setText("Please fill out all of the fields");
        }
        
    }
    
    public void saveRecordData(Record record){
        ArrayList<Record> records = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getRecordList().getRecord();
        
        for(int i = 0; i < records.size(); i++) {
            if(records.get(i).getUsername().equals(currentUser.get(0))) {
                PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getRecordList().getRecord().set(i, record);
            }
        }
        
        PersistentDataController.getPersistentDataCntl().writeJSONDataModel();
    }
    
    /**
     * Loads the main menu (cancel)
     * @param event 
     */
    @FXML
    public void loadMainMenu(ActionEvent event) {

        mainStage = (Stage) cancelButton.getScene().getWindow();
        NavigationController.getNavigationController(mainStage).setUpNavigationScene();
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recordList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getRecordList().getRecord();
        currentUser = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getCurrentUser();
        
        for(int i = 0; i < recordList.size(); i++) {
            if(recordList.get(i).getUsername().equals(currentUser.get(0))) {
                userRecord = recordList.get(i);
            }
        }
        
        sickness.setText(userRecord.getSickness());
        symptoms.setText(userRecord.getSymptoms());
        miscInfo.setText(userRecord.getMiscInfo());
        
    }    
    
}

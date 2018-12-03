
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class NavigationUIController implements Initializable{
    
    private Stage stage;
    private CreateRecordCntl theCreateRecordCntl;
    private ViewRecordCntl theViewRecordCntl;
    private UpdateRecordCntl theUpdateRecordCntl;
    @FXML private Button createRecord;
    @FXML private Button viewRecord;
    @FXML private Button updateRecord;
    @FXML private Text recordError;
    @FXML private Text viewRecordError;
    private ArrayList<String> currentUser;
    private ArrayList<Record> recordList; 
    private boolean recordExists; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        currentUser = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getCurrentUser();
        recordList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getRecordList().getRecord();
        
        for(Record r:recordList){
            if(!currentUser.get(0).equals(r.getUsername())){
                recordExists = false;
                 
            }
            else{ 
                recordExists = true;
                break;
            }
        } 
        System.out.println(recordExists);
    }    
    
    /**
     * Exits the application
     * @param event 
     */
    @FXML
    public void logOut(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Loads the create record scene
     * @param event 
     */
    @FXML
    public void loadCreateRecord(ActionEvent event) {
        if(!recordExists){
            stage = (Stage) createRecord.getScene().getWindow();
            theCreateRecordCntl = new CreateRecordCntl(stage);
        }else{
            recordError.setVisible(true);
        }
        
    }
    @FXML
    public void loadViewRecord(ActionEvent event){ 
        if(recordExists){
            stage = (Stage) viewRecord.getScene().getWindow();
            theViewRecordCntl = new ViewRecordCntl(stage);
        }else{
            viewRecordError.setVisible(true);
        }
        
    }
    
    @FXML
    public void loadUpdateRecord(ActionEvent event) {
        if(recordExists){
            stage = (Stage) updateRecord.getScene().getWindow();
            theUpdateRecordCntl = new UpdateRecordCntl(stage);
        }else{
            viewRecordError.setVisible(true);
        }
    }
}
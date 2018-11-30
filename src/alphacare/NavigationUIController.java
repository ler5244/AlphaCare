
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
    @FXML private Button createRecord;
    @FXML private Button viewRecord;
    @FXML private Text recordError; 
    private ArrayList<String> currentUser;
    private ArrayList<Record> recordList; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        currentUser = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getCurrentUser();
        recordList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getRecordList().getRecord();
        
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
        for(Record r:recordList){
            if(!currentUser.get(0).equals(r.getUsername())){
                System.out.println("error");
                recordError.setVisible(true);
                break;
            }
            else{ 
                stage = (Stage) createRecord.getScene().getWindow();
                theCreateRecordCntl = new CreateRecordCntl(stage);
            }
        }
        
        
        
    }
    @FXML
    public void loadViewRecord(ActionEvent event) {
        stage = (Stage) viewRecord.getScene().getWindow();
        
        theViewRecordCntl = new ViewRecordCntl(stage);
    }
}
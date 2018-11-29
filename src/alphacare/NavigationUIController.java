
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class NavigationUIController {
    
    private Stage stage;
    private CreateRecordCntl theCreateRecordCntl;
    private ViewRecordCntl theViewRecordCntl; 
    @FXML private Button createRecord;
    @FXML private Button viewRecord; 
    
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
        stage = (Stage) createRecord.getScene().getWindow();
        
        theCreateRecordCntl = new CreateRecordCntl(stage);
    }
    @FXML
    public void loadViewRecord(ActionEvent event) {
        stage = (Stage) viewRecord.getScene().getWindow();
        
        theViewRecordCntl = new ViewRecordCntl(stage);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author Laura
 */
public class NavigationUIController {
    
    /**
     * Exits the application
     * @param event 
     */
    @FXML
    public void logOut(ActionEvent event) {
        System.exit(0);
    }
    
}

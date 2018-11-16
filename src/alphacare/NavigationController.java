/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

/**
 *
 * @author Laura
 */
public class NavigationController implements Initializable {
    private Stage stage;
    private static NavigationController theNavigationController;
  
    private NavigationController(Stage theStage){
       
        stage = theStage;
        this.setUpNavigationScene();
        stage.show();
    }
    
    /**
     * Gets the navigation controller object
     * @param theStage
     * @return theNavigationController
     */
    public static NavigationController getNavigationController(Stage theStage){
        if(theNavigationController == null){
            theNavigationController = new NavigationController(theStage);
        }
        return theNavigationController;

    }
    /**
     * Sets up the main menu (navigation) scene
     */
    @FXML public void setUpNavigationScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("navigationUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Navigation Menu");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Acts as the constructor for this class
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}

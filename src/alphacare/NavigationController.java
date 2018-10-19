/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class NavigationController {
    private Stage stage;
    private static NavigationController theNavigationController;
  
    private NavigationController(Stage theStage){
       
        stage = theStage;
        this.setUpNavigationScene();
        stage.show();
    }
    public static NavigationController getNavigationController(Stage theStage){
        theNavigationController = new NavigationController(theStage);
        return theNavigationController;

    }
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
}

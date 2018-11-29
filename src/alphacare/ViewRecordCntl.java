/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Laura
 */
public class ViewRecordCntl {
    private Stage stage;

    public ViewRecordCntl(Stage theStage) {

        stage = theStage;
        setUpViewRecordScene();
    }
    
    // Loads in the new scene for allowing a user to create an account
    public void setUpViewRecordScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("viewRecordUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("View Record");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

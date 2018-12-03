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
public class UpdateRecordCntl {
    private Stage stage;

    public UpdateRecordCntl(Stage theStage) {

        stage = theStage;
        setUpUpdateRecordScene();
    }
    
    // Loads in the new scene for allowing a user to create an account
    public void setUpUpdateRecordScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("UpdateRecordUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Update Record");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

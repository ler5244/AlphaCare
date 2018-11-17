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
 * @author JoeQ7
 */
public class AccountCreationPIController {
    private Stage stage;
    private static User user;
    private static AccountCreationPIController theAccountCreationPIController;

    public AccountCreationPIController(Stage theStage, User newUser) {
        user= newUser;
        stage = theStage;
        setUpAccountCreationPIControllerScene();
    }
    
    // Loads in the new scene for allowing a user to create an account
    public void setUpAccountCreationPIControllerScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("AccountCreationPersonalInformationUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Personal Information");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Return the current user.
    public static User getUser(){
        return user;
    }
    
}

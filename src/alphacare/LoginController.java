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
public class LoginController {
    private Stage stage;
    private static LoginController theLoginController;
  
    public LoginController(Stage theStage){
       
        stage = theStage;
        setUpLoginScene();
    }

    public static LoginController getLoginController(Stage theStage){
        if(theLoginController == null){
            theLoginController = new LoginController(theStage);
        }
        return theLoginController;

    }
    
    public void setUpLoginScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

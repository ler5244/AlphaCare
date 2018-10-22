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
public class CreateAccountController {
    private Stage stage;
    private static CreateAccountController theCreateAccountController;
  
    public CreateAccountController(Stage theStage){
       
        stage = theStage;
        setUpCreateAccountScene();
    }

    public static CreateAccountController getCreateAccountController(Stage theStage){
        if(theCreateAccountController == null){
            theCreateAccountController = new CreateAccountController(theStage);
            System.out.println("in the if");
            return theCreateAccountController;
        }
        else{
         theCreateAccountController.setUpCreateAccountScene();
         System.out.println("in the out");
         return theCreateAccountController;   
        }

    }
    
    public void setUpCreateAccountScene(){
        Parent root;
        Scene scene;
        try{
            root = FXMLLoader.load(getClass().getResource("createAccountUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Create Account");
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

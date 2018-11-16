package alphacare;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CreateAccountController {

    private Stage stage;

    public CreateAccountController(Stage theStage) {

        stage = theStage;
        setUpCreateAccountScene();
    }
    
    // Loads in the new scene for allowing a user to create an account
    public void setUpCreateAccountScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("createAccountUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Create Account");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

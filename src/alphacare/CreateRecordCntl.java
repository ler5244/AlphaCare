package alphacare;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CreateRecordCntl {

    private Stage stage;

    public CreateRecordCntl(Stage theStage) {

        stage = theStage;
        setUpCreateRecordScene();
    }
    
    // Loads in the new scene for allowing a user to create an account
    public void setUpCreateRecordScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("CreateRecordUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Create Record");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

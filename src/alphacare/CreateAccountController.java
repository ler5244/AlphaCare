
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

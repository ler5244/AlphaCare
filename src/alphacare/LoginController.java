
package alphacare;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginController {

    private Stage stage;

    public LoginController(Stage theStage) {

        stage = theStage;
        setUpCreateAccountScene();
    }

    public void setUpCreateAccountScene() {
        Parent root;
        Scene scene;
        try {
            root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            scene = new Scene(root);
            stage.setTitle("Create Account or Login");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
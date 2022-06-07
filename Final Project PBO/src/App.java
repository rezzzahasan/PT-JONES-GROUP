import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage primarystage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        Scene scene = new Scene(root);

        primarystage.setTitle("Ternak Lele");
        primarystage.setScene(scene);
        primarystage.setResizable(false);
        primarystage.setFullScreen(false);
        primarystage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

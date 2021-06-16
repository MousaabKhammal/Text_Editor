package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage myStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        myStage.setTitle("Nou document de text");
        myStage.setScene(new Scene(root, 500, 450));
        myStage.getIcons().add(new Image("icon.png"));
        myStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

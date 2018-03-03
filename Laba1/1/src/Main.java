

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }
  @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("example.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Lab 1");//установка заголовка
        primaryStage.setScene(new Scene(root, 400, 400));//создание главного окна
        primaryStage.show();

    }



}

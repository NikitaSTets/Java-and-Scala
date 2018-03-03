package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
public class Main extends Application {
    private FXMLLoader loader;

     @FXML
     Button btn=new Button("Show");


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Scene scen=new Scene(root, 400, 400);
     //in this place i want to add btn in gridPane in sample.fxml

        primaryStage.setTitle("Lab 1");//установка заголовка
        primaryStage.setScene(scen);//создание главного окна
        //grid.add(btn,1,1);
        primaryStage.show();

    }
}

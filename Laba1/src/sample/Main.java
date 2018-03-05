package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;



public class Main extends Application {
    private FXMLLoader loader;

    @FXML
    Button btn = new Button("Show");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Label label=new Label();
        ((GridPane)root).add(label,1,7);

        Button btn = new Button("Show");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label.setText("БГУИР-знания и стиль жизни");
            }
        });
        ((GridPane) root).add(btn, 0, 7);

        Scene scen = new Scene(root, 400, 400);


        primaryStage.setTitle("Lab 1");//установка заголовка
        primaryStage.setScene(scen);//создание главного окна

        primaryStage.show();

    }
}

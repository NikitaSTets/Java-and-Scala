package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class Controller {
    @FXML private Text actiontarget;
    @FXML private TextField distanceTextField;
    @FXML private TextField speedTextField;
    @FXML private GridPane mainGrid;
    @FXML private Label slogan;
    private double distanse,speed;
    @FXML private Button btn;
    @FXML protected void ShowBsuirSlogan()
    {
        slogan.setText("БГУИР-знания и стиль жизни");
    }
    @FXML
     public void initialize()
    {
        btn=new Button("Show");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ShowBsuirSlogan();
            }
        });
        mainGrid.add(btn,0,7);
    }

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        try {


            distanse=Double.parseDouble(distanceTextField.getText());
            speed=Double.parseDouble(speedTextField.getText());
            if(speed==0)
            {
                actiontarget.setText("Арифметическая ошибка:делили на 0");
                return;
            }

            actiontarget.setText("Время прохождения:"+distanse/speed);
        }
        catch (ArithmeticException e)
        {
            actiontarget.setText("Арифметическая ошибка,возможно делили на 0");
            return;
        }
        catch (Exception e)
        {
            actiontarget.setText("Ошибка конвертации");
            return;
        }

    }
}

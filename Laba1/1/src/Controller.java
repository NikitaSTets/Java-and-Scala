

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML private Text actiontarget;
    @FXML private TextField distanceTextField;
    @FXML private TextField speedTextField;
    private double distanse,speed;

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


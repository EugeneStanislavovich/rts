package srt.eugene;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    public Button startButton, stopButton;
    public TextField allsum;
    @FXML
    private ProgressBar progress1, progress2, progress3, progress4, progress5, progress6;
    @FXML
    private double progressPercent1, progressPercent2, progressPercent3, progressPercent4, progressPercent5, progressPercent6;

    @FXML
    private Button progressTestButton;

    @FXML
    private Text text;

    private final SumCalculatedThread calculatedThread = new SumCalculatedThread(0);

    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;

    @FXML
    void increaseProgress(ActionEvent eventTest) {
        System.out.println("testButton");
    }

    @FXML
    void startAll(MouseEvent eventStart) {

        //1
        if (checkBox1.isSelected()) {
            System.out.println("Чекбокс1");
            progressPercent1 = 1;
            progress1.setProgress(progressPercent1);

        } else {
            System.out.println("Выключен1");
            progressPercent1 = 0;
            progress1.setProgress(progressPercent1);
        }
        //2
        if (checkBox2.isSelected()) {
            System.out.println("Чекбокс2");
            progressPercent2 = 1;
            progress2.setProgress(progressPercent2);

        } else {
            System.out.println("Выключен2");
            progressPercent2 = 0;
            progress2.setProgress(progressPercent2);
        }
        //3
        if (checkBox3.isSelected()) {
            System.out.println("Чекбокс3");
            progressPercent3 = 1;
            progress3.setProgress(progressPercent3);

        } else {
            System.out.println("Выключен3");
            progressPercent3 = 0;
            progress3.setProgress(progressPercent3);
        }
        //4
        if (checkBox4.isSelected()) {
            System.out.println("Чекбокс4");
            progressPercent4 = 1;
            progress4.setProgress(progressPercent4);

        } else {
            System.out.println("Выключен4");
            progressPercent4 = 0;
            progress4.setProgress(progressPercent4);
        }
        //5
        if (checkBox5.isSelected()) {
            System.out.println("Чекбокс5");
            progressPercent5 = 1;
            progress5.setProgress(progressPercent5);

        } else {
            System.out.println("Выключен5");
            progressPercent5 = 0;
            progress5.setProgress(progressPercent5);
        }

        calculatedThread.enable();
        double boxCount = progressPercent1 + progressPercent2 + progressPercent3 + progressPercent4 + progressPercent5;
        calculatedThread.setMultiplier(boxCount);
    }

    @FXML
    void stopAll(MouseEvent eventStop) throws InterruptedException {
        calculatedThread.disable();

        if (checkBox1.isSelected()) {
            progressPercent1 = 0;
            progress1.setProgress(progressPercent1);
            System.out.println("Остановлен1");
        } else {
            System.out.println("НеОстановлен1");
        }
        if (checkBox2.isSelected()) {
            progressPercent2 = 0;
            progress2.setProgress(progressPercent2);
            System.out.println("Остановлен2");
        } else {
            System.out.println("НеОстановлен2");
        }
    }

    int i = 0;

    public class Time implements Initializable {

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            text.setText(String.valueOf(i));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {

            }));

        }
    }


    @FXML
    void testingButton(MouseEvent event) {

    }

    @FXML
    void setCheckbox1(ActionEvent event) {

    }

    public void setCheckbox2(ActionEvent actionEvent) {
    }

    public void setCheckbox3(ActionEvent actionEvent) {
    }

    public void setCheckbox4(ActionEvent actionEvent) {
    }

    public void setCheckbox5(ActionEvent actionEvent) {
    }

    public void setCheckbox6(ActionEvent actionEvent) {
    }


}

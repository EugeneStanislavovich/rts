package srt.eugene;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;


public class HelloController {

    @FXML
    private LineChart<String, Number> graphics;
    @FXML
    private LineChart<String, Number> graphics1;
    private XYChart.Series<String, Number>  series = new XYChart.Series<>();
    private XYChart.Series<String, Number>  series1 = new XYChart.Series<>();
    private XYChart.Series<String, Number>  seriesGraphics2 = new XYChart.Series<>();

    @FXML
    private TextField repairs;

    @FXML
    private TextField waterField;

    @FXML
    private TextField moneField;

    @FXML
    private TextField bankField;

    @FXML
    private TextField doz1;

    @FXML
    private TextField doz2;

    @FXML
    private TextField doz3;

    @FXML
    private TextField cashField;
    @FXML
    public Button startButton, stopButton;

    public TextField allsum;
    int waterSum=0;
    int repairSum;
    int money;

    @FXML
    private ProgressBar progress1, progress2, progress3, progress4, progress5, progress6;
    @FXML
    private double progressPercent1, progressPercent2, progressPercent3, progressPercent4, progressPercent5, progressPercent6;

    @FXML
    private Button progressTestButton;

    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    private final SumCalculatedThread calculatedThread = new SumCalculatedThread(0);
    private final tableThread thread = new tableThread();

    @FXML
    public Text text;
    @FXML
    private Button backWater;

    int i1;

    @FXML
    void increaseProgress(ActionEvent eventTest) {
        calculatedThread.disable();
        thread.disable();
        JOptionPane.showMessageDialog(null, "Нет воды!");
    }

    @FXML
    void startAll(MouseEvent eventStart) {
        List<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);
        checkBoxes.add(checkBox4);
        checkBoxes.add(checkBox5);
        checkBoxes.add(checkBox6);
        Random random = new Random();
        int boxes = random.nextInt(6);
        for (int j = 0; j < boxes; j++) {
            int check = random.nextInt(5);
            checkBoxes.get(check).setSelected(true);
        }
        //1
        if (checkBox1.isSelected()) {
            progressPercent1 = 1;
            progress1.setProgress(progressPercent1);

        } else {
            progressPercent1 = 0;
            progress1.setProgress(progressPercent1);
        }
        //2
        if (checkBox2.isSelected()) {
            progressPercent2 = 1;
            progress2.setProgress(progressPercent2);

        } else {
            progressPercent2 = 0;
            progress2.setProgress(progressPercent2);
        }
        //3
        if (checkBox3.isSelected()) {
            progressPercent3 = 1;
            progress3.setProgress(progressPercent3);

        } else {
            progressPercent3 = 0;
            progress3.setProgress(progressPercent3);
        }
        //4
        if (checkBox4.isSelected()) {
            progressPercent4 = 1;
            progress4.setProgress(progressPercent4);

        } else {
            progressPercent4 = 0;
            progress4.setProgress(progressPercent4);
        }
        //5
        if (checkBox5.isSelected()) {
            progressPercent5 = 1;
            progress5.setProgress(progressPercent5);

        } else {
            progressPercent5 = 0;
            progress5.setProgress(progressPercent5);
        }
        //6
        if (checkBox6.isSelected()) {
            progressPercent6 = 1;
            progress6.setProgress(progressPercent6);

        } else {
            progressPercent6 = 0;
            progress6.setProgress(progressPercent6);
        }
        graphics.getData().add(series);
        graphics.getData().add(series1);
        graphics1.getData().add(seriesGraphics2);
        graphics.setLegendVisible(false);
        graphics1.setLegendVisible(false);
        calculatedThread.enable();
        double boxCount = progressPercent1 + progressPercent2 + progressPercent3 + progressPercent4 + progressPercent5 + progressPercent6;
        calculatedThread.setMultiplier(boxCount);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            allsum.setText(calculatedThread.getSum() + " рублей");
            cashField.setText(calculatedThread.getCash() + " рублей");
            bankField.setText(calculatedThread.getBank() + " рублей");
            repairs.setText(repairSum + " рублей");
            moneField.setText(money + " рублей");
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        dozChecker();
        thread.enable();
        timeline.play();

    }


    @FXML
    void stopAll(MouseEvent eventStop) throws InterruptedException {
        calculatedThread.disable();

        if (checkBox1.isSelected()) {
            progressPercent1 = 0;
            progress1.setProgress(progressPercent1);
            System.out.println("Остановлен1");
            progressTestButton.setText("1");

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

    void dozChecker() {
        if (checkBox1.isSelected() || checkBox2.isSelected()) {
            doz1.setText("Работает");
            doz1.setStyle("-fx-text-fill: Green;");
        } else {
            doz1.setText("НЕ Работает");
            doz1.setStyle("-fx-text-fill: Orange;");
        }
        if (checkBox3.isSelected() || checkBox4.isSelected()) {
            doz2.setText("Работает");
            doz2.setStyle("-fx-text-fill: Green;");
        } else {
            doz2.setText("НЕ Работает");
            doz2.setStyle("-fx-text-fill: Orange;");
        }
        if (checkBox5.isSelected() || checkBox6.isSelected()) {
            doz3.setText("Работает");
            doz3.setStyle("-fx-text-fill: Green;");
        } else {
            doz3.setText("НЕ Работает");
            doz3.setStyle("-fx-text-fill: Orange;");
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
    void waterBack(ActionEvent event) {
        repairSum+=2000;
        calculatedThread.enable();
        thread.enable();
        JOptionPane.showMessageDialog(null, "Связались с водоконалом, всё успешно восстановлено");
    }


    @FXML
    void testingButton(MouseEvent event) {

    }
    int gates = 0;
    @FXML
    void gateBrokeDown(ActionEvent event) {
        Random random = new Random();
        int gate = random.nextInt(6);
        if(gate==0 && checkBox1.isSelected()){
            progress1.setVisible(false);
            calculatedThread.setMultiplier(calculatedThread.getMultiplier() - 1);
            JOptionPane.showMessageDialog(null, "Бокс 1 ворота сломаны");
            gate++;
        } else if (gate==1 && checkBox2.isSelected()){
            progress2.setVisible(false);
            calculatedThread.setMultiplier(calculatedThread.getMultiplier() - 1);
            JOptionPane.showMessageDialog(null, "Бокс 2 ворота сломаны");
            gate++;
        }else if (gate==2 && checkBox3.isSelected()){
            progress3.setVisible(false);
            calculatedThread.setMultiplier(calculatedThread.getMultiplier() - 1);
            JOptionPane.showMessageDialog(null, "Бокс 3 ворота сломаны");
            gate++;
        }else if (gate==3 && checkBox4.isSelected()){
            progress4.setVisible(false);
            calculatedThread.setMultiplier(calculatedThread.getMultiplier() - 1);
            JOptionPane.showMessageDialog(null, "Бокс 4 ворота сломаны");
            gate++;
        }else if (gate==4 && checkBox5.isSelected()){
            progress5.setVisible(false);
            calculatedThread.setMultiplier(calculatedThread.getMultiplier() - 1);
            JOptionPane.showMessageDialog(null, "Бокс 5 ворота сломаны");
            gate++;
        }else if (gate==5 && checkBox6.isSelected()){
            progress6.setVisible(false);
            calculatedThread.setMultiplier(calculatedThread.getMultiplier() - 1);
            JOptionPane.showMessageDialog(null, "Бокс 6 ворота сломаны");
            gate++;
        }
    }

    @FXML
    void gateRepair(ActionEvent event) {
        repairSum+=1500;
        progress1.setVisible(true);
        progress2.setVisible(true);
        progress3.setVisible(true);
        progress4.setVisible(true);
        progress5.setVisible(true);
        progress6.setVisible(true);
        calculatedThread.setMultiplier(calculatedThread.getMultiplier()+gates);
        JOptionPane.showMessageDialog(null, "Ворота починены");
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

    class tableThread implements Runnable {
        private boolean enabled = false;


        @Override
        public void run() {

            Thread thread = new Thread(() -> {

                while (enabled) {
                    try {
                        javafx.application.Platform.runLater(() -> {

                            Random random =new Random();
                            double waterPena =random.nextDouble(0.7);
                            waterSum += (int)(waterPena * 200);
                            waterField.setText(waterSum + " рублей");
                            money = calculatedThread.getSum() - waterSum - repairSum;
                            LocalDateTime current = LocalDateTime.now();
                            String formattedTime = current.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                            int cash = calculatedThread.getCash();
                            int bank = calculatedThread.getBank();
                            series.getData().add(new LineChart.Data<>(formattedTime, cash));
                            series1.getData().add(new LineChart.Data<>(formattedTime, bank));
                            seriesGraphics2.getData().add(new LineChart.Data<>(formattedTime, waterPena));
                        });
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            thread.start();
        }

        public void enable() {
            this.enabled = true;
            run();
        }

        public void disable() {
            this.enabled = false;
        }
    }
}

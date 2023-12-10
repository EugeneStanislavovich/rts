package srt.eugene;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SumCalculatedThread {


    private int sum;


    private boolean enabled = false;

    private int multiplier;

    private int cash;

    private int bank;




    public SumCalculatedThread(int sum) {
        this.sum = sum;
    }

    public void run() {

        Thread thread = new Thread(() -> {
            while (enabled) {
                try {
                    sum += 300.0 * multiplier;
                    bank = (int) (sum/2.1);
                    cash = (int) (sum/2.5);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

    }

    public int getSum() {
        return sum;
    }

    public void enable() {
        this.enabled = true;
        run();
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = (int) multiplier;

    }
    public int getMultiplier() {
        return multiplier;
    }

    public void disable() {
        this.enabled = false;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }
}



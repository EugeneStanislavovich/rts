package srt.eugene;

import javafx.fxml.FXML;

public class SumCalculatedThread {

    private int sum;

    private boolean enabled = false;

    private int multiplier;

    public SumCalculatedThread(int sum) {
        this.sum = sum;
    }

    public void run() {

        Thread thread = new Thread(() -> {
            while (enabled) {
                try {
                    sum += 150.0 * multiplier;
                    System.out.println(sum);
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
        System.out.println(multiplier);
    }

    public void disable() {
        this.enabled = false;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}


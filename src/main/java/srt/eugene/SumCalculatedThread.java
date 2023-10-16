package srt.eugene;

public class SumCalculatedThread extends Thread {

    private int sum;

    private boolean isEnabled = false;

    public SumCalculatedThread(int sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        while (isEnabled) {
            try {
                sum += 150;
                System.out.println(sum);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getSum() {
        return sum;
    }

    public void disable() {
        isEnabled = false;
    }

    public void enable() {
        isEnabled = true;
        start();
    }
}

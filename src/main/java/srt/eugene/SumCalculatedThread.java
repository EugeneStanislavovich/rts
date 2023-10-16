package srt.eugene;

public class SumCalculatedThread {

    private int sum;

    private boolean enabled = false;

    public SumCalculatedThread(int sum) {
        this.sum = sum;
    }

    public void run() {
        Thread thread = new Thread(() -> {
            while (enabled) {
                try {
                    sum += 150;
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

    public void disable() {
        this.enabled = false;
    }
}

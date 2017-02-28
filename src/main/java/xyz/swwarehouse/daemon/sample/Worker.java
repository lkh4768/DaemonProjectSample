package xyz.swwarehouse.daemon.sample;

public class Worker {
    private final static int ONE_SEC = 1000;
    private int n = 0;

    public void run() {
        Operation op = new Operation();
        while (true) {
            n = op.increatmentNum(n);
            System.out.println(n);
            sleep(ONE_SEC);
        }
    }

    private void sleep(long term) {
        try {
            Thread.sleep(term);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

package xyz.swwarehouse.daemon.sample;
/**
 * @author WES
 * @version 1.0.0
 * @brief 데몬 클래스
 * @date 2017-03-05
 */

public class Worker {
    private final static int ONE_SEC = 1000;
    private int n = 0;

    /**
     * @brief 1초마다 n를 1씩 증가 시킨 후, 표준 출력.
     */
    public void run() {
        Operation op = new Operation();
        while (true) {
            n = op.increamentNum(n);
            System.out.println(n);
            sleep(ONE_SEC);
        }
    }
    /**
     * @param term
     * @brief try-catch 문을 포함한 sleep 함수
     */
    private void sleep(long term) {
        try {
            Thread.sleep(term);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

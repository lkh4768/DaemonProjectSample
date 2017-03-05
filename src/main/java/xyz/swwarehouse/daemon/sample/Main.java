package xyz.swwarehouse.daemon.sample;

/**
 * @mainpage mainpage
 * @brief java doxygen sample
 */

/**
 * @brief include main method
 * @author WES
 * @date 2017-03-05
 * @version 1.0.0
 */
public class Main {
    /**
     * @brief run worker
     * @param args
     */
	public static void main(String[] args) {
		Worker worker = new Worker();
		worker.run();
	}
}

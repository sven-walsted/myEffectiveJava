package sven.examples.myeffectivejava.items.concurrency.item78;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author josh.block
 *         https://github.com/jbloch/effective-java-3e-source-code/blob/master/src/effectivejava/chapter11/item78/fixedstopthread1/StopThread.java
 */
public class StopThread {
  private static boolean stopRequested;

  private static synchronized void requestStop() {
    stopRequested = true;
  }

  private static synchronized boolean stopRequested() {
    return stopRequested;
  }

  public static void main(String[] args) throws InterruptedException {
    Thread backgroundThread = new Thread(() -> {
      int i = 0;
      while (!stopRequested()) {
        System.out.println(Thread.currentThread() + ": " + i);
        i++;
      }
    });
    backgroundThread.start();
    TimeUnit.SECONDS.sleep(1);
    requestStop();
    System.out.println(Thread.currentThread() + ": " + "   *** DONE ***");
  }
}

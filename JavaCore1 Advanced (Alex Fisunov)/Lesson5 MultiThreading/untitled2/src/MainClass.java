import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("time: " + (System.currentTimeMillis() - t));
    }

    private static void interruptedEx() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean interruptedExc = false;
                for (int i = 0; i < 100; i++) {
                    if (Thread.currentThread().isInterrupted() || interruptedExc) {
                        System.out.println("Ok");
                        break;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        interruptedExc = true;
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        });
        t.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }

    private static void counterEx() {
        Counter counter = new Counter();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.inc();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter.dec();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        t2.start();
        try {
            t.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.value());
    }

    private static void daemonThreadEx() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("1");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.setPriority(8);
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }

    private static void threadsRunOrderEx() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).start();
    }

    private static void anonymousEx() {
        // class Anonymous implements Runnable {
        //  @Override public void run() {
        //   System.out.println(Thread.currentThread().getName());
        //  }
        // }
        // Anonymous a = new Anonymous();
        // Thread t = new Thread(a);
        // t.start();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
    }

    private static void runnableEx() {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t2.start();
    }

    private static void threadExtEx() {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        System.out.println(Thread.currentThread().getName());
        t1.start();
        t2.start();
    }
}

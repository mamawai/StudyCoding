package com.mashibing.juc.c_026_00_interview.A1B2C3;


public class T06_00_sync_wait_notify {
    public static void main(String[] args) {
        final Object o = new Object();

        char[] aI = "123".toCharArray();
        char[] aC = "ABC".toCharArray();

        new Thread(()->{
            synchronized (o) {
                /*try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                for(char c : aI) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait(); //让出锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify(); //必须，否则无法停止程序
            }

        }, "t1").start();

        new Thread(()->{
            synchronized (o) {
                for(char c : aC) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notify();
            }
        }, "t2").start();
    }
}

//如果我想保证t2在t1之前打印，也就是说保证首先输出的是A而不是1，这个时候该如何做？
//先对t2进行notify t1进行wait

/*例子：两个线程抢一把锁，其中一个线程抢到了运行，另一个线程阻塞，阻塞的线程只能抢到锁才能仅需运行。
wait()等待的线程需要notify()来唤醒
 */

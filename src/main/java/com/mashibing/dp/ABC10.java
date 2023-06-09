package com.mashibing.dp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC10 {
    // 两个判断条件若为false则线程获取到锁的时候转为等待状态；这里优先让第二个线程获取到锁并执行输出B
    private static volatile boolean t2Started = false;
    private static volatile boolean t3Started = false;

    public static void main(String[] args) {


        // 这里定义三个空间来存放线程
        // condition可以理解为定义的队列空间，可以选择去不同的空间进行休息，当你唤醒的时候可以指定的去唤醒
        Lock lock = new ReentrantLock();
        Condition co0 = lock.newCondition();
        Condition co1 = lock.newCondition();
        Condition co2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                while (!t2Started) {
                    System.out.println("线程1等待");
                    co0.await();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    co1.signal();
                    co0.await();
                }
                co2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    t3Started = true;
                    co2.signal();
                    co1.await();
                }
                co0.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        ).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (!t3Started) {
                    co2.await();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print("C");
                    t2Started = true;
                    co0.signal();
                    co2.await();
                }
                // 由于是最后一个结束执行这里不需要在通知其他的Condition
                // co1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}

package com.mashibing.juc.c_026_00_interview.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC10 {
    private static volatile boolean t2Started = false;
    private static volatile boolean t3Started = false;

    public static void main(String[] args) {


        Lock lock = new ReentrantLock();
        Condition co0 = lock.newCondition();
        Condition co1 = lock.newCondition();
        Condition co2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                while (!t2Started) {
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
                co1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}

package com.mashibing.util;

import java.util.concurrent.TimeUnit;

public class SleepHelper {
    private int seconds;
    public static void sleepSeconds(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

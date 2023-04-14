package com.mashibing.dp.singleton;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
    public static void main(String[] args) {

    }
    private String info;
    private static final int maxNumberOfEmperor = 2;
    private static final ArrayList<String> emperorInfoList = new ArrayList<>(maxNumberOfEmperor);
    private static final ArrayList<Emperor> emperorList = new ArrayList<>(maxNumberOfEmperor);

    private static int countNumofEmperor = 0;

    static {
        for (int i = 0; i < maxNumberOfEmperor; i++) {
            emperorList.add(new Emperor("第" + i + "皇帝"));
            System.out.println(32);
            System.out.println(emperorList);
            System.out.println(emperorInfoList);
        }

    }


    private Emperor() {

    }

    public String getInfo() {
        return info;
    }

    private Emperor(String info) {
        this.info = info;
        emperorInfoList.add(info);
    }

    public static Emperor getInstance(int num) {
        countNumofEmperor = num;
        if (num == 0) {
            return emperorList.get(0);
        } else if (num == 1) {
            return emperorList.get(1);
        } else {
            System.out.println("error");
            return null;
        }
    }

    public static Emperor getInstance() {
        Random random = new Random();
        countNumofEmperor = random.nextInt(maxNumberOfEmperor);
        return emperorList.get(countNumofEmperor);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return emperorInfoList.get(countNumofEmperor);
    }
}


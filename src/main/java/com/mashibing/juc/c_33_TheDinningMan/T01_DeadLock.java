package com.mashibing.juc.c_33_TheDinningMan;

public class T01_DeadLock {
    public static void main(String[] args) {
        ChopStick c0 = new ChopStick();
        ChopStick c1 = new ChopStick();
        ChopStick c2 = new ChopStick();
        ChopStick c3 = new ChopStick();
        ChopStick c4 = new ChopStick();

        Ph ph0 = new Ph("po",c0,c1,0);
        Ph ph1 = new Ph("po",c1,c2,1);
        Ph ph2 = new Ph("po",c2,c3,2);
        Ph ph3 = new Ph("po",c3,c4,3);
        Ph ph4 = new Ph("po",c4,c0,4);

        ph0.start();
        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();

    }

    public static class Ph extends Thread{

        private String name;
        private ChopStick left,right;
        private int index;

        public Ph(String name, ChopStick left, ChopStick right, int index) {
            this.name =name;
            this.left = left;
            this.right = right;
            this.index = index;
        }

        //死锁解决方法，增加一个左撇子
        @Override
        public void run() {
            if (index%2 == 0) {//优化index==0只增加了一个左撇子，index%2==0 现在修改成奇数位置为左撇子，效率更快
                synchronized (left) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (right) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(index+"吃完了");
                    }
                }
            }else {

                synchronized (right) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (left) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(index + "吃完了");
                    }
                }
            }
        }
    }
}

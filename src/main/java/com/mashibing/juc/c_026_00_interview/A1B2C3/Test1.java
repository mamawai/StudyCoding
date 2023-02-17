package com.mashibing.juc.c_026_00_interview.A1B2C3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//������������ģ��
/*private final ReentrantLock lock;
private final Condition conditionWrite;//��������������
private final Condition conditionRead;*/
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Test1 test1 = new Test1(5);
        Producer producer = new Producer(test1);
        Comsumer comsumer = new Comsumer(test1);
        new Thread(comsumer).start();
        Thread.sleep(3000);
        new Thread(producer).start();


    }
    Boolean flag = false;
    private int maxSize;
    private List<String> messages;

    private final ReentrantLock lock;
    private final Condition conditionWrite;//��������������
    private final Condition conditionRead;
    public Test1(int maxSize) {
        this.maxSize = maxSize;
        messages = new LinkedList<String>();
        lock = new ReentrantLock(true);//true�޸����Ĺ�ƽ�ԣ�Ϊtrueʱ��ʹ��lifo������˳������
        conditionWrite = lock.newCondition();//����newCondition()��������new ConditionObject();
        conditionRead = lock.newCondition();

    }
    public void set(String message){
        //ʹ����ʵ��ͬ������ȡ���ò����������������߳�ռ��ʱ����ǰ�߳̽���������
        lock.lock();
        try{
            while(messages.size() == maxSize){
                System.out.print("the message buffer is full now,start into wait()\n");
                conditionWrite.await();//��������ʱ���߳����߲��ͷ����������� signalAll()ʱ���̻߳��Ѳ����»����
            }
            Thread.sleep(100);
            messages.add(message);
            System.out.print("add message:"+message+" success\n");
            conditionRead.signalAll();//������conditionRead.await()���ߵ��߳�
            flag = false;
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public String get(){
        String message = null;
        lock.lock();
        try{
            while(messages.size() == 0){
                System.out.print("the message buffer is empty now,start into wait()\n");
                flag = true;
                conditionRead.await();//��û��Ԫ�ص�ʱ���߳̽���Read�������������Ϣ
                //condition�������Ϊ�����ռ䣬����ѡ��ȥ��ͬ�Ŀռ������Ϣ�����㻽�ѵ�ʱ�����ָ����ȥ����
            }
            Thread.sleep(100);
            message = ((LinkedList<String>)messages).poll();
            System.out.print("get message:"+message+" success\n");
            conditionWrite.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return message;
    }
}
class Comsumer implements Runnable{
    private Test1 test1 = null;

    public Comsumer(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public void run() {
        for (int i = 0;i<15;i++) {
            this.test1.get();
        }
    }
}
class Producer implements Runnable{
    private Test1 test1 = null;


    public Producer(Test1 test1) {
        this.test1 = test1;
    }

    @Override
    public void run() {
        for (int i = 0;i<10;i++) {
            this.test1.set("kkkkkk"+i);
        }
    }
}
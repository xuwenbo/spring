package com.webb.java.thread.communication;

/**
 * 1. 等待通知机制
 *
 * wait()、notify()、notifyAll() 调用的前提都是获得了对象的锁（也可称为对象监视器）
 * 调用wait()方法后线程会释放锁，进入WAITING状态，该线程也会被移动到等待队列中
 * 调用notify()方法会将等待队列中的线程移动到同步队列中，线程状态也会更新为BLOCKED
 */
public class TwoThreadWaitNotify {

    private int start = 1;

    private boolean flag = false;

    public static void main(String[] args) {
        TwoThreadWaitNotify notify = new TwoThreadWaitNotify();

        Thread t1 = new Thread(new OuNum(notify));
        t1.setName("A");

        Thread t2 = new Thread(new JiNum(notify));
        t2.setName("B");

        t1.start();
        t2.start();
    }

    /**
     * 偶数线程
     */
    public static class OuNum implements Runnable {
        private TwoThreadWaitNotify number;

        public OuNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("偶数线程抢到了锁");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + " 偶数:" + number.start);
                        number.start++;
                        number.flag = false;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 奇数线程
     */
    public static class JiNum implements Runnable {
        private TwoThreadWaitNotify number;

        public JiNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("奇数线程抢到锁了");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + " 奇数:" + number.start);
                        number.start++;
                        number.flag = true;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}

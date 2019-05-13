package com.webb.java.thread.context;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author wenbo
 * @create 2019/4/29
 */
public class ContextSwitchTest {

    private static final long count = 10000000;

    public static void main(String[] args) throws Exception {
        concurrecy();
        serial();
    }

    private static void concurrecy() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                int a = 0;
                for (int i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();

        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }

        thread.join();
        stopwatch.stop();
        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        System.out.println("concurrecy:" + stopwatch.toString());
    }

    private static void serial() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int a = 0;
        for (int i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;
        for (int i = 0; i < count; i++) {
            b--;
        }
        stopwatch.stop();
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println("serial:" + stopwatch.toString());
    }

}

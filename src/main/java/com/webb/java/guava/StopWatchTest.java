package com.webb.java.guava;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class StopWatchTest {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(1994);
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS)); // 以秒打印从计时开始至现在所用时间，向下取整
        stopwatch.stop(); // 停止计时
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));

        stopwatch.start(); // 再次计时
        Thread.sleep(100);
        System.out.println(stopwatch.elapsed(TimeUnit.SECONDS));

        stopwatch.reset().start(); // 重置并开始
        Thread.sleep(1030);

        System.out.println(stopwatch.isRunning());
        long mills = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(mills);

        System.out.println(stopwatch.toString());
        System.out.println(stopwatch);
    }

}

package com.yixin;

public class VolatileTest extends Thread {

    volatile boolean flag = false;
    int i = 0;

    public void run() {
        new Thread() {
            public void run() {
                while (!flag) {
                    i++;
                    int a = i++ ;
                    a += 1;
                }
            }
        }.start();
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.run();
        Thread.sleep(10);
        vt.flag = true;

        System.out.println("stop------------------------==" + vt.i);
        System.out.println( vt.flag);
    }
}
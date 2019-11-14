package com.zhiyuan.thread;

/**
 * @author ZhangJie
 * @create 2019-11-07 10:47
 */
public class EndRunable {
    private  static  class UseRun implements   Runnable{

        @Override
        public void run() {
            String threadName=Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("线程："+threadName+" is run!");
            }
            System.out.println("线程："+threadName+" Interrupt flag is "+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRun endRunable=new UseRun();
        Thread thread = new Thread(endRunable);thread.start();

        Thread.sleep(10);
        thread.interrupt();
    }
}



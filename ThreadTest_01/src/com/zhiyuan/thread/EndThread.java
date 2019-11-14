package com.zhiyuan.thread;

/**
 * @author ZhangJie
 * @create 2019-11-07 10:47
 */
public class EndThread {
    private  static  class UseThread extends  Thread{
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName=this.getName();
            System.out.println(threadName);
            while (!isInterrupted()){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Interrupt flag is "+isInterrupted());
                    this.interrupt();
                    e.printStackTrace();
                }
                System.out.println("线程："+this.getName()+" is run!");
            }
            System.out.println("线程："+this.getName()+" Interrupt flag is "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread useThread=new UseThread("EndThread");
        useThread.start();

        Thread.sleep(10);
        useThread.interrupt();
    }
}



package com.zhiyuan.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author ZhangJie
 * @create 2019-11-06 17:55
 */
public class TreadTest_01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
//        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
//        for (ThreadInfo threadInfo : threadInfos) {
//            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());
//        }

        RunThread runThread=new RunThread();
        Thread thread=new Thread(runThread,"runThread");
        thread.start();

//        CallThread callThread=new CallThread();
//        FutureTask<String> futureTask=new FutureTask<String>(callThread);
//        new Thread(futureTask,"callThread").start();
//        String s = futureTask.get();
//        System.out.println(s);
    }

    private static class ThreadTest extends Thread{

    }

    private static class RunThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class CallThread implements Callable {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return "CallThread";
        }
    }
}

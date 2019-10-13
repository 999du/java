package test;

import java.util.concurrent.CountDownLatch;

public class TestMain {

		public static void main(String[] args) throws InterruptedException {
		// TODO 自动生成的方法存根
		//单线程==============
		
			
		long startTime = System.currentTimeMillis(); //获取开始时间
		SingleThread singletread=new SingleThread();
		singletread.Multiplicate();
		//singletread.Out(singletread.thirst);
		long endTime = System.currentTimeMillis(); //获取结束时间
		System.out.println("单线程程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间
		
		
		//多线程==============
		
		
		long startTime1 = System.currentTimeMillis(); //获取开始时间
		int number=2;
		CountDownLatch countDownLatch=new CountDownLatch(number);//阻塞
		MultiThread multithread=new MultiThread(number,countDownLatch);
		for(int i=0;i<number;i++) {
			Thread thread=new Thread(multithread);
			thread.start();
		}
		MultiThread.countDownLatch.await();
		//MultiThread.Out(MultiThread.thirst);
		long endTime1 = System.currentTimeMillis(); //获取结束时间
		System.out.println("多线程程序运行时间：" + (endTime1 - startTime1) + "ms"); //输出程序运行时间
		
		
		//线程池==============
		
		long startTime2 = System.currentTimeMillis(); //获取开始时间
		PoolThread poolthread=new PoolThread(number);
		poolthread.PoolWork();
		//PoolThread.Out(poolthread.thirst);
		long endTime2 = System.currentTimeMillis(); //获取结束时间
		System.out.println("线程池程序运行时间：" + (endTime2 - startTime2) + "ms"); //输出程序运行时间
	
		}

}

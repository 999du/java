package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThread {
	public static final int N=100;
	public final int M=1;
	public int first[][]=new int[N][N];
	public int second[][]=new int[N][N];
	public int thirst[][]=new int[N][N];
	public int threadnumber=0;//线程的个数
	public int graduated=0;//行分度
	public int currentMaxRow=0;//当前最大行
	public static CountDownLatch countDownLatch;//阻塞
	public int PoolSize=6;
	public PoolThread(int number){
		//初始化
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				thirst[i][j]=0;	
		setValue(first,M);
		setValue(second,M);
		threadnumber=number;
		graduated=N/threadnumber;
		currentMaxRow=graduated;
		MultiThread.countDownLatch=new CountDownLatch(threadnumber);
	}
	//设定初值函数
	public void setValue(int Array[][],int number) {
		int set=1;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				Array[i][j]=set;
				if(set==number)set=1;
				else set++;
			}
	}
	//元素积函数
	public int Mul(int i,int j) {
		int sum=0;
		for(int k=0,g=0;k<N&&g<N;g++,k++)
			sum=first[i][k]*second[g][j]+sum;
		return sum; 
	}
	//求积函数
	public void Multiplicate(int max) {
		for(int i=0;i<max;i++)
			for(int j=0;j<N;j++)
				thirst[i][j]=Mul(i,j);
	}
	//输出函数
	public static void Out(int Array[][] ) {
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.print(Array[i][j]+" ");
				}
			System.out.println();
			}
		System.out.println();
	}
	//设置当前最大行
	public void setcurrentMaxRow(){
		synchronized(this) {
		currentMaxRow=graduated+currentMaxRow;
		}
	}
//
//	for (int i = 0; i < 8; i++) {
//		final int tmp = i;
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				try{
//					uaTest.scan(new Jedis("192.168.1.5", 6381 + tmp));
//				}finally{
//					//有一个线程进来就减1
//					latch.countDown();
//				}
//			}
//		};
//		pool.submit(runnable);
//	}
//
	//线程池
	public void PoolWork() {
		ExecutorService pool=Executors.newFixedThreadPool(PoolSize);
		for(int i=0;i<threadnumber;i++){
		Runnable target=new Runnable(){
			@Override
			public void run() {
				try {
				Multiplicate(currentMaxRow);
				setcurrentMaxRow();
				}finally {
			countDownLatch.countDown();
				}
			}
		};
			pool.submit(target);
		}
		try {
			PoolThread.countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		pool.shutdown();
	}
}

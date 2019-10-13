package test;

import java.util.concurrent.CountDownLatch;

public class MultiThread implements Runnable{
	public static final int N=100;
	public final int M=1;
	public int first[][]=new int[N][N];
	public int second[][]=new int[N][N];
	public static int thirst[][]=new int[N][N];
	public int threadnumber=0;//线程的个数
	public int graduated=0;//行分度
	public int currentMaxRow=0;//当前最大行
	public static CountDownLatch countDownLatch;//阻塞
	public MultiThread(int number,CountDownLatch countDownLatch){
		//初始化
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				thirst[i][j]=0;	
		setValue(first,M);
		setValue(second,M);
		threadnumber=number;
		graduated=N/threadnumber;
		currentMaxRow=graduated;
		MultiThread.countDownLatch=countDownLatch;
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
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		Multiplicate(currentMaxRow);
		setcurrentMaxRow();
		countDownLatch.countDown();
	}

}

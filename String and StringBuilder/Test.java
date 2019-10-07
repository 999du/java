package test;

import java.util.Date;
//计算生成1到100000的字符串，各自需要多少时间
public class Test {
	public static void main(String[] args) {
		String s="";
		//String类需要的时间
		Date d=new Date();
		long l1=d.getTime();
		for(int i=0;i<100000;i++) {
			s+=i;
		}
		Date d1=new Date();
		long l2=d1.getTime();
		System.out.println(l2-l1);
		//StringBuilder的时间
		StringBuilder sb1=new StringBuilder();
		Date d4=new Date();
		long l5=d4.getTime();
		for(int i=0;i<100000;i++) {
			sb1.append(i);
		}
		Date d5=new Date();
		long l6=d5.getTime();
		System.out.println(l6-l5);
	}
}

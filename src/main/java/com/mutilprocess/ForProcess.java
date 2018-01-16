package com.mutilprocess;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @author mike_yi
 * @description for 循环跑多线程应用例子
 * 
 */
public class ForProcess {
   public static Executor executor = Executors.newFixedThreadPool(6);
   public static void main(String[] args) {
	for(int i=0;i<10000;i++) {
		executor.execute(new Runnable() {
			public void run() {
				System.out.println("===跑任务===");
			}});
	}
}
}

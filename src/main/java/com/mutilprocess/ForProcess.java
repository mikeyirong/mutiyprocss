package com.mutilprocess;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/**
 * @author mike_yi
 * @description for 循环跑多线程应用
 * 
 */
public class ForProcess {
   //创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
   //线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
   public static Executor executorfix = Executors.newFixedThreadPool(6);
   //创建一个单一线程池，整个线程池只用一个线程，任务会按顺序执行
   public static Executor executorsingle = Executors.newSingleThreadExecutor();
   //创建一个创建一个固定大小的线程池。此线程池支持定时以及周期性执行任务的需求。
   public static Executor executorschedul = Executors.newScheduledThreadPool(6);
   //创建一个无固定大小的缓存线程池，创建一个线程，任务执行完后，不销毁，重复利用
   public static Executor executorcache = Executors.newCachedThreadPool();
   public static void main(String[] args) {
	for(int i=0;i<10000;i++) {
		executorfix.execute(new Runnable() {
			public void run() {
				System.out.println("===跑任务===");
			}});
	}
}
}

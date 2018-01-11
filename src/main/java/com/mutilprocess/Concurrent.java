package com.mutilprocess;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author mike_yi
 * @Description 多线程描述
 */
public class Concurrent {
	public static int INFOINITI = -1;
	private final Executor excetor;

	public Concurrent(int capacity) {
		super();
		this.excetor = capacity == -1 ? Executors.newCachedThreadPool() : Executors.newFixedThreadPool(capacity);
	}

	public static Concurrent alloc(int capatity) {
        return new Concurrent(capatity);
	}

	public void asgin(Runnable runnable) {
		excetor.execute(runnable);
	}
}

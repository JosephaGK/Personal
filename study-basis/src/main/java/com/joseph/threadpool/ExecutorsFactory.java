package com.joseph.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Joseph
 */
public class ExecutorsFactory implements Runnable{

	@Override public void run() {
		System.out.println(System.currentTimeMillis() + ":ThreadId" + ":" + Thread.currentThread().getId());
	}
	public static void main(String[] arg){
		ExecutorService service = Executors.newFixedThreadPool(5);
		ExecutorsFactory task = new ExecutorsFactory();
		for (int i = 0; i < 10; i++) {
			service.submit(task);
		}
	}
}

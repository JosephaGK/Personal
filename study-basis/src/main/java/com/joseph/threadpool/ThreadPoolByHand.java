package com.joseph.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Joseph
 */
public class ThreadPoolByHand {

	/**
	 * 手动创建线程
	 * 默认5条线程（即最小数量）
	 * 最大20线程（指定了线程中的最大线程数量）
	 * 空闲时间0秒
	 * 等待队列长度1024
	 * 线程名称，方便回溯
	 * 拒绝策略，当队列任务已满，抛出RejectedExecutionException异常
	 */
	private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 20, 0L, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<Runnable>(1024),new ThreadFactoryBuilder().setNameFormat("ByHand-%d").build(), new ThreadPoolExecutor.AbortPolicy());

	static class MyRunable implements Runnable{
		String name;

		public MyRunable(String name) {
			this.name = name;
		}

		@Override public void run() {
			System.out.println("正在执行：Thread ID：" + Thread.currentThread().getId() + "   Name=" + name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] arg) {

		for (int i = 0; i < 500; i++) {
			MyRunable myRunable = new MyRunable("r"+i);
			threadPool.execute(myRunable);
		}
		threadPool.shutdown();

	}

}

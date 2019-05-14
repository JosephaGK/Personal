package com.joseph.concurrent;

/**
 * 测试volatile关键字作用
 * volatitle可以保证多线程修改数据时数据可见性
 * main线程修改running时，thread线程可以立刻感知到
 * 若不加volatile，main线程修改running时thread不能感知到
 * @author Joseph
 */
public class VolatileTest implements Runnable {
	public volatile boolean running = false;
//	public boolean running = false;

	@Override
	public void run() {
		System.out.println("======开始执行任务======");
		running = true;
		while (running) {
		}
		System.out.println("======结束执行任务======");
	}

	public static void main(String[] args) {
		VolatileTest volatileTest = new VolatileTest();
		Thread thread = new Thread(volatileTest);
		thread.start();
		try {
			Thread.sleep(3000);
			System.out.println("======修改状态======");
			volatileTest.running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

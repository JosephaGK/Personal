package com.joseph.concurrent;

/**
 * ThreadLocal定义的变量是线程本地变量，只在当前线程内可用
 * @author Joseph
 */
public class ThreadLocalTest {
	private static final ThreadLocal<String> name = new ThreadLocal<>();
	public String getName(){
		return name.get();
	}
	public void setName(String name){
		ThreadLocalTest.name.set(name);
	}

	public static void main(String[] args) {
		ThreadLocalTest tlt = new ThreadLocalTest();
		new Thread(new Runnable() {
			@Override
			public void run() {
				tlt.setName("张三");
				System.out.println(Thread.currentThread().getName() + "设置name:张三");
				System.out.println(Thread.currentThread().getName() + "获取name:"+tlt.getName());
			}
		},"SetThread").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + "获取name:"+tlt.getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"GetThread").start();

	}
}


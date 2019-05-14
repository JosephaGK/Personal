package create.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程测试创建单例效率
 */
public class SpeedTest {
	public static void main(String[] args) throws Exception {
		long start =  System.currentTimeMillis();
		int threadNum = 10;
		/**
		 * 同步辅助类，在完成一组正在其他线程执行的操作之前，它允许一个或多个线程一直等待
		 * 	countDown()当前线程调用此方法，则计数减一(建议放在finally中执行)
		 * 	await()，调用此方法会一直阻塞当前线程，直到计数器的值为0
		 */
		CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 1000000; j++) {
//						Object o = SingletonDemo4.getInstance();
						Object o = SingletonDemo5.INSTANCE;
					}
					countDownLatch.countDown();
				}
			}).start();
		}

		//main线程阻塞，知道计数器变为0，才会继续往下执行
		countDownLatch.await();
		long end =  System.currentTimeMillis();
		System.out.println("总耗时：" + (end - start));
	}
}

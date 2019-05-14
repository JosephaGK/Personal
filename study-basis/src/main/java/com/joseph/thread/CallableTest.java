package com.joseph.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Joseph
 */
public class CallableTest {
	public static void main(String[] args) {
		CallableDemo demo = new CallableDemo();
		FutureTask<Integer> task = new FutureTask<>(demo);
		new Thread(task).start();

		try {
			Integer result = task.get();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

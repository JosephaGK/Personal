package com.joseph.java8.Time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Joseph
 */
public class SimpleDateFormatTest {
	
	public static void main(String[] args) throws Exception {

		testSimpleDateFormatSecurity();
		solveSimpleDateFormatSecurity();
		java8Method();
	}

	/**
	 * 测试SimpleDateFormat线程安全问题
	 */
	public static void testSimpleDateFormatSecurity() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return sdf.parse("20161121");
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<Date>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}
		pool.shutdown();
	}
	/**
	 * 解决SimpleDateFormat线程安全问题
	 */
	public static void solveSimpleDateFormatSecurity() throws Exception {
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return DateFormatThreadLocal.convert("20161121");
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<Date>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}
		pool.shutdown();
	}

	/**
	 * 测试java8的时间类线程安全
	 */
	public static void java8Method() throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				LocalDate ld = LocalDate.parse("20161121", dtf);
				return ld;
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(10);
		List<Future<LocalDate>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<LocalDate> future : results) {
			System.out.println(future.get());
		}
		pool.shutdown();
	}

}

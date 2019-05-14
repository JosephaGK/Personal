package com.joseph.cycle;

/**
 * @author Joseph
 */
public class LabelTest {
	public static void main(String[] arg) {
		normalContinue();
		normalBreak();
		labelContinue();
		labelBreak();

	}

	public static void normalContinue() {
		System.out.println("------------非标签continue----------");
		for (int i = 0; i < 4; i++) {
			System.out.println("外层循环" + i);
			for (int j = 0; j < 4; j++) {
				if (j == 2) {
					continue;
				}
				System.out.println("内部循环" + j);
			}
			System.out.println("*************");
		}
		System.out.println("------------非标签continue----------");

	}

	public static void normalBreak() {
		System.out.println("------------非标签break----------");
		for (int i = 0; i < 4; i++) {
			System.out.println("外层循环" + i);
			for (int j = 0; j < 4; j++) {
				if (j == 2) {
					break;
				}
				System.out.println("内部循环" + j);
			}
			System.out.println("*************");
		}
		System.out.println("------------非标签break----------");
	}

	// 使用continue outer跳出内层循环的时候，外层循环后面的语句也不会执行
	public static void labelContinue() {
		System.out.println("------------标签continue----------");
		outer: for (int i = 0; i < 4; i++) {
			System.out.println("外层循环" + i);
			for (int j = 0; j < 4; j++) {
				if (j == 2) {
					continue outer;
				}
				System.out.println("内部循环" + j);
			}
			System.out.println("*************");
		}
		System.out.println("------------标签continue----------");
	}

	// break+标签 直接把内外层循环一起break
	public static void labelBreak() {
		System.out.println("------------标签break----------");
		outer: for (int i = 0; i < 4; i++) {
			System.out.println("外层循环" + i);
			for (int j = 0; j < 4; j++) {
				if (j == 2) {
					break outer;
				}
				System.out.println("内部循环" + j);
			}
			System.out.println("*************");
		}
		System.out.println("------------标签break----------");
	}
}

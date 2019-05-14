package create.singleton;

/**
 * 双重检验锁单例
 * 由于编译器优化和jvm底层内部模型，偶尔出问题
 */
public class SingletonDemo3 {
	private static SingletonDemo3 instance = null;

	private SingletonDemo3() {
	}

	public static SingletonDemo3 getInstance() {
		if (instance == null) {
			SingletonDemo3 sc;
			synchronized (SingletonDemo3.class) {
				sc = instance;
				if (sc == null) {
					synchronized (SingletonDemo3.class) {
						if (sc == null) {
							sc = new SingletonDemo3();
						}
					}
					instance = sc;
				}
			}
		}
		return instance;
	}
}

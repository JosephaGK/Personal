package create.singleton;

import java.io.Serializable;

/**
 * 这是一个懒汉式单例，用于测试单例模式的破解
 */
public class SingletonBreak implements Serializable {
	private static SingletonBreak instance ;

	private SingletonBreak(){
		//以下代码防止反射破解单例模式
//		if(instance!=null){
//			throw new RuntimeException();
//		}
	}

	public static synchronized SingletonBreak getInstance(){
		if(instance==null){
			instance = new SingletonBreak();
		}
		return instance;
	}

	/**
	 * 使用readResolve()方法避免序列化破解单例
	 * @return
	 */
	private Object readResolve() {
		return instance;
	}
}

package create.singleton;

/**
 * 静态内部类单例
 * 外部类没有static属性,不会立即加载对象
 * 调用getInstance时才会加载静态内部类
 * 加载类是线程安全的
 * 兼容了高效调用和延时加载优势
 */
public class SingletonDemo4 {
	private SingletonDemo4(){}

	private static  class SingletonClassInstance{
		private static final SingletonDemo4 instance = new SingletonDemo4();
	}
	public static SingletonDemo4 getInstance(){
		return SingletonClassInstance.instance;
	}

}

package create.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射、序列化和反序列化破解单例
 */
public class SingletonBreakClient {
	public static void main(String[] args) throws Exception{
		SingletonBreak s1 = SingletonBreak.getInstance();
		SingletonBreak s2 = SingletonBreak.getInstance();
		System.out.println(s1);
		System.out.println(s2);

		//利用反射直接调用私有构造器破解单例
		//可以使用在构造方法中抛出异常来避免这种反射破解
		Class<SingletonBreak> clazz = (Class<SingletonBreak>)Class.forName("create.singleton.SingletonBreak");
		Constructor<SingletonBreak> constructor = clazz.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		SingletonBreak s3 = constructor.newInstance();
		SingletonBreak s4 = constructor.newInstance();

		System.out.println(s3);
		System.out.println(s4);

		//通过发序列化的方式构造多个对象
		//可以在单例类中添加readResolve()方法避免这种序列化破解
		FileOutputStream fos = new FileOutputStream("d:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
		SingletonBreak s5 = (SingletonBreak) ois.readObject();
		System.out.println(s5);
	}
}

package create.factory.simplefactory;

/**
 * 简单工厂模式最简单，最常用
 */
public class Client {
	public static void main(String[] args) {
		Car audi = CarFactory.createCar("奥迪");
		Car byd = CarFactory.createCar("比亚迪");
		Car audi1 = CarFactory.createAudi();
		Car byd1 = CarFactory.createByd();
		audi.run();
		byd.run();
	}
}

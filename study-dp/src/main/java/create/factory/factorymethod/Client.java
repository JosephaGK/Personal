package create.factory.factorymethod;

/**
 * 工厂方法模式
 */
public class Client {
	public static void main(String[] args) {
		Car audi = new AudiFactory().createCar();
		Car byd = new BydFactory().createCar();
		audi.run();
		byd.run();
	}
}

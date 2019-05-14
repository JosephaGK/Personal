package create.factory.abstractfactory;

public interface Engine {
	void run();

	void start();
}

class LowEngine implements Engine {

	@Override
	public void run() {
		System.out.println("慢");
	}

	@Override
	public void start() {
		System.out.println("慢");
	}
}

class LuxuryEngine implements Engine {

	@Override
	public void run() {
		System.out.println("快");
	}

	@Override
	public void start() {
		System.out.println("快");
	}
}
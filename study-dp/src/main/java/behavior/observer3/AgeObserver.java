package behavior.observer3;

public class AgeObserver implements Observer {
	@Override
	public void doSomething() {
		System.out.println("age modifiyed");
	}
}

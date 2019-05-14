package behavior.observer3;

public class NameObserver implements Observer {
	@Override
	public void doSomething() {
		System.out.println("name modifiyed");
	}
}

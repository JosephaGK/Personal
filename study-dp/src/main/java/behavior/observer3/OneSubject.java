package behavior.observer3;

public class OneSubject extends AbstractSubject {
	@Override
	public void operation() {
		System.out.println("test");
		notifyAllObservers();
	}
}

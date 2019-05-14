package behavior.observer3;

import java.util.LinkedList;

/**
 * @author Joseph
 */
public abstract class AbstractSubject implements Subject {
	LinkedList<Observer> list = new LinkedList<>();

	@Override
	public void addObserver(Observer observer) {
		list.add(observer);
	}

	@Override
	public void delObserver(Observer observer) {
		list.remove(observer);
	}
	@Override
	public void notifyAllObservers() {
		for (Observer observer : list) {
			observer.doSomething();
		}
	}
}

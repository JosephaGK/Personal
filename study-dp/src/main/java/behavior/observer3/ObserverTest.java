package behavior.observer3;

/**
 * @author Joseph
 */
public class ObserverTest {
	public static void main(String[] arg){
		OneSubject oneSubject = new OneSubject();
		oneSubject.addObserver(new AgeObserver());
		oneSubject.addObserver(new NameObserver());
		oneSubject.operation();
	}
}

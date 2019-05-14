package behavior.observer3;

/**
 * @author Joseph
 */
public interface Subject {
	/**
	 * 增加观察者
	 * @param observer
	 */
	public void addObserver(Observer observer);

	/**
	 * 删除观察者
	 * @param observer
	 */
	public void delObserver(Observer observer);

	/**
	 * 通知所有观察者
	 */
	public void notifyAllObservers();

	/**
	 * 实体类自身操作
 	 */
	public void operation();
}

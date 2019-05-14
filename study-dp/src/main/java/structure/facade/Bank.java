package structure.facade;

/**
 * @author Joseph
 */
public interface Bank {
	/**
	 * 	开户
	 */
	void  openAccount();
}

class ICBC implements Bank {

	@Override
	public void openAccount() {
		System.out.println("在中国工商银行开户！");
	}

}

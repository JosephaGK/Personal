package structure.facade;

/**
 * @author Joseph
 */
public interface Revenue {
	/**
	 * 	办理税务登记证
	 */
	void taxCertificate();
}

class HaiDianRevenue implements Revenue {

	@Override
	public void taxCertificate() {
		System.out.println("在海淀税务局办理税务登记证！");
	}

}

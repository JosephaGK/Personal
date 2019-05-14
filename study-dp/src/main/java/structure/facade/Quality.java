package structure.facade;

/**
 * @author Joseph
 */
public interface Quality {
	/**
	 * 	办理组织机构代码证
	 */
	void  orgCodeCertificate();
}

class HaiDianQuality implements Quality {

	@Override
	public void orgCodeCertificate() {
		System.out.println("在海淀区质检局办理组织机构代码证！");
	}

}

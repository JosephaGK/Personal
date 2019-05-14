package structure.adapter;

/**
 * 适配器 (类适配器方式)
 * @author Administrator
 *
 */
public class ClassAdapter extends Adaptee implements Target {
	
	
	@Override
	public void handleReq() {
		super.request();
	}
	
}

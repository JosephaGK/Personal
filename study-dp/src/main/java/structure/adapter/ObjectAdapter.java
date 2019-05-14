package structure.adapter;

/**
 * 适配器 (对象适配器方式,使用了组合的方式跟被适配对象整合)
 * @author Administrator
 */
public class ObjectAdapter  implements Target {
	
	private Adaptee adaptee;
	
	@Override
	public void handleReq() {
		adaptee.request();
	}

	public ObjectAdapter(Adaptee adaptee) {
		super();
		this.adaptee = adaptee;
	}
	
	
	
}

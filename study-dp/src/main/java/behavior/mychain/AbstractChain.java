package behavior.mychain;

public abstract class AbstractChain implements Handler {
	private Handler handler;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override public void operate() {
		this.customerOperate();
		if(getHandler()!=null){
			getHandler().operate();
		}
	}

	abstract void customerOperate();
}

package behavior.chain;

public class AbstractHandler {
	private behavior.chain.Handler Handler;

	public behavior.chain.Handler getHandler() {
		return Handler;
	}

	public void setHandler(behavior.chain.Handler Handler) {
		this.Handler = Handler;
	}
}

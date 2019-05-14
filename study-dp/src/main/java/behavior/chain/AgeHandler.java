package behavior.chain;

public class AgeHandler extends AbstractHandler implements Handler {
	private String name;
	public AgeHandler(String name){
		this.name=name;
	}

	@Override public void operate() {
		System.out.println(name+" deal");
		if(getHandler()!=null){
			getHandler().operate();
		}
	}
}

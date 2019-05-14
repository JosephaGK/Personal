package behavior.chain;

public class NameHandler extends AbstractHandler implements Handler {
	private String name;
	public NameHandler(String name){
		this.name=name;
	}


	@Override public void operate() {
		System.out.println(name+" deal");
		if(getHandler()!=null){
			getHandler().operate();
		}
	}
}

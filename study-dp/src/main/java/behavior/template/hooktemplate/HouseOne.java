package behavior.template.hooktemplate;

public class HouseOne extends AbstractHouseHookTemplate {

	public HouseOne(String name) {
		super(name);
	}

	@Override protected void buildDoor() {
		System.out.println(this.name+"=====buildDoor");
	}

	@Override protected void buildWindow() {
		System.out.println(this.name+"=====buildWindow");
	}

	@Override protected void buildWall() {
		System.out.println(this.name+"=====buildWall");
	}

	@Override protected void buildBase() {
		System.out.println(this.name+"=====buildBase");
	}

	@Override public boolean addWC() {
		return true;
	}

	@Override public void buildWC() {
		System.out.println(this.name+"=====buildWC");
	}
}

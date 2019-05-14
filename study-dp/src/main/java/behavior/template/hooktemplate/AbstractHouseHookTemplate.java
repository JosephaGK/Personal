package behavior.template.hooktemplate;

public abstract class AbstractHouseHookTemplate {

	public AbstractHouseHookTemplate(String name) {
		this.name = name;
	}

	public String name;

	//这是模板方法，一般使用protected修饰，是子类需要重写的方法
	protected abstract void buildDoor();

	protected abstract void buildWindow();

	protected abstract void buildWall();

	protected abstract void buildBase();

	//钩子方法，提供默认实现，子类可灵活重写
	public boolean addWC(){
		return false;
	}
	public void buildWC(){

	}

	//这是基本方法，一般使用final定义，确保子类不能修改，定义设计好的逻辑
	public final void buildHouse() {
		buildBase();
		buildWall();
		buildDoor();
		buildWindow();
		if (addWC()) {
			buildWC();
		}
	}
}

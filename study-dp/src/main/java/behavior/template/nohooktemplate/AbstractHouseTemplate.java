package behavior.template.nohooktemplate;

public abstract class AbstractHouseTemplate {

	public AbstractHouseTemplate(String name) {
		this.name = name;
	}

	public String name;

	//这是模板方法，一般使用protected修饰，是子类需要重写的方法
	protected abstract void buildDoor();

	protected abstract void buildWindow();

	protected abstract void buildWall();

	protected abstract void buildBase();

	//这是基本方法，一般使用final定义，确保子类不能修改，定义设计好的逻辑
	public final void buildHouse() {
		buildBase();
		buildWall();
		buildDoor();
		buildWindow();
	}
}

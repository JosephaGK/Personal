package structure.facade;

/**
 * @author Joseph
 */
public interface Industrial  {
	/**
	 * 	核名
	 */
	void checkName();
}

class HaiDianIndustrial implements Industrial {

	@Override
	public void checkName() {
		System.out.println("检查名字是否有冲突！");
	}

}

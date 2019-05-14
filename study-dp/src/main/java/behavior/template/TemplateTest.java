package behavior.template;

import behavior.template.nohooktemplate.HouseOne;
import behavior.template.nohooktemplate.HouseTwo;

public class TemplateTest {
	public static void main(String[] arg){
		HouseOne houseOne = new HouseOne("平房");
		HouseTwo houseTwo = new HouseTwo("别墅");
		houseOne.buildHouse();
		houseTwo.buildHouse();

		behavior.template.hooktemplate.HouseOne hookHouseOne = new behavior.template.hooktemplate.HouseOne("钩子平房");
		behavior.template.hooktemplate.HouseTwo hookHouseTwo = new behavior.template.hooktemplate.HouseTwo("钩子别墅");
		hookHouseOne.buildHouse();
		hookHouseTwo.buildHouse();

	}
}

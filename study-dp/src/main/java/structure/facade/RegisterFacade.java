package structure.facade;

/**
 * 办理注册公司流程的门面对象
 * @author Administrator
 *
 */
public class RegisterFacade {

	public void register(){
		Industrial a = new HaiDianIndustrial();
		a.checkName();
		Quality b = new HaiDianQuality();
		b.orgCodeCertificate();
		Revenue c  = new HaiDianRevenue();
		c.taxCertificate();
		Bank  d = new ICBC();
		d.openAccount();
	}
}

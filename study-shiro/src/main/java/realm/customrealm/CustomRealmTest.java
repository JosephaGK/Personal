package realm.customrealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class CustomRealmTest {
	@Test
	public void testAuthentication() {
		CustomRealm customRealm = new CustomRealm();
		//1.构建securityManager环境
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(customRealm);

		//2.主体提交认证请求
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("joseph", "joseph");
		subject.login(token);

		System.out.println("isAuthenticated:" + subject.isAuthenticated());

		subject.checkRole("user");
		subject.checkPermission("user:add");

	}
}

package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {

	SimpleAccountRealm realm = new SimpleAccountRealm();

	@Before
	public void addUser() {
		realm.addAccount("joseph", "123456","admin","user");
	}

	@Test
	public void testAuthentication() {
		//1.构建securityManager环境
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(realm);

		//2.主体提交认证请求
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("joseph", "123456");
		subject.login(token);

		System.out.println("isAuthenticated:" + subject.isAuthenticated());

		subject.checkRole("admin");
		subject.checkRoles("admin","user");

	}
}

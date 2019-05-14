package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class IniRealmTest {
	@Test
	public void testAuthentication() {
		IniRealm realm = new IniRealm("classpath:conf/user.ini");
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
		subject.checkPermission("user:update");

	}
}

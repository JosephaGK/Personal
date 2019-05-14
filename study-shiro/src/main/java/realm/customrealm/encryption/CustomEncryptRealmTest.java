package realm.customrealm.encryption;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class CustomEncryptRealmTest {
	@Test
	public void testAuthentication() {
		//自定义的加密realm
		CustomEncryptRealm customEncryptRealm = new CustomEncryptRealm();

		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		//设置加密方式
		matcher.setHashAlgorithmName("md5");
		//设置加密次数
		matcher.setHashIterations(1);
		customEncryptRealm.setCredentialsMatcher(matcher);

		//1.构建securityManager环境
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(customEncryptRealm);

		//2.主体提交认证请求
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("joseph", "123456");
		subject.login(token);

		System.out.println("isAuthenticated:" + subject.isAuthenticated());
//
//		subject.checkRole("user");
//		subject.checkPermission("user:add");

	}
}

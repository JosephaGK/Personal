package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class JdbcRealmTest {
	DruidDataSource dataSource = new DruidDataSource();
	{
		dataSource.setUrl("jdbc:mysql://localhost:3306/study-shiro");
		dataSource.setUsername("root");
		dataSource.setPassword("gekun0901");
	}

	@Test
	public void testAuthentication() {
		JdbcRealm jdbcRealm = new JdbcRealm();
		jdbcRealm.setDataSource(dataSource);
		//设置查询权限的开关，默认关闭
		jdbcRealm.setPermissionsLookupEnabled(true);
		//1.构建securityManager环境
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(jdbcRealm);

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

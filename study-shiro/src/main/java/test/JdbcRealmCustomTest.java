package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class JdbcRealmCustomTest {
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

		//设置自定义的认证sql
		String authSql = "select password from custom_user where user_name = ? ";
		jdbcRealm.setAuthenticationQuery(authSql);
		//设置自定义的角色sql
		String roleSql = "select role_name from custom_user_role where user_name = ?";
		jdbcRealm.setUserRolesQuery(roleSql);
		//设置自定义的权限sql
		String permissionSql = "select per from custom_permissions where role_name = ?";
		jdbcRealm.setPermissionsQuery(permissionSql);

		//1.构建securityManager环境
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(jdbcRealm);

		//2.主体提交认证请求
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("tom", "123456");
		subject.login(token);

		System.out.println("isAuthenticated:" + subject.isAuthenticated());
		subject.checkRole("user");
		subject.checkPermission("user:select");

	}
}

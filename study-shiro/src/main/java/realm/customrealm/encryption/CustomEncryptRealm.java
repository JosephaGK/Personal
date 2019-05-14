package realm.customrealm.encryption;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomEncryptRealm extends AuthorizingRealm {

	Map<String,String> userMap = new HashMap<>(16);

	{
		userMap.put("joseph","47ec2dd791e31e2ef2076caf64ed9b3d");
		//设置这个realm的名称
		super.setName("realmName");
	}
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
		String userName = (String) principals.getPrimaryPrincipal();
		//根据用户名查询角色数据和权限数据
		Set<String> roleSet = getRoleByUserName(userName);
		Set<String> permissionSet = getPermissionByUserName(userName);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.setRoles(roleSet);
		simpleAuthorizationInfo.setStringPermissions(permissionSet);
		return simpleAuthorizationInfo;
	}

	/**
	 * 模拟数据库查询角色信息
	 * @return
	 */
	private Set<String> getRoleByUserName(String userName) {
		Set<String> roleSet = new HashSet<>(16);
		roleSet.add("admin");
		roleSet.add("user");
		return roleSet;
	}

	/**
	 * 模拟数据库查询权限信息
	 * @return
	 */
	private Set<String> getPermissionByUserName(String userName) {
		Set<String> permissionSet = new HashSet<>(16);
		permissionSet.add("user:select");
		permissionSet.add("user:add");
		return permissionSet;
	}

	/**
	 *认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.从主体信息中获取用户名
		String userName = (String) token.getPrincipal();
		//2.根据用户名从数据库中获取密码
		String password = getPasswordByUserName(userName);
		if(password==null){
			return null;
		}
		//3.认证成功返回认证信息对象
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("joseph", password, "realmName");
		//如果密码使用了加盐的加密，认证信息对象中加入盐值
		//ByteSource类提供util将字符串转为ByteSource
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("test"));
		return authenticationInfo;
	}

	/**
	 * 模拟数据库查询密码操作
	 * @param userName
	 * @return
	 */
	private String getPasswordByUserName(String userName) {
		return userMap.get(userName);
	}

	/**
	 * 计算123456的加盐MD5值，这个值是模拟数据库中存着的密码值
	 */
	public static void main(String[] args) {
		Md5Hash md5Hash = new Md5Hash("123456","test");
		System.out.println(md5Hash);
	}
}

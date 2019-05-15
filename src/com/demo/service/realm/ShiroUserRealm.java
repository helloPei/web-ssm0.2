package com.demo.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
/**
 * 通过此对象获取用户身份相关信息，用户权限相关信息间接的实现Realm
 * @author Administrator
 *
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm {//AuthenticationRealm(提供了认证数据的获取方法)
	@Autowired
	private UserDao userDao;
	
	/**
	 * 设置凭证(密码)加密匹配器
	 */
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		//cMatcher.setHashAlgorithmName(5)加密次数
		super.setCredentialsMatcher(cMatcher);
	}
	/**
	 * 此方法提供认证数据的获取操作 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("===============获取用户认证信息==============");
		//1.获取用户名
		//UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		//String username = upToken.getPrincipal();
		String username = (String)token.getPrincipal();
		System.out.println("username="+username);
		//2.基于用户名执行查询操作获取用户对象
		User user = userDao.findUserByUserName(username);
		//3.对用名对象进行判定
		//3.1判定用户是否存在
		if(user==null)
			throw new UnknownAccountException();//用户名不存在
		//3.2判定用户是否被禁用
		if(user.getValid()==0)
			throw new LockedAccountException();//用户已被禁用
		//4.对用户相关信息进行(密码，盐值等)
		ByteSource credentialsSalt = //封装了一个字节数组以及一些编码操作
				ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
				user, //principal(用户新身份)
				user.getPassword(), //hashedCredentials(已加密的凭证)
				credentialsSalt, //credentialsSalt(凭证对象的盐值)
				getName());//realmName(real name)
		//5.返回封装好的数据(返回给认证管理器)
		return info;//交给认证管理器
	}
    /**
     * 此方法提供授权数据的获取操作,当我们访问系统中的一个需要
     * 授权访问的方法时,shiro框架底层会通过如下方法获取用户权限信息
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
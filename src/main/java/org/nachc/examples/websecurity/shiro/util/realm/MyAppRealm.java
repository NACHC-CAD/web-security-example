package org.nachc.examples.websecurity.shiro.util.realm;

import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAppRealm extends SimpleAccountRealm {

	/**
	 * Authentication method is based on SimpleAccountRealm doGetAuthenticationInfo(AuthenticationToken token) method.  
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		log.info("* * * DOING CUSTOM AUTHN * * *");
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		SimpleAccount account = new SimpleAccount("foo", "bar", getName());
		account.setCredentials("bar");
		account.addRole("ROLE_ADMIN");
		// account.setObjectPermissions(permissions);
		log.info("Done with custom authn");
		return account;
	}

	/**
	 * Authorization method is based on SimpleAccountRealm doGetAuthorizationInfo(PrincipalCollection principals) method.  
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("* * * DOING CUSTOM AUTHZ * * *");
	       String username = getUsername(principals);
	        USERS_LOCK.readLock().lock();
	        try {
	            SimpleAccount rtn = this.users.get(username);
	            log.info("Done with custom authz.");
	            return rtn;
	        } finally {
	            USERS_LOCK.readLock().unlock();
	        }		
	}

}

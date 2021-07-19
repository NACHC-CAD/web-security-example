package org.nachc.examples.websecurity.shiro.util.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

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
		Subject subject = SecurityUtils.getSubject();
		log.info("Got subject: " + subject);
		String isLoggedOff = subject.getSession().getAttribute("") + "";
		log.info("Is logged off: " + isLoggedOff);
		String uid = upToken.getUsername();
		String pwd = new String(upToken.getPassword());
		log.info("Doing login for user: " + uid);
		SimpleAccount account = null;
		if(uid.equals("foo") && pwd.equals("bar")) {
			account = new SimpleAccount("foo", "bar", getName());
			account.setCredentials("bar");
			account.addRole("ROLE_ADMIN");
		} else {
			account = null;
			log.info("Credentials failed for user: " + uid);
		}
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

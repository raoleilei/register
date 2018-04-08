package cn.weicao.register.util;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class DefaultCredentialsMatcher extends SimpleCredentialsMatcher{
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		Object tokenCredentials = PasswordUtil.encoder(super.toString(token.getCredentials())) ;
		Object accountCredentials = super.getCredentials(info) ;
		return super.equals(tokenCredentials,accountCredentials) ;
	}
}

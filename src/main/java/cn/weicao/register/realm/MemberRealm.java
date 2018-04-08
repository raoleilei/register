package cn.weicao.register.realm;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.weicao.register.service.IMemberService;
import cn.weicao.register.util.PasswordUtil;
import cn.weicao.register.vo.Member;

public class MemberRealm extends AuthorizingRealm{
	@Resource
	private IMemberService memberService ;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("================= 认证 ==================");
		String mid = (String)token.getPrincipal() ;
		Member member = this.memberService.get(mid) ;
		if(member == null) {
			throw new UnknownAccountException("账户‘" + mid + "’不存在。") ;
		}
		String password = PasswordUtil.encoder(new String((char[])token.getCredentials())) ;
		if(!member.getPassword().equals(password)) {
			throw new IncorrectCredentialsException("错误的用户名或密码！") ;
		}
		return new SimpleAuthenticationInfo(token.getPrincipal(),password,"memberRealm") ;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.err.println("=============== 授权 ===============");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
		String mid = (String)principals.getPrimaryPrincipal() ;
		Map<String,Set<String>> map = this.memberService.getRolesAndAction(mid) ;
		info.setRoles(map.get("allRoles"));
		info.setStringPermissions(map.get("allActions"));
		return info ;
	}

}

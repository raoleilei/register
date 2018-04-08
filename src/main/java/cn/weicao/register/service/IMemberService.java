package cn.weicao.register.service;

import java.util.Map;
import java.util.Set;

import cn.weicao.register.vo.Member;

public interface IMemberService {
	/**
	 * 根据登录编号取得登录信息
	 * @param id 登录编号
	 * @return 登录信息
	 */
	public Member get(String id) ;
	/**
	 * 根据登录编号找到登录人所属类别，而后查找对应的角色和权限
	 * @param id 登录编号
	 * @return 以map形式返回
	 * 1、key = allRoles , value 表示所有的角色信息
	 * 2、key = allActions , value 表示所有的权限信息 
	 */
	public Map<String,Set<String>> getRolesAndAction(String id) ;
}

package cn.weicao.register.dao;

import java.util.Set;

public interface IRoleDAO {
	/**
	 * 根据类别查找该登录人的所有角色
	 * @param fid 类别
	 * @return 该登录人对应的所有角色
	 */
	public Set<String> findAllByFid(Integer fid) ;
}

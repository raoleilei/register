package cn.weicao.register.dao;

import java.util.Set;

public interface IActionDAO {
	/**
	 * 根据类别查找该登录人对应的所有权限
	 * @param fid 类别
	 * @return 该登录人对应的所有权限
	 */
	public Set<String> findAllByFid(Integer fid) ;
}

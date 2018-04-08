package cn.weicao.register.dao;

import cn.weicao.register.vo.Member;

public interface IMemberDAO {
	/**
	 * 根据登录编号查找登录信息
	 * @param id 雇员编号
	 * @return 雇员信息
	 */
	public Member findById(String id) ;
}

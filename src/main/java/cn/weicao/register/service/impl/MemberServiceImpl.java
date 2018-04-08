package cn.weicao.register.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.weicao.register.dao.IActionDAO;
import cn.weicao.register.dao.IMemberDAO;
import cn.weicao.register.dao.IRoleDAO;
import cn.weicao.register.service.IMemberService;
import cn.weicao.register.service.abs.AbstractService;
import cn.weicao.register.vo.Member;
@Service
public class MemberServiceImpl extends AbstractService implements IMemberService {
	@Resource
	private IMemberDAO memberDAO ;
	@Resource
	private IRoleDAO roleDAO ;
	@Resource
	private IActionDAO actionDAO ;
	@Override
	public Member get(String id) {
		return this.memberDAO.findById(id);
	}

	@Override
	public Map<String, Set<String>> getRolesAndAction(String id) {
		Map<String,Set<String>> map = new HashMap<String,Set<String>>() ;
		Member member = this.get(id) ;
		map.put("allRoles", this.roleDAO.findAllByFid(member.getFid())) ;
		map.put("allActions", this.actionDAO.findAllByFid(member.getFid())) ;
		return map;
	}
}

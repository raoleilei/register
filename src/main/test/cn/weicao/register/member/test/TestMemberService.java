package cn.weicao.register.member.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.weicao.register.service.IMemberService;

@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMemberService {
	@Resource
	private IMemberService memberService ;
	@Test
	public void get() {
		System.err.println(this.memberService.get("1"));
	}
	@Test
	public void getAllActionAndRole() {
		System.err.println(this.memberService.getRolesAndAction("2"));
	}
}

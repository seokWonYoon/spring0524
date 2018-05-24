package kr.or.ddit.member.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.controller.MemberController;
import kr.or.ddit.member.dao.MemberDaoInf;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/spring/servlet-context.xml",
							 "classpath:kr/or/ddit/spring/application-context.xml"})
@WebAppConfiguration
public class MemberControllerTest {

	@Resource
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Resource(name="memberController")
	private MemberController memberController;
	
	@Resource(name="memberDao")
	MemberDaoInf memberDao;
	
	@Resource(name="memberService")
	MemberServiceInf memberService;
	
	@Test
	public void repositoryAnnotationBeanTest() {
		assertNotNull(memberDao);
	}
	
	@Test
	public void serviceAnnotationBeanTest() {
		assertNotNull(memberService);
		assertEquals(memberDao,memberService.getMemberDao());
		
	}
	
	@Test
	public void memberControllerTest() {
		assertNotNull(memberController);
		assertEquals(memberService,memberController.getMemberServiceInf());
		
	}

	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	@Test
	public void createTest() {
		/***Given***/
		

		/***When***/
		
		
		/***Then***/
		assertNotNull(memberController);
	}
	
	@Test
	public void WebApplicationContextTest() {
		/***Given***/
		

		/***When***/
		MemberDaoInf memberDao =ctx.getBean("memberDao", MemberDaoInf.class);
		List<MemberVO> memberList = memberDao.getMemberList();
		
		/***Then***/
		assertNotNull(memberDao);
		assertEquals(27, memberList.size());

	}
	
}

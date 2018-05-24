/**
 * 
 */
package kr.or.ddit.member.controller;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceInf;

import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
* MemberController.java
*
* @author "Y.S.W"
* @since 2018. 5. 24.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 5. 24. "Y.S.W" 최초 생성
*
* </pre>
 */
@RequestMapping("/member")
@Controller("memberController")
public class MemberController {
	Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="memberService")
	private MemberServiceInf memberService;
	
	/**
	 * 
	* Method : memberList
	* 최초작성일 : 2018. 5. 24.
	* 작성자 : "Y.S.W"
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 :localhost:8070/spring24/member/list url에 대해 처리하는 controller method
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String memberList(Model model){
		logger.debug("{}","memberList()");
		
		// service에서 조회
		List<MemberVO> memberList = memberService.getMemberList();
		
		// request에 저장
		model.addAttribute("memberList", memberList);
		
		// jsp로 전달
		return "member/memberList";
	}

	public MemberServiceInf getMemberServiceInf() {
		return memberService;
	}

}

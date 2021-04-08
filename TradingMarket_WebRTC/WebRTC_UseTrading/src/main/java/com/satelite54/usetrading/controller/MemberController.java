package com.satelite54.usetrading.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakaocert.api.KakaocertException;
import com.kakaocert.api.KakaocertService;
import com.kakaocert.api.verifyauth.RequestVerifyAuth;
import com.satelite54.usetrading.model.user.dto.UserDTO;
import com.satelite54.usetrading.service.user.IUserService;

@Controller
@RequestMapping (value = "/member")
public class MemberController {
	
	
//	@Autowired
//	private KakaocertService kakaocertService;
	
	IUserService userService;
	
	@Autowired(required=true)
	private HttpServletResponse response;
	
	@Autowired
	public MemberController(IUserService userService) {
		this.userService = userService;
	}

	  
//	  // 이용기관코드
//	  // 파트너가 등록한 이용기관의 코드, (파트너 사이트에서 확인가능)
//	  @Value("#{EXAMPLE_CONFIG.ClientCode}")
//	  private String ClientCode;
	
	@RequestMapping (value ="/login", method = RequestMethod.POST)
	private String loginAction(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printwriter = response.getWriter();
		userService.getidentify(id);
		return "/main";
	}
	
	@ResponseBody
	@RequestMapping (value="/loginfail", method = RequestMethod.POST)
	private String loginfailAction() {
		return "/page/goLogin";
	}
	
	@RequestMapping (value ="/join", method = RequestMethod.POST)
	private String joinAction(@ModelAttribute UserDTO userDTO, HttpServletRequest request) {
		
		System.out.println(userDTO.getName());
		System.out.println(userDTO.getEmail());
		System.out.println(userDTO.getPw());
		System.out.println(userDTO.getStreetAddress());
		System.out.println(userDTO.getLotAddress());
		
		int insertResult =  userService.registerUser(userDTO);
		
		return "/main";
	}
	@RequestMapping (value ="/modify")
	private String modifyAction(@ModelAttribute UserDTO userDTO, Principal principal) {
		userDTO.setEmail(principal.getName());
		int updateResult = userService.updateUser(userDTO);
		return "/main";
	}
	
//	@RequestMapping (value ="/kakaocert")
//	private String kakaocert(Model model, @ModelAttribute UserDTO userDTO) {
//	    try {
//	        // 본인인증 요청 정보 Object
//	        RequestVerifyAuth request = new RequestVerifyAuth();
//	        
//	        // 고객센터 전화번호  , 카카오톡 인증메시지 중 "고객센터" 항목에 표시
//	        request.setCallCenterNum("1600-9999");
//	        
//	        // 인증요청 만료시간(초), 최대값 : 1000  인증요청 만료시간(초) 내에 미인증시, 만료 상태로 처리됨 (권장 : 300)
//	        request.setExpires_in(300);
//	        
//	        // 수신자 생년월일, 형식 : YYYYMMDD
//	        request.setReceiverBirthDay("19700101");
//	        
//	        // 수신자 휴대폰번호  
//	        request.setReceiverHP("01012345117");
//	        
//	        // 수신자 성명 
//	        request.setReceiverName("테스트");
//	        
//	        // 인증요청 메시지 부가내용, 카카오톡 인증메시지 중 상단에 표시
//	        request.setTMSMessage("부가메시지 내용");
//	        
//	        // 별칭코드, 이용기관이 생성한 별칭코드 (파트너 사이트에서 확인가능)
//	        // 카카오톡 인증메시지 중 "요청기관" 항목에 표시
//	        // 별칭코드 미 기재시 이용기관의 이용기관명이 "요청기관" 항목에 표시
//	        request.setSubClientID("");
//	        
//	        // 인증요청 메시지 제목, 카카오톡 인증메시지 중 "요청구분" 항목에 표시
//	        request.setTMSTitle("TMS Title");
//	        
//	        // 원문, 보안을 위해 1회용으로 생성
//	        // 인증완료시, getVerifyAuthResult API의 returnToken 항목값으로 반환
//	        request.setToken("20200504-01");
//	      
//	        /*
//	        * 인증서 발급유형 선택
//	        *   true : 휴대폰 본인인증만을 이용해 인증서 발급
//	        *   false : 본인계좌 점유 인증을 이용해 인증서 발급
//	        * 
//	        * - 인증메시지를 수신한 사용자가 카카오인증 비회원일 경우,
//	        *   카카오인증 회원등록 절차를 거쳐 은행계좌 실명확인 절차이후 전자서명 가능
//	        */
//	        request.setAllowSimpleRegistYN(false);
//	      
//	        /*
//	        * 수신자 실명확인 여부  
//	        * true : 카카오페이가 본인인증을 통해 확보한 사용자 실명과 ReceiverName 값을 비교
//	        * false : 카카오페이가 본인인증을 통해 확보한 사용자 실명과 RecevierName 값을 비교하지 않음. 
//	        */
//	        request.setVerifyNameYN(true);
//	      
//	        // PayLoad, 이용기관이 API 요청마다 생성한 payload(메모) 값
//	        request.setPayLoad("memo Info");
//	        String receiptID = kakaocertService.requestVerifyAuth(ClientCode, request);
//	        model.addAttribute("receiptID", receiptID);
//	      } catch(KakaocertException ke) {
//	        System.out.println(ke.getCode());
//	        System.out.println(ke.getMessage());
//	        model.addAttribute("receiptID", "오류코드와 오류메시지를 확인하세요");
//	      }
//	      return "RequestVerifyAuth";
//	}
}

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

	  
//	  // �̿����ڵ�
//	  // ��Ʈ�ʰ� ����� �̿����� �ڵ�, (��Ʈ�� ����Ʈ���� Ȯ�ΰ���)
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
//	        // �������� ��û ���� Object
//	        RequestVerifyAuth request = new RequestVerifyAuth();
//	        
//	        // ������ ��ȭ��ȣ  , īī���� �����޽��� �� "������" �׸� ǥ��
//	        request.setCallCenterNum("1600-9999");
//	        
//	        // ������û ����ð�(��), �ִ밪 : 1000  ������û ����ð�(��) ���� ��������, ���� ���·� ó���� (���� : 300)
//	        request.setExpires_in(300);
//	        
//	        // ������ �������, ���� : YYYYMMDD
//	        request.setReceiverBirthDay("19700101");
//	        
//	        // ������ �޴�����ȣ  
//	        request.setReceiverHP("01012345117");
//	        
//	        // ������ ���� 
//	        request.setReceiverName("�׽�Ʈ");
//	        
//	        // ������û �޽��� �ΰ�����, īī���� �����޽��� �� ��ܿ� ǥ��
//	        request.setTMSMessage("�ΰ��޽��� ����");
//	        
//	        // ��Ī�ڵ�, �̿����� ������ ��Ī�ڵ� (��Ʈ�� ����Ʈ���� Ȯ�ΰ���)
//	        // īī���� �����޽��� �� "��û���" �׸� ǥ��
//	        // ��Ī�ڵ� �� ����� �̿����� �̿������� "��û���" �׸� ǥ��
//	        request.setSubClientID("");
//	        
//	        // ������û �޽��� ����, īī���� �����޽��� �� "��û����" �׸� ǥ��
//	        request.setTMSTitle("TMS Title");
//	        
//	        // ����, ������ ���� 1ȸ������ ����
//	        // �����Ϸ��, getVerifyAuthResult API�� returnToken �׸����� ��ȯ
//	        request.setToken("20200504-01");
//	      
//	        /*
//	        * ������ �߱����� ����
//	        *   true : �޴��� ������������ �̿��� ������ �߱�
//	        *   false : ���ΰ��� ���� ������ �̿��� ������ �߱�
//	        * 
//	        * - �����޽����� ������ ����ڰ� īī������ ��ȸ���� ���,
//	        *   īī������ ȸ����� ������ ���� ������� �Ǹ�Ȯ�� �������� ���ڼ��� ����
//	        */
//	        request.setAllowSimpleRegistYN(false);
//	      
//	        /*
//	        * ������ �Ǹ�Ȯ�� ����  
//	        * true : īī�����̰� ���������� ���� Ȯ���� ����� �Ǹ�� ReceiverName ���� ��
//	        * false : īī�����̰� ���������� ���� Ȯ���� ����� �Ǹ�� RecevierName ���� ������ ����. 
//	        */
//	        request.setVerifyNameYN(true);
//	      
//	        // PayLoad, �̿����� API ��û���� ������ payload(�޸�) ��
//	        request.setPayLoad("memo Info");
//	        String receiptID = kakaocertService.requestVerifyAuth(ClientCode, request);
//	        model.addAttribute("receiptID", receiptID);
//	      } catch(KakaocertException ke) {
//	        System.out.println(ke.getCode());
//	        System.out.println(ke.getMessage());
//	        model.addAttribute("receiptID", "�����ڵ�� �����޽����� Ȯ���ϼ���");
//	      }
//	      return "RequestVerifyAuth";
//	}
}

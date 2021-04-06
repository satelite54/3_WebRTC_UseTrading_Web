
package com.satelite54.usetrading.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class UserLoginFailHandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (exception instanceof AuthenticationServiceException) {
			request.setAttribute("loginFailMsg", "�������� �ʴ� ������Դϴ�.");

		} else if(exception instanceof BadCredentialsException) {
			request.setAttribute("loginFailMsg", "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�.");

		} else if(exception instanceof LockedException) {
			request.setAttribute("loginFailMsg", "��� �����Դϴ�..");

		} else if(exception instanceof DisabledException) {
			request.setAttribute("loginFailMsg", "��Ȱ��ȭ�� �����Դϴ�..");

		} else if(exception instanceof AccountExpiredException) {
			request.setAttribute("loginFailMsg", "����� �����Դϴ�..");

		} else if(exception instanceof CredentialsExpiredException) {
			request.setAttribute("loginFailMsg", "��й�ȣ�� ����Ǿ����ϴ�.");
		}

		// �α��� �������� �ٽ� ������
		RequestDispatcher dispatcher = request.getRequestDispatcher("/page/goLogin");
		dispatcher.forward(request, response);
	}
}

package com.project.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Annotation.user.UserDAO;
import com.project.Annotation.user.UserDO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserDO userDO, UserDAO userDAO, HttpSession session) {
		UserDO user = userDAO.getUser(userDO);
		
		if (user != null) {
			
//			session.setAttribute("IdKey", user.getId());
			session.setAttribute("userName", user.getName());

			return "getBoardList.do";
		} else
			System.out.println("로그인 실패");
		return "login.jsp";
	}
}

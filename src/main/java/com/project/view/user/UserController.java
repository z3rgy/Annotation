package com.project.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Annotation.user.UserDAO;
import com.project.Annotation.user.UserDO;

@Controller
public class UserController {
	
	@RequestMapping("/insertUser.do")
	public String insertUser(UserDO userDO, UserDAO userDAO) {
		userDAO.insertUser(userDO);
		return "login.jsp";
	}
}

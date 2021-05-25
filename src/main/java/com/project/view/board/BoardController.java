package com.project.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Annotation.board.BoardDAO;
import com.project.Annotation.board.BoardDO;

@Controller
public class BoardController {

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardDO boardDO, BoardDAO boardDAO, Model model, String searchField, String searchText) {
		model.addAttribute("boardList", boardDAO.getBoardList(searchField, searchText));
		return "getBoardList.jsp";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardDO boardDO, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(boardDO));
		return "getBoard.jsp";
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.insertBoard(boardDO);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.updateBoard(boardDO);
		return "getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardDO boardDO, BoardDAO boardDAO) {
		boardDAO.deleteBoard(boardDO);
		return "getBoardList.do";
	}

}
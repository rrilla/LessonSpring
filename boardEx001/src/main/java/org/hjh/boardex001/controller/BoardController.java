package org.hjh.boardex001.controller;

import javax.servlet.http.HttpServletRequest;

import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list....................................!");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/writeForm")
	public String writeForm(Model model) {
		log.info("writeForm....................................!");
		return "board/write";
	}
	
	//@PostMapping("/write")
	public String write1(HttpServletRequest request) {
		log.info("write.....................................!");
		BoardVo board = new BoardVo();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		service.register(board);
		return "board/list";
	}
	
	@PostMapping("/write")
	public String write2(BoardVo board) {
		log.info("write.....................................!");
		service.register(board);
		return "redirect:list";
	}
	
}

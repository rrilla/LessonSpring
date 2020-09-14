package org.hjh.boardex001.controller;

import javax.servlet.http.HttpServletRequest;

import org.hjh.boardex001.domain.BoardVo;
import org.hjh.boardex001.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
//	@PostMapping("/write")
//	public String write1(HttpServletRequest request) {
//		log.info("write.....................................!");
//		BoardVo board = new BoardVo();
//		board.setWriter(request.getParameter("writer"));
//		board.setTitle(request.getParameter("title"));
//		board.setContent(request.getParameter("content"));
//		service.register(board);
//		return "board/list";
//	}
	
	@PostMapping("/write")
	public String write2(BoardVo board, RedirectAttributes rttr) {
		log.info("write.....................................!");
		service.register(board);
		rttr.addFlashAttribute("resultBno", board.getBno());
		return "redirect:list";
	}
	
	@GetMapping("/remove")
	public String delete(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
	//public String delete(BoardVo bno2) {
		log.info("delete.........."+bno+".................!");
		//long bno = bno2.getBno();
		boolean flag = service.remove(bno);
		if(flag) {
			rttr.addFlashAttribute("result", "success");
			//return "redirect:list";
		}
		return "redirect:/board/list";
		
	}
	
	@PostMapping("/modify")
	public String update(BoardVo board, RedirectAttributes rttr) {
		log.info("update.....................................!");
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:list";
	}
	
	@GetMapping("/get")
	public void get(Long bno, Model model) {
		log.info("get");
		model.addAttribute("board", service.get(bno));
	}
	
}

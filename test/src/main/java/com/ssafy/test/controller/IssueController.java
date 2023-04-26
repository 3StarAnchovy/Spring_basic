package com.ssafy.test.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.ssafy.test.dto.Board;
import com.ssafy.test.dto.Detail;
import com.ssafy.test.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class IssueController {
	BoardService boardService;
	
	@Autowired
	public IssueController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping("/list")
	public String list(Model model) throws SQLException
	{
		List<Board> boardList = boardService.selectAll();
		model.addAttribute("boardList", boardList);
		System.out.println(boardList + " cont");
		return "list";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam String ano, Model model) throws SQLException
	{
		Detail board = boardService.selectByAno(ano);
		model.addAttribute("board", board);
		return "detail";
	}
	
	@GetMapping("/regist")
	public String registPage()
	{
		return "regist";
	}
	
	@PostMapping("/regist")
	public String registCar(@ModelAttribute Board board) throws SQLException
	{
		System.out.println(board);
		boardService.registCar(board);
		return "redirect:/board/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam String[] ano) throws SQLException
	{
		//System.out.println(number);
		boardService.deleteCar(ano);
		return "redirect:/board/list";
	}
}

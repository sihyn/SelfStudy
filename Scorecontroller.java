package kr.ac.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.springdb.Vo.ScoreVO;
import kr.ac.springdb.repository.ScoresRP;

@Controller
public class Scorecontroller {

	@Autowired
	ScoresRP scoresRP;

	// 전체 성적 화면(selectAll)
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<ScoreVO> scorevo = scoresRP.findAll();
		model.addAttribute("scorevo", scorevo);
		return "list";
	}

	// 개별 성적 화면(selectOne)
	@GetMapping(value = "/selectOne")
	public String list(Model model, @RequestParam("id") Integer id) {
		ScoreVO scorevo = scoresRP.findById(id).get();
		model.addAttribute("scorevo", scorevo);
		return "/selectOne";
	}

	// 점수 등록 화면
	@GetMapping(value = "/write-form")
	public String register() {
		return "/write-form";
	}

	// 점수 등록 완료(insert)
	@PostMapping(value = "/write-form")
	public String insert(Model model, @ModelAttribute("scorevo") ScoreVO scorevo) {
		scoresRP.save(scorevo);
		return "/write-result";
	}

	// 수정 사항 입력 화면
	@GetMapping(value = "/update")
	public String updateform(Model model, @RequestParam("id") Integer id) {
		ScoreVO scorevo = scoresRP.findById(id).get();
		model.addAttribute("scorevo", scorevo);
		return "/update";
	}

	// 수정 완료(update)
	@PostMapping(value = "/update")
	public String update(Model model, @ModelAttribute("scorevo") ScoreVO scorevo) {
		scoresRP.save(scorevo);
		return "redirect:/list";
	}

	// 삭제(delete)
	@GetMapping(value = "/delete")
	public String delete(Model model, @RequestParam("id") Integer id) {
		ScoreVO scorevo = scoresRP.findById(id).get();
		scoresRP.delete(scorevo);
		return "redirect:/list";
	}

}
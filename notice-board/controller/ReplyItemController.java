package kr.ac.springdb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.springdb.Vo.BoardItem;
import kr.ac.springdb.Vo.ReplyItem;
import kr.ac.springdb.repository.BoardRP;
import kr.ac.springdb.repository.ReplyRP;

@Controller
public class ReplyItemController {

	@Autowired
	BoardRP Boardrp; // list

	@Autowired
	ReplyRP replyrp; // item

	// 댓글 입력
//	@GetMapping(value = "/replyInsert")
//	public String insert(Model model, @RequestParam(value = "id") int id) {
//		model.addAttribute("listId", id);
//		return "oneview";
//	}
	@GetMapping(value = "/replyInsert")
	public String insert() {
		return "oneview";
	}

	// 댓글 입력 완료
	@PostMapping(value = "/replyInsert")
	public String replyInsert(Model model, HttpServletRequest request) {
		ReplyItem replyitems = new ReplyItem();
		BoardItem boarditems = Boardrp.findById(Integer.parseInt(request.getParameter("BoardId"))).get();
		replyitems.setName(request.getParameter("name"));
		replyitems.setContent(request.getParameter("content"));
		replyitems.setBoardItem(boarditems);
		replyrp.save(replyitems);
		return "redirect:/oneview?id=" + boarditems.getId();
	}

	// 댓글 삭제
	@GetMapping(value = "/replyDelete")
	public String replyDelete(Model model, @RequestParam("id") Integer id) {
		BoardItem boarditems = replyrp.findById(id).get().getBoardItem();
		replyrp.deleteById(id);
		return "redirect:/oneview?id=" + boarditems.getId();
	}

	// 댓글 수정
	@GetMapping(value = "/replyUpdate")
	public String replyUpdate(Model model, @RequestParam("id") Integer id) {
		ReplyItem replyitems = replyrp.findById(id).get();
		BoardItem boarditems = replyrp.findById(id).get().getBoardItem();
		model.addAttribute("board_item", boarditems);
		model.addAttribute("replyitem", replyitems);
		return "reply-update";
	}

	// 댓글 수정 완료
	@PostMapping(value = "/replyUpdate")
	public String replyUpdate(Model model, HttpServletRequest request) {
		ReplyItem replyitems = new ReplyItem();
		BoardItem boarditems = Boardrp.findById(Integer.parseInt(request.getParameter("BoardId"))).get();
		replyitems.setId(Integer.parseInt(request.getParameter("id")));
		replyitems.setName(request.getParameter("name"));
		replyitems.setContent(request.getParameter("content"));
		replyitems.setBoardItem(boarditems);
		replyrp.save(replyitems);
		return "redirect:/oneview?id=" + boarditems.getId();
	}

}

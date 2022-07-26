package kr.ac.springdb.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.springdb.Vo.BoardItem;
import kr.ac.springdb.Vo.ReplyItem;
import kr.ac.springdb.repository.BoardRP;
import kr.ac.springdb.service.BoardService;

@Controller
public class BoardItemController {
	

	@Autowired
	BoardRP boardrp;
	
	@Autowired
	BoardService boardservice;

	// list전체(selectAll)
//	@GetMapping(value = "/list")
//	public String list(Model model) {
//		List<BoardItem> board_item = boardrp.findAll();
//		model.addAttribute("board_item", board_item);
//		return "list";
//	}
	
	// list전체(selectAll)
	//@PageableDefault(size=5)->화면에서 동적으로 5개씩 보여주기
	//@RequestParam으로, currentPage에 대한 정보가 전달되지 않을 때는 디폴트로 -1을 준다. 
	//인덱스에서 list로 넘어올 때 항상 -1페이지로 되어있다.
	@RequestMapping(value = "/list")
	public String list(Model model, @PageableDefault(size=5) Pageable pageable, 
			@RequestParam(value="page", defaultValue="-1") int currentPage) {
		if (currentPage >= 0) {
			pageable = PageRequest.of(currentPage, 5);
		}
		Page<BoardItem> page = boardservice.findAll(pageable);
		List<BoardItem> pageList = page.getContent();
		
		model.addAttribute("board_item", pageList);
		model.addAttribute("p", boardservice.getPagination(pageable.getPageNumber()+1, 5, pageable.getPageSize(), boardrp.findAll().size()));
		//pageable.getPageNumber()+1 -> pageable이 갖고있는 페이지는 0부터 시작하기 때문에 1을 더해준다
		return "list";
	}

	// 게시글 등록 화면
	@GetMapping(value = "/write-form")
	public String register() {
		return "/write-form";
	}

	// 게시글 등록 완료(insert)
	@PostMapping(value = "/write-form")
	public String insert(Model model, @ModelAttribute("board_item") BoardItem board_item) {
		String Time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString();
		board_item.setTime(Time);
		boardrp.save(board_item);
		return "redirect:/list";
	}


	// 수정 사항 입력 화면
	@GetMapping(value = "/oneview")
	public String updateform(Model model, @RequestParam("id") Integer id) {
		BoardItem board_item = boardrp.findById(id).get();
		List<ReplyItem> replyItems = board_item.getReplyItem();
		model.addAttribute("board_item", board_item);
		model.addAttribute("replyItems", replyItems);
		return "/oneview";
	}

	// 수정 완료(update)
	@PostMapping(value = "/oneview")
	public String update(Model model, @ModelAttribute("board_item") BoardItem board_item) {
		String Time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString();
		board_item.setTime(Time);
		boardrp.save(board_item);
		return "redirect:/list";
	}

	// 삭제(delete)
	@GetMapping(value = "/delete")
	public String delete(Model model, @RequestParam("id") Integer id) {
		BoardItem board_item = boardrp.findById(id).get();
		boardrp.delete(board_item);
		return "redirect:/list";
	}

}

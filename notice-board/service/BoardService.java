package kr.ac.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.springdb.Vo.BoardItem;
import kr.ac.springdb.dto.Pagination;
import kr.ac.springdb.repository.BoardRP;

@Service
public class BoardService {

	@Autowired
	private BoardRP boardrp;
	
	public Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount) {
		// TODO Auto-generated method stub
		Pagination pagination = new Pagination();

		// currentPage(조건1)
		if (currentPage <= 0) {
			currentPage = 1;
		}
		
		// firstPage
		int fristPage = ((currentPage - 1) / pageSize) * pageSize + 1;
		
		// ppPage
		int ppPage = 0; 
		
		// pPage
		int pPage; 
		if (fristPage == 1) {
			pPage = fristPage;
		} else {
			pPage = fristPage - pageSize;
		}

		// lastPage
		int lastPage; 
		if (totalCount % countPerPage == 0) {
			lastPage = (totalCount / countPerPage);
		} else {
			lastPage = ((totalCount / countPerPage) + 1);
		}
		
		// currentPage(조건2)
		if (currentPage > lastPage) {
			currentPage = lastPage;
		}

		// nPage
		int nPage; 
		int nextPage = fristPage + pageSize;
		if (nextPage >= lastPage) {
			nPage = lastPage;
		} else {
			nPage = nextPage;
		}

		// endPage
		int endPage = ((currentPage - 1) / pageSize) * pageSize + pageSize;
		if (endPage > lastPage) {
			endPage = lastPage;
		}
		
		pagination.setPageSize(pageSize);
		pagination.setPpPage(ppPage);
		pagination.setpPage(pPage);
		pagination.setNnPage(lastPage);
		pagination.setnPage(nPage);
		pagination.setsPage(fristPage);
		pagination.setePage(endPage);
		
		return pagination;
	}

	public Page<BoardItem> findAll(Pageable pageable) {
		Page<BoardItem> boarditem = boardrp.findAll(pageable);
		return boarditem;
	}
	
}
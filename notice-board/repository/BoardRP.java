package kr.ac.springdb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.springdb.Vo.BoardItem;

@Repository
public interface BoardRP extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem> {

	Page<BoardItem> findAll(Pageable pageable);

}

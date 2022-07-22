package kr.ac.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.springdb.Vo.ReplyItem;

@Repository
public interface ReplyRP extends JpaRepository<ReplyItem, Integer>, JpaSpecificationExecutor<ReplyItem> {

	Optional<ReplyItem> findById(int id);
}

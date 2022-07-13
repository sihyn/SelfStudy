package kr.ac.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.springdb.Vo.ScoreVO;

@Repository
public interface ScoresRP extends JpaRepository<ScoreVO, Integer>, JpaSpecificationExecutor<ScoreVO> {
	//Repository: @Entity에 의해 생성된 DB에 접근하는 메서드(ex:findAll())들을 사용하기 위한 interface
	//extends JpaRepository로 JpaRepository를 상속받도록 함으로써 기본적인 동작이 가능해진다
	// JpaRepository<대상으로 지정할 Entity, 해당 Entity의 PK의 type>

}
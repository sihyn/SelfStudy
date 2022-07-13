package kr.ac.springdb.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// @Entity: DB의 테이블과 일대일로 매칭되는 객체 단위
// Entity객체의 인스턴스 하나가 테이블에서 하나의 레코드 값을 의미
@Entity
public class ScoreVO {
	@Id
	// @Id는 특정 속성을 기본키로 설정하는 어노테이션(테이블에서의 PK와 같은 의미)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// id값을 따로 할당하지 않아도 DB가 자동으로 AUTO_INCREMENT를 하여 기본키를 생성 >> 기본 키 생성을 DB에 위임(Mysql)
	@Column
	// @Column은 객체 필드를 테이블 컬럼과 매핑
	private Integer id; // 번호(PK)
	private String stu_name; // 학생 이름
	private Integer kor; // 국어 점수
	private Integer eng; // 영어 점수
	private Integer math; // 수학 점수

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public Integer getKor() {
		return kor;
	}

	public void setKor(Integer kor) {
		this.kor = kor;
	}

	public Integer getEng() {
		return eng;
	}

	public void setEng(Integer eng) {
		this.eng = eng;
	}

	public Integer getMath() {
		return math;
	}

	public void setMath(Integer math) {
		this.math = math;
	}

}
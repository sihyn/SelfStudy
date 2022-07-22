package kr.ac.springdb.Vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ReplyItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	private String name;
	private String content;
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "board_item_id")
	private BoardItem boarditem;

	public BoardItem getBoardItem() {
		return boarditem;
	}

	public void setBoardItem(BoardItem boarditem) {
		this.boarditem = boarditem;
	}

	@Override
	public String toString() {
		String result = "[replyitem_" + id + "]" + name;
		return result;
	}

}

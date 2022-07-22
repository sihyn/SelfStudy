package kr.ac.springdb.Vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BoardItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	private String title;
	private String content;
	private String writer;
	private String time;
//	private int pParent; //조상 id 
//	private int parent; //들여쓰기 개수 
//	private int reSeq; //답글 순서  
//	
//	public int getReSeq() {
//		return reSeq;
//	}
//
//	public void setReSeq(int reSeq) {
//		this.reSeq = reSeq;
//	}
//
//	public int getpParent() {
//		return pParent;
//	}
//
//	public void setpParent(int pParent) {
//		this.pParent = pParent;
//	}
//
//	public int getParent() {
//		return parent;
//	}
//
//	public void setParent(int parent) {
//		this.parent = parent;
//	}

	public List<ReplyItem> getReplyitem() {
		return replyitem;
	}

	public void setReplyitem(List<ReplyItem> replyitem) {
		this.replyitem = replyitem;
	}

	@PrePersist
	public void setTime() {
		this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boarditem")
	private List<ReplyItem> replyitem;

	public List<ReplyItem> getReplyItem() {
		if (replyitem == null) {
			replyitem = new ArrayList<ReplyItem>();
		}
		return replyitem;
	}

	public void setReplyItem(List<ReplyItem> replyitem) {
		this.replyitem = replyitem;
	}

	public void addReplyItem(ReplyItem r) {
		List<ReplyItem> replyitem = getReplyItem();
		replyitem.add(r);
	}

	@Override
	public String toString() {
		String result = "[" + id + "]" + writer;
		for (ReplyItem r : getReplyItem()) {
			result += "\n" + r.toString();
		}
		return result;
	}

}

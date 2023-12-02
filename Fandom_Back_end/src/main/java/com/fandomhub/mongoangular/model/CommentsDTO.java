package com.fandomhub.mongoangular.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "comments")
public class CommentsDTO {
	@Id
	private int commentid;
	private int commenterid;
	private int postid;
	private int postownerid;
	private String commentcontent;
	
	
	
	
	public CommentsDTO(int commentid, int commenterid, int postid, int postownerid, String commentcontent) {
		super();
		this.commentid = commentid;
		this.commenterid = commenterid;
		this.postid = postid;
		this.postownerid = postownerid;
		this.commentcontent = commentcontent;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getCommenterid() {
		return commenterid;
	}

	public void setCommenterid(int commenterid) {
		this.commenterid = commenterid;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getPostownerid() {
		return postownerid;
	}

	public void setPostownerid(int postownerid) {
		this.postownerid = postownerid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	
	
}

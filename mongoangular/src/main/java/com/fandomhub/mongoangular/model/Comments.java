package com.fandomhub.mongoangular.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "comments")
public class Comments {
	@Id
	private int commentid;
	private int commenterid;
	private int postid;
	private int postownerid;
	private String commentcontent;
	
	
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public int getcommentid() {
		return commentid;
	}
	public void setcommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getcommenterid() {
		return commenterid;
	}
	public void setcommenterid(int commenterid) {
		this.commenterid = commenterid;
	}
	public int getpostid() {
		return postid;
	}
	public void setpostid(int postid) {
		this.postid = postid;
	}
	public int getPostownerid() {
		return postownerid;
	}
	public void setPostownerid(int postownerid) {
		this.postownerid = postownerid;
	}
	public Comments(int commentid, int commenterid, int postid, int postownerid, String commentcontent) {
		super();
		this.commentid = commentid;
		this.commenterid = commenterid;
		this.postid = postid;
		this.postownerid = postownerid;
		this.commentcontent = commentcontent;
	}
	
	
}

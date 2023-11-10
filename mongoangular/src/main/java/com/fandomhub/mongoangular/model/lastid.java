package com.fandomhub.mongoangular.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "lastid")
public class lastid {
	@Id
	private int id;
	@Indexed(unique = true)
    private int userid;
	@Indexed(unique = true)
    private int forumid;
	@Indexed(unique = true)
    private int postid;
	@Indexed(unique = true)
    private int commentid;
    
    lastid() {
    	
    }

	public lastid(int id, int userid, int forumid, int postid, int commentid) {
		super();
		this.id = id;
		this.userid = userid;
		this.forumid = forumid;
		this.postid = postid;
		this.commentid = commentid;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

}

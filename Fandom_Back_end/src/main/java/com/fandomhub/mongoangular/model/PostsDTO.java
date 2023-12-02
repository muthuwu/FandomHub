package com.fandomhub.mongoangular.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "Posts")
public class PostsDTO {
	@Id
	private int postid;
	private int forumid;
	private int ownerid;
	private int upvote;
	private List<Integer> comments;
	private String posttitle;
	private String postcontent;
	
	public PostsDTO(int postid, int forumid, int ownerid, int upvote, List<Integer> comments, String posttitle, String postcontent) {
		super();
		this.postid = postid;
		this.forumid = forumid;
		this.ownerid = ownerid;
		this.upvote = upvote;
		this.comments = comments;
		this.posttitle = posttitle;
		this.postcontent = postcontent;
	}
	

	public int getPostid() {
		return postid;
	}
	

	public int getForumid() {
		return forumid;
	}


	public int getOwnerid() {
		return ownerid;
	}


	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}


	public int getUpvote() {
		return upvote;
	}


	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}


	public List<Integer> getComments() {
		return comments;
	}


	public void setComments(List<Integer> comments) {
		this.comments = comments;
	}


	public String getPosttitle() {
		return posttitle;
	}


	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}


	public String getPostcontent() {
		return postcontent;
	}


	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}


	public void setPostid(int postid) {
		this.postid = postid;
	}


	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

}

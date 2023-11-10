package com.fandomhub.mongoangular.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "Posts")
public class Posts {
	@Id
	private int postid;
	private int forumid;
	private int ownerid;
	private int upvote;
	private ArrayList<Integer> comments;
	private String posttitle;
	private String postcontent;
	
	Posts() {
		
	}

	public Posts(int postid, int forumid, int ownerid, int upvote, ArrayList<Integer> comments, String posttitle, String postcontent) {
		super();
		this.postid = postid;
		this.forumid = forumid;
		this.ownerid = ownerid;
		this.upvote = upvote;
		this.comments = comments;
		this.posttitle = posttitle;
		this.postcontent = postcontent;
	}
	
	
	
	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public ArrayList<Integer> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Integer> comments) {
		this.comments = comments;
	}

	public String getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
	
	
}

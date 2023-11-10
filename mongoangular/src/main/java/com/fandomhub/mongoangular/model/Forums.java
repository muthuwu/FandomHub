package com.fandomhub.mongoangular.model;

import java.util.Set;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Forums")
public class Forums {

	@Id
	private int forumid;
	private int ownerid;
	@Indexed(unique=true)
	private String forumtitle;
	private String forumdesc;
	private Set<Integer> posts;
	private Set<Integer> followers;
	
	
	
	public Forums(int forumid, int ownerid, String forumtitle, String forumdesc, Set<Integer> posts, Set<Integer> followers) {
		super();
		this.forumid = forumid;
		this.ownerid = ownerid;
		this.forumtitle = forumtitle;
		this.forumdesc = forumdesc;
		this.posts = posts;
		this.followers = followers;
	}

	

	public Set<Integer> getFollowers() {
		return followers;
	}



	public void setFollowers(Set<Integer> followers) {
		this.followers = followers;
	}



	public String getForumtitle() {
		return forumtitle;
	}



	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}



	public String getForumdesc() {
		return forumdesc;
	}



	public void setForumdesc(String forumdesc) {
		this.forumdesc = forumdesc;
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



	public Set<Integer> getPosts() {
		return posts;
	}



	public void setPosts(Set<Integer> posts) {
		this.posts = posts;
	}



	Forums () {
		
	}



}

package com.fandomhub.mongoangular.model;

import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection = "Forums")
public class ForumsDTO {

	@Id
	private int forumid;
	private int ownerid;
	@Indexed(unique=true)
	private String forumtitle;
	private String forumdesc;
	private Set<Integer> posts;
	private Set<Integer> followers;
	private int ui;
	
	public ForumsDTO(int forumid, int ownerid, String forumtitle, String forumdesc, Set<Integer> posts, Set<Integer> followers, int ui) {
		super();
		this.forumid = forumid;
		this.ownerid = ownerid;
		this.forumtitle = forumtitle;
		this.forumdesc = forumdesc;
		this.posts = posts;
		this.followers = followers;
		this.ui = ui;
	}

	





	public Set<Integer> getPosts() {
		return posts;
	}



	public int getForumid() {
		return forumid;
	}

	public Set<Integer> getFollowers() {
		return followers;
	}







	public int getOwnerid() {
		return ownerid;
	}







	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
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







	public int getUi() {
		return ui;
	}







	public void setUi(int ui) {
		this.ui = ui;
	}







	public void setForumid(int forumid) {
		this.forumid = forumid;
	}







	public void setPosts(Set<Integer> posts) {
		this.posts = posts;
	}







	public void setFollowers(Set<Integer> followers) {
		this.followers = followers;
	}



}

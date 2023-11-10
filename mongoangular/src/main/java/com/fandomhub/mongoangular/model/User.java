package com.fandomhub.mongoangular.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection="User")
public class User {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private String email;
	private String password;
	private String userDescription;
	private boolean premium;
	private ArrayList<Integer> followingForums;
	
	
	public User(int userId, String firstName, String lastName, String email, String password, String userDescription, boolean premium, ArrayList<Integer> followingForums) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userDescription = userDescription;
		this.premium = premium;
		this.followingForums = followingForums;
	}

	

	public ArrayList<Integer> getFollowingForums() {
		return followingForums;
	}



	public void setFollowingForums(ArrayList<Integer> followingForums) {
		this.followingForums = followingForums;
	}



	public String getUserDescription() {
		return userDescription;
	}



	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isPremium() {
		return premium;
	}



	public void setPremium(boolean premium) {
		this.premium = premium;
	}



	User () {
		
	}
}

package com.fandomhub.mongoangular.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Document(collection="User")
public class UserDTO {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	private long phonenumber;
	private String password;
	private String userDescription;
	private boolean premium;
	private List<Integer> followingForums;
	
	
	public UserDTO(int userId, String firstName, String lastName, long phonenumber, String password, String userDescription, boolean premium, List<Integer> followingForums) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.password = password;
		this.userDescription = userDescription;
		this.premium = premium;
		this.followingForums = followingForums;
	}

	


	public int getUserId() {
		return userId;
	}




	public List<Integer> getFollowingForums() {
		return followingForums;
	}




	public void setFollowingForums(List<Integer> followingForums) {
		this.followingForums = followingForums;
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




	public long getPhonenumber() {
		return phonenumber;
	}




	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUserDescription() {
		return userDescription;
	}




	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}




	public boolean isPremium() {
		return premium;
	}




	public void setPremium(boolean premium) {
		this.premium = premium;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}



}

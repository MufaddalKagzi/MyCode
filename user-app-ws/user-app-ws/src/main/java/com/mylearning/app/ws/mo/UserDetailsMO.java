package com.mylearning.app.ws.mo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDetailsMO {
	
	@NotNull(message ="UserId Required.")
	
	private int userId;
	@NotNull 
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Email(message ="Invallid Email.")
	private String emailId;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

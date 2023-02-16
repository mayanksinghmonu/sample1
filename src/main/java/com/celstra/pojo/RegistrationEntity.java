package com.celstra.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RegistrationEntity")
public class RegistrationEntity {

	
	private int userId;
	private String userName;
	private String password;
	private String emailId;
	private String mobileNo;
	
	@Id
	@SequenceGenerator(name = "SEQ_USERS", sequenceName = "SEQ_USERS")        
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USERS")
	@Column(name = "USERID", unique = true)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="emailId")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name="mobileno")
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public RegistrationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationEntity(int userId, String userName, String password, String emailId, String mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "RegistrationEntity [userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	
}

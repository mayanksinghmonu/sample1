package com.celstra.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users implements  Cloneable {

	private int userId;
	private String userName;
	private String password;
	private String emailId;
	private String mobileNo;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_USERS")
	@SequenceGenerator(name = "SEQ_USERS", sequenceName = "SEQ_USERS")
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
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
	
	public Users clonable()
	{
		try {
			return (Users) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
    
}

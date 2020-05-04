package com.Rest.API.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="userdetails")
public class Userdetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @GeneratedValue
	private Long id;
	
	private String  username;
	private String phonenumber;
	private String about;
	

	@OneToOne(mappedBy = "userdetails",fetch=FetchType.LAZY)
	@JsonIgnore
	
	private usercredentials usercred;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the usercred
	 */
	
	public usercredentials getUsercred() {
		return usercred;
	}
	/**
	 * @param usercred the usercred to set
	 */
	public void setUsercred(usercredentials usercred) {
		this.usercred = usercred;
	}

	
	
	

}

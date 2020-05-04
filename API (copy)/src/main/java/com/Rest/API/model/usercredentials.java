package com.Rest.API.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.hibernate.annotations.CreationTimestamp;

import com.Rest.API.AES;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
@Table(name="usercredentials")

public class usercredentials implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
   
    
	
	private String email;

	
    private String password;
@CreationTimestamp
@GeneratedValue
@JsonIgnore
private LocalDateTime Timestamp;



@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn
@JsonIgnore


private Userdetails userdetails;
@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JsonIgnore
private List<Group> groups;
public Long getId() {
	return id;
}

public LocalDateTime getTimestamp() {
	return Timestamp;
}
public String getEmail() {
	return email;
}
public usercredentials() {
	super();
	// TODO Auto-generated constructor stub
}

public usercredentials(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}

public void setEmail(String email) {
	this.email = email;
}

@JsonProperty(access = Access.WRITE_ONLY)
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = AES.encrypt(password) ;
}

public void setTimestamp(LocalDateTime timestamp) {
	Timestamp = timestamp;
}
public void setId(Long id) {
	this.id = id;
}

public Userdetails getUserdetails() {
	return userdetails;
}

public void setUserdetails(Userdetails userdetails) {
	this.userdetails = userdetails;
}

public List<Group> getGroups() {
	return groups;
}

public void setGroups(List<Group> groups) {
	this.groups = groups;
}

public void add(Group tempg)
{
	if(groups==null)
	{
		groups=new ArrayList<>();
		
	}
	groups.add(tempg);
	
}


	


}

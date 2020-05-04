package com.Rest.API.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="Groupsofusers")
public class Group {
	@Id
	@GeneratedValue
	private Long group_id;
	@NotBlank
	private String group_name;
	@CreationTimestamp
	private LocalDateTime Group_createdtimestamp;
	public Long getGroup_id() {
		return group_id;
	}
	public void setGroup_id(Long group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public LocalDateTime getGroup_createdtimestamp() {
		return Group_createdtimestamp;
	}
	public void setGroup_createdtimestamp(LocalDateTime group_createdtimestamp) {
		Group_createdtimestamp = group_createdtimestamp;
	}
	

}

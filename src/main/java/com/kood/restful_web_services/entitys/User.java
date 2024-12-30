package com.kood.restful_web_services.entitys;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2,message = "Name must be atleast 2 chars")
	@JsonProperty("user_name")
	private String name;
	@Past(message = "Birth date must be in the past")
	@JsonProperty("user_date")
	private LocalDate localDate;
	
	public User(Integer id, String name, LocalDate localDate) {
		super();
		this.id = id;
		this.name = name;
		this.localDate = localDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getLocalDate() {
		return localDate;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", localDate=" + localDate + "]";
	}
	

		
	
}

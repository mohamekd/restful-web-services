package com.kood.restful_web_services.entitys;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"email","age"}) //static filter (more than one field)
@JsonFilter("userBeanFilter")//Dynamic Filter(cons of dynamic filter: you must define filter on all APIs using the bean)
public class UserBean {
	
	private int id;
	
	private String name ;
	 
	@JsonIgnore//static filter (specific field)
	private String pass ;
	
	private String email;
	
	private int age;
	
	public UserBean(int id,String name, String pass, String email,int age) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", pass=" + pass + ", email=" + email + ", age=" + age + "]";
	}
	
}

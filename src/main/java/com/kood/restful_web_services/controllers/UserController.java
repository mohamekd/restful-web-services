package com.kood.restful_web_services.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kood.restful_web_services.daos.UserDaoService;
import com.kood.restful_web_services.entitys.User;

import jakarta.validation.Valid;

//@RestController
public class UserController {
	
	
/*
 //	@GetMapping(value =  {"hello", "egypt"} )
//	public String helloString() {
//		return "$#HELL O Egypt are the same#$";
//	}
//	@GetMapping("/egy")
//	public HelloBean hellBean() {
//		return new HellBean("$#HELL O Egypt are the same#$");
//	}
	@GetMapping("/hello/{name}")
	public User helloBeanPathingVar(@PathVariable String name) {
		return new User(String.format("$#welcome to the HELLO, %s #$",name));
	}
 * */
	UserDaoService service;
	
	public UserController(UserDaoService userDaoService) {
	super();
	this.service = userDaoService;
}

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.findAllUsers();
	}

	public User userCheck(int id) {
		User u =service.findUser(id);
		if(u==null) {
			throw new UserNotFoundError("id:"+id);
		}
		return u;
	}
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id){
		EntityModel<User> entityModel = EntityModel.of(userCheck(id));
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

//	@PostMapping("/users")
//	public void createUesr(@RequestBody User u){
//		service.addUser(u);
//	}

	@PostMapping("/users")
	public ResponseEntity<User> createUesr(@Valid @RequestBody User user){
		  try {
		        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		                .path("/{id}")
		                .buildAndExpand(service.addUser(user).getId())
		                .toUri();
		        return ResponseEntity.created(location).build();
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		    }
		  }
	@DeleteMapping("/users/{id}")
	public void removeUser(@PathVariable int id) {
		service.deleteUserById(id);
	}
}
